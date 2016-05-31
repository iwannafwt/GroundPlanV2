package methexample.Canvas.MainCanvas.ToolboxPanel.Items.shape;

import java.awt.Point;
import java.awt.geom.Rectangle2D;
import methexample.Canvas.MainCanvas.DrawingPanel.Shapes.Interfaces.IItemLocateable;

/**
 *
 * @author ΙΩΑΝΝΑ
 */
public class Rectangle extends Rectangle2D.Float implements IItemLocateable{
    //einai to RectangleConst
    
    public Rectangle(float x, float y, float width, float height) {

        setRect(x, y, width, height);
    }

    public void addX(float x) {

        this.x += x;
    }

    public void addY(float y) {

        this.y += y;
    }

    public void addWidth(float w) {

        this.width += w;
    }

    public void addHeight(float h) {

        this.height += h;
    }

    @Override
    public boolean isHit(Point p) {
        
        double a = p.getX();
        double b = p.getY();
        
        return true;
    }

}
