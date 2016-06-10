package methexample.Canvas.MainCanvas.DrawingPanel.Shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.util.List;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import methexample.Canvas.MainCanvas.DrawingPanel.Shapes.Interfaces.IItemLocateable;
import methexample.Canvas.MainCanvas.DrawingPanel.Shapes.Interfaces.IItems;

/**
 *
 * @author ΙΩΑΝΝΑ
 */
public class Rectangle implements IItems, IItemLocateable , java.io.Serializable {

    private final List<Point2D> rectangeCorners = new ArrayList<>();
    private final Rectangle2D myShape = new Rectangle2D.Double();
    private final int helperSize;

    /**
     *
     * @param p1 Top left corner of the rectangle
     * @param p2 Down right corner of the rectangle
     * @param helperSize the size of the "box" that will appear for the "resize"
     * attribute
     */
    public Rectangle(Point2D p1, Point2D p2, int helperSize) {
        this.rectangeCorners.add(p1);
        this.rectangeCorners.add(p2);
        this.helperSize = helperSize;
        generateRectangle();
    }

    private void generateRectangle() {
        myShape.setFrameFromDiagonal(rectangeCorners.get(0),
                rectangeCorners.get(1));
    }

    @Override
    public boolean isHit(Point p) {
       return myShape.contains(p);
    }

    public List<Point2D> getRectangeCorners() {
        return rectangeCorners;
    }

    public Rectangle2D getMyShape() {
        return myShape;
    }

    @Override
    public int getHelperSize() {
        return helperSize;
    }

    @Override
    public List<Point2D> getPoints() {
        return rectangeCorners;
    }

    @Override
    public void doDrawing(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        for (Point2D point : rectangeCorners) {//to mikro tetragwno
            //einai to kentro tou mikrou tetragwnou
            double x = point.getX() - helperSize / 2;
            double y = point.getY() - helperSize / 2;
            myShape.setFrame(x, y, helperSize, helperSize);//to Frame tou orizei ti megethos tha exei 
            g2.fill(myShape);
        }

        //dimiourgite kai ena tetragwno.gi auto einai ana 2         
        myShape.setFrameFromDiagonal(rectangeCorners.get(0), rectangeCorners.get(1));
        Paint tmp = g2.getPaint();
        g2.setPaint(new Color(0, 0, 100));// to xrwmma pou tha exei to tetragwno
        g2.fill(myShape);//gemizei to tetragwno
        g2.draw(myShape);//kanei to perigramma tou tetragwnou
        g2.setPaint(tmp);
    }

    @Override
    public IItems reCreate() {
        return new Rectangle(
                rectangeCorners.get(0),
                rectangeCorners.get(1),
                getHelperSize()
        );
    }

    @Override
    public int getSize() {
        return helperSize;
    }

    @Override
    public void moveItem(Point2D p) {
        Point2D p2Go = new Point();
        /*to panw to pont*/
        p2Go.setLocation(rectangeCorners.get(0).getX() + (int)p.getX(), rectangeCorners.get(0).getY() + (int)p.getY());
        rectangeCorners.set(0, new Point((Point)p2Go));
        
        /*to katw to point*/
        p2Go.setLocation(rectangeCorners.get(1).getX() + (int)p.getX() , rectangeCorners.get(1).getY() + (int)p.getY());
        rectangeCorners.set(1,new Point((Point)p2Go));
        
        generateRectangle();
    }
}
