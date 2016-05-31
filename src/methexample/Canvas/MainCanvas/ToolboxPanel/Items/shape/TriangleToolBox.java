package methexample.Canvas.MainCanvas.ToolboxPanel.Items.shape;

import java.awt.Point;
import java.awt.Polygon;
import methexample.Canvas.MainCanvas.DrawingPanel.Shapes.Interfaces.IItemLocateable;

/**
 *
 * @author ΙΩΑΝΝΑ
 */
public class TriangleToolBox implements IItemLocateable{
    private Polygon polygon;
    

    @Override
    public boolean isHit(Point p) {
                
        double a = p.getX();
        double b = p.getY();
        
        return true;
    }
    
    public Polygon TriangleToolBox(Point p1 , Point p2 , Point p3){
        polygon = new Polygon();
        
        polygon.addPoint(p1.x, p1.y);
        polygon.addPoint(p2.x, p2.y);
        polygon.addPoint(p3.x, p3.y);
 return polygon;

    }
    
}
