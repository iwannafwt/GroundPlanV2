/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methexample.Canvas.MainCanvas.ToolboxPanel.Items;

import java.awt.Point;
import java.awt.geom.Rectangle2D;
import methexample.Canvas.MainCanvas.DrawingPanel.Shapes.Interfaces.IItemLocateable;
import methexample.Canvas.MainCanvas.ToolboxPanel.Items.Interfaces.IRectangle;
import methexample.Canvas.MainCanvas.ToolboxPanel.Items.Interfaces.IToolboxItems;

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
