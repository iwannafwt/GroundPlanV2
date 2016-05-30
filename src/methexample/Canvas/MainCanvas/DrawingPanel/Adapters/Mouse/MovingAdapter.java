package methexample.Canvas.MainCanvas.DrawingPanel.Adapters.Mouse;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import methexample.Canvas.MainCanvas.Interfaces.IBaseDrawingCanvas;

/**
 *
 * @author ΙΩΑΝΝΑ
 */
public class MovingAdapter extends MouseAdapter {

    private final IBaseDrawingCanvas iBaseDrowingCanvas;
    private Point2D oldP;

    public MovingAdapter(IBaseDrawingCanvas iBaseDrowingCanvas) {
        this.iBaseDrowingCanvas = iBaseDrowingCanvas;
    }

    @Override
    public void mousePressed(MouseEvent event) {

        Point eventPoint = event.getPoint();
        oldP = event.getPoint();//blepw pou einai to pontiki->Pressed
        iBaseDrowingCanvas.startMovingItemContainingPoint(eventPoint);
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        iBaseDrowingCanvas.setItemToMove(null);
    }

    @Override
    public void mouseDragged(MouseEvent event) {

         if (iBaseDrowingCanvas.hasSomethingToMove()) {

            Point2D p3 = new Point();

            p3.setLocation(event.getPoint().getX() - oldP.getX(),
                    event.getPoint().getY() - oldP.getY());
            oldP = event.getPoint();//auto einai to kainourgio Pressed

            Point2D pToGo = new Point();
            pToGo.setLocation(
                    iBaseDrowingCanvas.getItemToMove()
                    .getPoints().get(0).getX() + p3.getX(),
                    iBaseDrowingCanvas.getItemToMove()
                    .getPoints().get(0).getY() + p3.getY());
            iBaseDrowingCanvas.getItemToMove()
                    .getPoints().set(0, new Point((Point) pToGo));

            pToGo.setLocation(
                    iBaseDrowingCanvas.getItemToMove()
                    .getPoints().get(1).getX() + p3.getX(),
                    iBaseDrowingCanvas.getItemToMove()
                    .getPoints().get(1).getY() + p3.getY());
            iBaseDrowingCanvas.getItemToMove()
                    .getPoints().set(1, new Point((Point) pToGo));

            iBaseDrowingCanvas.doUpdate();
        }
    }
}
