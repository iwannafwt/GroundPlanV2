package methexample.Canvas.MainCanvas.ToolboxPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import methexample.Canvas.MainCanvas.BaseFrame;
import methexample.Canvas.MainCanvas.DrawingPanel.Shapes.Interfaces.IItems;
import methexample.Canvas.MainCanvas.Interfaces.IBaseToolboxCanvas;
import methexample.Canvas.MainCanvas.ToolboxPanel.Items.shape.Rectangle;
import methexample.Canvas.MainCanvas.ToolboxPanel.Items.shape.TriangleToolBox;
//import methexample.Canvas.MainCanvas.DrawingPanel.Shapes.Rectangle
import methexample.Canvas.MainCanvas.ToolboxPanel.MouseAdapters.MouseEvents;

/**
 *
 * @author ΙΩΑΝΝΑ
 */
public class BaseToolboxCanvas extends JPanel implements IBaseToolboxCanvas {

    private final List<Rectangle> myItems = new ArrayList<>();
    Polygon triangle = new Polygon();
    //TriangleToolBox triangle = new TriangleToolBox();
    private final BaseFrame BASEFRAME; /*prepei na einai final allla pws t kanw arxikopoisi*/ 
    
    public BaseToolboxCanvas(BaseFrame BaseFrame) {
        this.BASEFRAME = BaseFrame;
        initializeShape();
    }
    
        
    public void initializeShape() {
       myItems.add( new Rectangle(50 , 50 , 50 , 50));//i thesi pou tha briskete 
 
        //triangle.TriangleToolBox(new Point(150, 150) , new Point(150, 150) , new Point(150, 150));
               
        triangle.addPoint(250, 70);
        triangle.addPoint(80,150);
        triangle.addPoint(150, 250);
        
            addMouseListener(new MouseEvents(new methexample.Canvas.MainCanvas.DrawingPanel.Shapes.Rectangle(new Point(200,200)
                            ,new Point(310 , 310), 8),this));

        //to tetragwno
    }

    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        //i dimiourgia tou tetragwnou
        g2d.setPaint(new Color(0, 0, 100));// to xrwmma pou tha exei to tetragwno
        for(Rectangle vLookUp:myItems){
            g2d.fill(vLookUp);
        }
}
    @Override
    public void sendNewRegister(IItems newItem) {
       BASEFRAME.registerToCanvas(newItem);
    }

   @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
        g.fillPolygon(triangle);
    }

    @Override
    public void doRepaint() {
        repaint();
    }

    @Override
    public List<Rectangle> getItems() {
        return myItems;
    }
}
