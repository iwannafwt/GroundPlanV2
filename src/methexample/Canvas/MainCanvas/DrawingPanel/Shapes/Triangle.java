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
public class Triangle implements IItems, IItemLocateable {
    private final List<Point2D> triangleCorners = new ArrayList<>();
    private final Polygon myShape = new Polygon();
    private final int helperSize;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doDrawing(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
}
