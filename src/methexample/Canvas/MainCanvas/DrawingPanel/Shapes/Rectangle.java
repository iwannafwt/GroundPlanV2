/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methexample.Canvas.MainCanvas.DrawingPanel.Shapes;

import java.awt.Graphics;
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
public class Rectangle implements IItems, IItemLocateable {
    private final List<Point2D> rectangeCorners = new ArrayList<>();
    private final Rectangle2D myShape = new Rectangle2D.Double();
    private final int helperSize;
    
    /**
     * 
     * @param p1 Top left corner of the rectangle
     * @param p2 Down right corner of the rectangle
     * @param helperSize the size of the "box" that will appear for the "resize" attribute
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IItems reCreate() {
        return new Rectangle(
                rectangeCorners.get(0),
                rectangeCorners.get(1),
                getHelperSize()
        );
    }
    
}
