package methexample.Canvas.MainCanvas.DrawingPanel.Shapes;

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
public class Triangle implements IItems, IItemLocateable , java.io.Serializable{
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
   
        return myShape.contains(p);
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
            double x = point.getX() - helperSize / 2;
            double y = point.getY() - helperSize / 2;
            
            g2.fill(myShape);
        }
        Polygon p = new Polygon();
        for (int i = 0; i < 3; i++){
            /*allagi twn diastasew tou trigwnou*/
            p.addPoint((int) (100 + 50 * Math.cos(i * 2 * Math.PI / 5)),
                    (int) (100 + 50 * Math.sin(i * 2 * Math.PI / 5)));
           
        }
        
        
//        polygon = new Polygon();
////        polygon.addPoint(100, 10);
////        polygon.addPoint(50, 100);
////        polygon.addPoint(150, 100);
//        polygon.addPoint((int)this.triangleCorners.get(0).getX(),(int)this.triangleCorners.get(0).getY());
//        polygon.addPoint((int)this.triangleCorners.get(1).getX(),(int)this.triangleCorners.get(1).getY());
//        polygon.addPoint((int)this.triangleCorners.get(2).getX(),(int)this.triangleCorners.get(2).getY());
//     
//        g.fillPolygon(polygon);
//        g.drawPolygon(polygon);
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
}
