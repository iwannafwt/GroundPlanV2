package methexample.Canvas.MainCanvas.DrawingPanel.Adapters.Mouse;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import methexample.Canvas.MainCanvas.DrawingPanel.Shapes.Interfaces.IItemLocateable;
import methexample.Canvas.MainCanvas.DrawingPanel.Shapes.Interfaces.IItems;
import methexample.Canvas.MainCanvas.Interfaces.IBaseDrawingCanvas;

/**
 *
 * @author ΙΩΑΝΝΑ
 */
public class MovingAdapter extends MouseAdapter {

    private final IBaseDrawingCanvas iBaseDrawingCanvas;
    private Point2D oldP;
    List<IItems> myItems = new ArrayList<>();


    public MovingAdapter(IBaseDrawingCanvas iResizeHandle) {
        this.iBaseDrawingCanvas = iResizeHandle;
    }

    @Override
    public void mousePressed(MouseEvent event) {
        
        for(IItems vLookUp : iBaseDrawingCanvas.getItems()){
            if ( ((IItemLocateable)vLookUp).isHit(event.getPoint()) ) {                
                iBaseDrawingCanvas.setUndo();
                iBaseDrawingCanvas.setItemForMoving(vLookUp);
                oldP = event.getPoint();
                return;
            }
        }

//        Point p = event.getPoint();
//        oldP = event.getPoint();//blepw pou einai to pontiki->Pressed
//        Rectangle2D r = new Rectangle2D.Double();
//
//        for (int i = 0; i < iBaseDrawingCanvas.getItems().size(); i++) {
//            r.setFrameFromDiagonal(iBaseDrawingCanvas.getItems().get(i).getPoints()
//                    .get(0), iBaseDrawingCanvas.getItems().get(i).getPoints()
//                    .get(1));
//
//            if (r.contains(p)) {
//                iBaseDrawingCanvas.setUndo();
//                iBaseDrawingCanvas.setPosForItem(i);
//                return;
//            }
//        }
}

    @Override
    public void mouseReleased(MouseEvent event) {
        iBaseDrawingCanvas.setItemForMoving(null);
    }

    @Override
    public void mouseDragged(MouseEvent event) {

        if (iBaseDrawingCanvas.getItemForMoving() == null) {
            return;
        }
        /*310-300=10 to mouseMoveDistance einai to 10*/
        Point2D mouseMovedDistance = new Point();/*poso kounithike to pontiki*/

        mouseMovedDistance.setLocation(event.getPoint().getX() - oldP.getX(),
                event.getPoint().getY() - oldP.getY());
        oldP = event.getPoint();//auto einai to kainourgio Pressed
        
        iBaseDrawingCanvas.getItemForMoving().moveItem(mouseMovedDistance);
        
//        Point2D pToGo = new Point();/*panw gwnia*/
//        pToGo.setLocation(iBaseDrawingCanvas.getItems().get(iBaseDrawingCanvas.getPosForItem())
//                .getPoints().get(0).getX() + mouseMovedDistance.getX(),
//                iBaseDrawingCanvas.getItems().get(iBaseDrawingCanvas.getPosForItem())
//                .getPoints().get(0).getY() + mouseMovedDistance.getY());
//        iBaseDrawingCanvas.getItems().get(iBaseDrawingCanvas.getPosForItem())
//                .getPoints().set(0, new Point((Point) pToGo));
//        
//        /*katw gwnia*/
//        pToGo.setLocation(iBaseDrawingCanvas.getItems().get(iBaseDrawingCanvas.getPosForItem())
//                .getPoints().get(1).getX() + mouseMovedDistance.getX(),
//                iBaseDrawingCanvas.getItems().get(iBaseDrawingCanvas.getPosForItem())
//                .getPoints().get(1).getY() + mouseMovedDistance.getY());
//        iBaseDrawingCanvas.getItems().get(iBaseDrawingCanvas.getPosForItem())
//                .getPoints().set(1, new Point((Point) pToGo));
//
        iBaseDrawingCanvas.doUpdate();
    }
}
