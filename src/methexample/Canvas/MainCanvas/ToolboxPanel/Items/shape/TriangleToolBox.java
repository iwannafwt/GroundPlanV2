package methexample.Canvas.MainCanvas.ToolboxPanel.Items.shape;

import java.awt.Point;
import java.awt.Polygon;
import methexample.Canvas.MainCanvas.DrawingPanel.Shapes.Interfaces.IItemLocateable;
import methexample.Canvas.MainCanvas.ToolboxPanel.MouseAdapters.IItems;

/**
 *
 * @author ΙΩΑΝΝΑ
 */
public class TriangleToolBox extends Polygon implements IItemLocateable,IItems{
//    private Polygon polygon;
    

    @Override
    public boolean isHit(Point p) {
        
        return contains(p);
    }
    
    public TriangleToolBox(Point p1 , Point p2 , Point p3){

        
        addPoint(p1.x, p1.y);
        addPoint(p2.x, p2.y);
        addPoint(p3.x, p3.y);
        

    }

}
