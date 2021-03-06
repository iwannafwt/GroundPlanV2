/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methexample.Canvas.MainCanvas.DrawingPanel.Shapes;

import java.awt.Graphics;
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
public class Circle implements IItems, IItemLocateable {
    private Point circleCenter;
    private int circleRadius;
    private final int helperSize;
    
    /**
     * 
     * @param p Circle center
     * @param r Circle radius to draw
     * @param s the size of the "box" that will appear for the "resize" attribute
     */
    public Circle(Point p, Integer r, Integer s) {
        this.circleCenter = p;
        this.circleRadius = r;
        this.helperSize = s;
    }

    @Override
    public boolean isHit(Point p) {
                        
        double a = p.getX();
        double b = p.getY();
        
        return true;
    }

    public Point getCircleCenter() {
        return circleCenter;
    }

    public void setCircleCenter(Point circleCenter) {
        this.circleCenter = circleCenter;
    }

    public Integer getCircleRadius() {
        return circleRadius;
    }

    public void setCircleRadius(Integer circleRadius) {
        this.circleRadius = circleRadius;
    }

    @Override
    public int getHelperSize() {
        return helperSize;
    }

    @Override
    public List<Point2D> getPoints() {
        List<Point2D> temporaryList = new ArrayList<>();
        temporaryList.add(circleCenter);
        
        return temporaryList;
    }

    @Override
    public void doDrawing(Graphics g) {
        Polygon s = new Polygon();
            for (int i = 0; i < 360; i++) {
                double t = i / 360.0;
                s.addPoint((int) (150 + 50 * t * Math.cos(8 * t * Math.PI)),
                    (int) (150 + 50 * t * Math.sin(8 * t * Math.PI)));
        }
        g.fillPolygon(s);
        g.drawPolygon(s);
    }

    @Override
    public IItems reCreate() {
        return new Circle(
                circleCenter,
                circleRadius,
                helperSize
        );
    }

    @Override
    public int getSize() {
        return helperSize;
    }

    @Override
    public void moveItem(Point2D p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
