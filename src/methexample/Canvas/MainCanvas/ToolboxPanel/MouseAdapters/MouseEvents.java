package methexample.Canvas.MainCanvas.ToolboxPanel.MouseAdapters;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import methexample.Canvas.MainCanvas.DrawingPanel.Shapes.Interfaces.IItemLocateable;
import methexample.Canvas.MainCanvas.Interfaces.IBaseToolboxCanvas;
import methexample.Canvas.MainCanvas.ToolboxPanel.Pair;

/**
 *
 * @author ΙΩΑΝΝΑ
 */
public class MouseEvents implements MouseListener {

    //private final IItems items;
    private final IBaseToolboxCanvas toolboxItems;
    boolean clicked;

    public MouseEvents(/*IItems myItem,*/ IBaseToolboxCanvas toolboxItems) {
        this.toolboxItems = toolboxItems;
        //this.items = myItem;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for (/*IItemLocateable*/ Pair<IItems,methexample.Canvas.MainCanvas.DrawingPanel.Shapes.Interfaces.IItems>
                vLookUp : toolboxItems.getItems()) {
            if (((IItemLocateable)vLookUp.getLeft()).isHit(e.getPoint())) {
                toolboxItems.sendNewRegister(/*items*/vLookUp.getRight());
            }
        }

        clicked = true;


    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        clicked = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public boolean isClicked() {

        return clicked;
    }

}
