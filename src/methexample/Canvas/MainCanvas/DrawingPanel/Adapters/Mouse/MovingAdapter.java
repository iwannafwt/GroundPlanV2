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
public class MovingAdapter extends MouseAdapter{
    private final IBaseDrawingCanvas iResizeHandle;
    private Point2D oldP;

    public MovingAdapter(IBaseDrawingCanvas iResizeHandle) {
        this.iResizeHandle = iResizeHandle;
    }

    @Override
    public void mousePressed(MouseEvent event) {

        Point p = event.getPoint();
        oldP = event.getPoint();//blepw pou einai to pontiki->Pressed
        Rectangle2D r = new Rectangle2D.Double();

        for (int i = 0; i < iResizeHandle.getItems().size(); i++) {
            r.setFrameFromDiagonal(iResizeHandle.getItems().get(i).getPoints()
                    .get(0), iResizeHandle.getItems().get(i).getPoints()
                            .get(1));

            if (r.contains(p)) {
                iResizeHandle.setUndo();
                iResizeHandle.setPosForItem(i);
                return;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        iResizeHandle.setPosForItem(-1);
    }

    @Override
    public void mouseDragged(MouseEvent event) {

        if (iResizeHandle.getPosForItem() == -1) {
            return;
        }

        Point2D p3 = new Point();

        p3.setLocation(event.getPoint().getX() - oldP.getX(),
                event.getPoint().getY() - oldP.getY());
        oldP = event.getPoint();//auto einai to kainourgio Pressed

        Point2D pToGo = new Point();
        pToGo.setLocation(
                iResizeHandle.getItems().get(iResizeHandle.getPosForItem())
                .getPoints().get(0).getX() + p3.getX(),
                iResizeHandle.getItems().get(iResizeHandle.getPosForItem())
                .getPoints().get(0).getY() + p3.getY());
        iResizeHandle.getItems().get(iResizeHandle.getPosForItem())
                .getPoints().set(0, new Point((Point) pToGo));

        pToGo.setLocation(
                iResizeHandle.getItems().get(iResizeHandle.getPosForItem())
                .getPoints().get(1).getX() + p3.getX(),
                iResizeHandle.getItems().get(iResizeHandle.getPosForItem())
                .getPoints().get(1).getY() + p3.getY());
        iResizeHandle.getItems().get(iResizeHandle.getPosForItem())
                .getPoints().set(1, new Point((Point) pToGo));

        iResizeHandle.doUpdate();
    }
}
