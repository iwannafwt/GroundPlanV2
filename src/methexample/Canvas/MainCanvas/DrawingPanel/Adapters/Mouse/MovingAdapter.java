package methexample.Canvas.MainCanvas.DrawingPanel.Adapters.Mouse;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import methexample.Canvas.MainCanvas.Interfaces.IBaseDrawingCanvas;

/**
 *
 * @author ΙΩΑΝΝΑ
 */
public class MovingAdapter extends MouseAdapter {

    private final IBaseDrawingCanvas iBaseDrawingCanvas;
    private Point2D oldP;


    public MovingAdapter(IBaseDrawingCanvas iResizeHandle) {
        this.iBaseDrawingCanvas = iResizeHandle;
    }

    @Override
    public void mousePressed(MouseEvent event) {

        Point p = event.getPoint();
        oldP = event.getPoint();//blepw pou einai to pontiki->Pressed
        Rectangle2D r = new Rectangle2D.Double();

        for (int i = 0; i < iBaseDrawingCanvas.getItems().size(); i++) {
            r.setFrameFromDiagonal(iBaseDrawingCanvas.getItems().get(i).getPoints()
                    .get(0), iBaseDrawingCanvas.getItems().get(i).getPoints()
                    .get(1));

            if (r.contains(p)) {
                iBaseDrawingCanvas.setUndo();
                iBaseDrawingCanvas.setPosForItem(i);
                return;
            }
        }
}

    @Override
    public void mouseReleased(MouseEvent event) {
        iBaseDrawingCanvas.setPosForItem(-1);
    }

    @Override
    public void mouseDragged(MouseEvent event) {

        if (iBaseDrawingCanvas.getPosForItem() == -1) {
            return;
        }

        Point2D mouseMovedDistance = new Point();/*poso kounithike to pontiki*/

        mouseMovedDistance.setLocation(event.getPoint().getX() - oldP.getX(),
                event.getPoint().getY() - oldP.getY());
        oldP = event.getPoint();//auto einai to kainourgio Pressed

        Point2D pToGo = new Point();/*panw gwnia*/
        pToGo.setLocation(iBaseDrawingCanvas.getItems().get(iBaseDrawingCanvas.getPosForItem())
                .getPoints().get(0).getX() + mouseMovedDistance.getX(),
                iBaseDrawingCanvas.getItems().get(iBaseDrawingCanvas.getPosForItem())
                .getPoints().get(0).getY() + mouseMovedDistance.getY());
        iBaseDrawingCanvas.getItems().get(iBaseDrawingCanvas.getPosForItem())
                .getPoints().set(0, new Point((Point) pToGo));
        
        /*katw gwnia*/
        pToGo.setLocation(iBaseDrawingCanvas.getItems().get(iBaseDrawingCanvas.getPosForItem())
                .getPoints().get(1).getX() + mouseMovedDistance.getX(),
                iBaseDrawingCanvas.getItems().get(iBaseDrawingCanvas.getPosForItem())
                .getPoints().get(1).getY() + mouseMovedDistance.getY());
        iBaseDrawingCanvas.getItems().get(iBaseDrawingCanvas.getPosForItem())
                .getPoints().set(1, new Point((Point) pToGo));

        iBaseDrawingCanvas.doUpdate();
    }
}
