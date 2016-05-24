package methexample.Canvas.MainCanvas.DrawingPanel.Shapes.Interfaces;

import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.util.List;

/**
 *
 * @author ΙΩΑΝΝΑ
 */
public interface IItems {
    List<Point2D> getPoints();
    void doDrawing(Graphics g);
    int getHelperSize();
    IItems reCreate();
}
