package methexample.Canvas.MainCanvas.DrawingPanel.Shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import methexample.Canvas.MainCanvas.DrawingPanel.Shapes.Interfaces.IItemLocateable;
import methexample.Canvas.MainCanvas.DrawingPanel.Shapes.Interfaces.IItems;

/**
 *
 * @author ΙΩΑΝΝΑ
 */
public class Triangle implements IItems, IItemLocateable {
    private final List<Point2D> triangleCorners = new ArrayList<>();
    private final Polygon myShape = new Polygon();
    private final int helperSize;
    private Polygon polygon;

    /**
     * 
     * @param p1 First triangle corner
     * @param p2 Second triangle corner
     * @param p3 Third triangle corner
     * @param helperSize the size of the "box" that will appear for the "resize" attribute
     */
    public Triangle(Point p1, Point p2, Point p3, int helperSize) {
        this.triangleCorners.add(p1);
        this.triangleCorners.add(p2);
        this.triangleCorners.add(p3);
        this.helperSize = helperSize;
        generatePolygon();
    }
    
    private void generatePolygon() {
        for(Point2D vLookUp:triangleCorners){
            myShape.addPoint((int)vLookUp.getX(), 
                    (int)vLookUp.getY());
        }        
    }
    
    @Override
    public boolean isHit(Point p) {
                
        double a = p.getX();
        double b = p.getY();
        
        return true;
    }

    public List<Point2D> getTriangleCorners() {
        return triangleCorners;
    }

    public Polygon getMyShape() {
        return myShape;
    }

    @Override
    public int getHelperSize() {
        return helperSize;
    }    

    @Override
    public List<Point2D> getPoints() {
        return triangleCorners;
    }

    @Override
    public void doDrawing(Graphics g) {
        
        Graphics2D g2 = (Graphics2D) g;
        
        for (Point2D point : triangleCorners) {//to mikro tetragwno
            //einai to kentro tou mikrou tetragwnou
            //double x = point.getX() - helperSize / 2;
            //double y = point.getY() - helperSize / 2;
            
            g2.fill(myShape);
        }
        Polygon p = new Polygon();
        for (int i = 0; i < 3; i++){
            p.addPoint((int) (100 + 50 * Math.cos(i * 2 * Math.PI / 5)),
                    (int) (100 + 50 * Math.sin(i * 2 * Math.PI / 5)));
        }
     
        g.fillPolygon(p);
        g.drawPolygon(p);
    }

    @Override
    public IItems reCreate() {
        return new Triangle(
                (Point)triangleCorners.get(0), 
                (Point)triangleCorners.get(1),
                (Point)triangleCorners.get(2), 
                getHelperSize()
        );
    }

    @Override
    public int getSize() {
        return helperSize;
    }
    
    @Override
    public boolean containsPoint(Point2D points){
        return true; /*Not Supportet yet*/
    }
}
