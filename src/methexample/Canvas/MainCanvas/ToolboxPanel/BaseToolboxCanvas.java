/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methexample.Canvas.MainCanvas.ToolboxPanel;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import methexample.Canvas.MainCanvas.BaseFrame;
import methexample.Canvas.MainCanvas.DrawingPanel.Shapes.Interfaces.IItems;
import methexample.Canvas.MainCanvas.DrawingPanel.Shapes.Rectangle;
import methexample.Canvas.MainCanvas.Interfaces.IBaseToolboxCanvas;
import methexample.Canvas.MainCanvas.ToolboxPanel.Items.Interfaces.IToolboxItems;
import methexample.Canvas.MainCanvas.ToolboxPanel.MouseAdapters.MouseEvents;

/**
 *
 * @author ΙΩΑΝΝΑ
 */
public class BaseToolboxCanvas extends JPanel implements IBaseToolboxCanvas {

    private final List<IToolboxItems> myItems = new ArrayList<>();
    private final BaseFrame BASEFRAME;
    
        
    public void initializeShape() {
       myItems.add( new Rectangle(new Point(50, 50), new Point(50, 50));//i thesi pou tha briskete 
        
        
        addMouseListener(new MouseEvents(new Rectangle( 
              new Point(200, 200), new Point(310, 310), 8),this));
        //to tetragwno
    }

    @Override
    public void sendNewRegister(IItems newItem) {
        this.BASEFRAME = BaseFrame;
        initializeShape();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

    @Override
    public void doRepaint() {
        repaint();
    }

    @Override
    public List<IToolboxItems> getItems() {
        return myItems;
    }


}
