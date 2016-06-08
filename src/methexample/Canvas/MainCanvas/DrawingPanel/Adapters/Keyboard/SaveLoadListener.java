/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methexample.Canvas.MainCanvas.DrawingPanel.Adapters.Keyboard;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import methexample.Canvas.MainCanvas.DrawingPanel.options.Load;
import methexample.Canvas.MainCanvas.DrawingPanel.options.Save;

/**
 *
 * @author ΙΩΑΝΝΑ
 */
public class SaveLoadListener extends KeyAdapter{
    
    Save save = new Save();
    Load load = new Load();
    
    
    @Override
    public void keyPressed(KeyEvent e) {
        if ((e.getKeyCode() == KeyEvent.VK_S) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
            save.save();
        } else if ((e.getKeyCode() == KeyEvent.VK_L) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
            load.load();
        }

    }
    
}
