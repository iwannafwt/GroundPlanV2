package methexample.Canvas.MainCanvas.ToolboxPanel.MouseAdapters;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import methexample.Canvas.MainCanvas.DrawingPanel.Shapes.Interfaces.IItemLocateable;
import methexample.Canvas.MainCanvas.DrawingPanel.Shapes.Interfaces.IItems;
import methexample.Canvas.MainCanvas.ToolboxPanel.Items.Interfaces.IToolboxItems;
import methexample.Canvas.MainCanvas.ToolboxPanel.Items.Rectangle;

/**
 *
 * @author ΙΩΑΝΝΑ
 */
public class MouseEvents implements MouseListener {

    private final IItems items;
    private final IToolboxItems toolboxItems;
    boolean clicked;

    public MouseEvents(IItems myItem, IToolboxItems toolboxItems) {
        this.toolboxItems = toolboxItems;
        this.items = myItem;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for (IItemLocateable vLookUp : toolboxItems.getItems()) {
            if (vLookUp.isHit(e.getPoint())) {
                toolboxItems.sendNewRegister(items);
            }
        }

        clicked = true;

        System.out.println("einai ston MouseEvent For ToolBox");

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
