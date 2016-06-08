package methexample.Canvas.MainCanvas.ToolboxPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Shape;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import methexample.Canvas.MainCanvas.BaseFrame;
import methexample.Canvas.MainCanvas.DrawingPanel.Shapes.Triangle;
import methexample.Canvas.MainCanvas.Interfaces.IBaseToolboxCanvas;
import methexample.Canvas.MainCanvas.ToolboxPanel.Items.shape.Rectangle;
import methexample.Canvas.MainCanvas.ToolboxPanel.Items.shape.TriangleToolBox;
import methexample.Canvas.MainCanvas.ToolboxPanel.MouseAdapters.IItems;
//import methexample.Canvas.MainCanvas.DrawingPanel.Shapes.Rectangle
import methexample.Canvas.MainCanvas.ToolboxPanel.MouseAdapters.MouseEvents;

/**
 *
 * @author ΙΩΑΝΝΑ
 */
public class BaseToolboxCanvas extends JPanel implements IBaseToolboxCanvas {

    private final List<Pair<IItems,methexample.Canvas.MainCanvas.DrawingPanel.Shapes.Interfaces.IItems>> myItems = new ArrayList<>();
    //TriangleToolBox t = new TriangleToolBox();
    Polygon polygon = new Polygon();
    //TriangleToolBox triangle = new TriangleToolBox();
    private final BaseFrame BASEFRAME; /*prepei na einai final allla pws t kanw arxikopoisi*/ 
    
    public BaseToolboxCanvas(BaseFrame BaseFrame) {
        this.BASEFRAME = BaseFrame;
        initializeShape();
    }
    
    
    public void initializeShape() {
       //myItems.add( new Rectangle(50 , 50 , 50 , 50));//i thesi pou tha briskete 
        //triangle.TriangleToolBox(new Point(150, 150) , new Point(150, 150) , new Point(150, 150));
       // t.TriangleToolBox(new Point(200,20), new Point(150,200),new Point(250,200));
        polygon.addPoint(200, 20);
        polygon.addPoint(150, 200);
        polygon.addPoint(250, 200);
        myItems.add(new Pair(new Rectangle(50 , 50 , 50 , 50),new methexample.Canvas.MainCanvas.DrawingPanel.Shapes.Rectangle(new Point(200,200)
                            ,new Point(310 , 310), 8)));
        myItems.add(new Pair(new TriangleToolBox(new Point(200, 20),new Point(150, 200), new Point(250, 200)) ,new Triangle(new Point(100, 10),new Point(50, 100), new Point(150, 100), 8)));
        //   addMouseListener(new MouseEvents(new methexample.Canvas.MainCanvas.DrawingPanel.Shapes.Rectangle(new Point(200,200)
        //                    ,new Point(310 , 310), 8),this));
        // addMouseListener(new MouseEvents(new Triangle(new Point(100, 10),new Point(50, 100), new Point(150, 100), 8), this));
        //to tetragwno
        addMouseListener(new MouseEvents(this));
    }

    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        //i dimiourgia tou tetragwnou
        g2d.setPaint(new Color(0, 0, 100));// to xrwmma pou tha exei to tetragwno
        for(Pair<IItems,methexample.Canvas.MainCanvas.DrawingPanel.Shapes.Interfaces.IItems> vLookUp:myItems){
            g2d.fill((Shape)vLookUp.getLeft());
        }
        
}
    @Override
    public void sendNewRegister(methexample.Canvas.MainCanvas.DrawingPanel.Shapes.Interfaces.IItems newItem) {
       BASEFRAME.registerToCanvas(newItem);
    }

   @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
        g.fillPolygon(polygon);
    }

    @Override
    public void doRepaint() {
        repaint();
    }

    @Override
    public List<Pair<IItems,methexample.Canvas.MainCanvas.DrawingPanel.Shapes.Interfaces.IItems>> getItems() {
        return myItems;
    }
}
