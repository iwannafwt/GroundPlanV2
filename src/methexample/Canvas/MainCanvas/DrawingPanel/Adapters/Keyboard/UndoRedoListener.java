package methexample.Canvas.MainCanvas.DrawingPanel.Adapters.Keyboard;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import methexample.Canvas.MainCanvas.BaseFrame;

/**
 *
 * @author ΙΩΑΝΝΑ
 */
public class UndoRedoListener extends KeyAdapter {

    private final BaseFrame baseFrame;

    public UndoRedoListener(BaseFrame baseFrame) {
        this.baseFrame = baseFrame;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        super.keyReleased(e); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if ((e.getKeyCode() == KeyEvent.VK_Z) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
            baseFrame.undo();//redo sinartisi pou kaname emeis st baseFrame
        } else if ((e.getKeyCode() == KeyEvent.VK_U) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
            baseFrame.redo();//redo sinartisi pou kaname emeis st baseFrame
        }
    }
}
