package methexample.Canvas.MainCanvas.DrawingPanel.Adapters.Keyboard;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import methexample.Canvas.MainCanvas.DrawingPanel.options.New;

/**
 *
 * @author ΙΩΑΝΝΑ
 */
public class NewListener extends KeyAdapter {

    New newProject = new New();

    @Override
    public void keyPressed(KeyEvent e) {
        if ((e.getKeyCode() == KeyEvent.VK_N) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
            newProject.newProject();
        }
    }
}
