package methexample.Canvas.MainCanvas.DrawingPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import methexample.Canvas.MainCanvas.DrawingPanel.Background.Background;
import methexample.Canvas.MainCanvas.DrawingPanel.Shapes.Interfaces.IItems;
import methexample.Canvas.MainCanvas.DrawingPanel.Shapes.Rectangle;
import methexample.Canvas.MainCanvas.DrawingPanel.Shapes.Triangle;
import methexample.Canvas.MainCanvas.Interfaces.IBaseDrawingCanvas;

/**
 *
 * @author ΙΩΑΝΝΑ
 */
public class BaseDrawingCanvas extends JPanel implements IBaseDrawingCanvas {

    private List<IItems> myItemsList = new ArrayList<>();

    private List<IItems> undoItemsList = new ArrayList<>();
    private List<IItems> redoItemsList = new ArrayList<>();

    private final int SIZE = 8;//to megethos apo to mikro tetragwnaki
    private int pos;
    private int posCorner;
    
    private IItems itemToMove;
    
    private IItems polygon;
    private IItems circle;
    private IItems rectangleOne;
    private IItems rectangleTwo;
    //<editor-fold desc="GettersSetters" defaultstate="collapsed">

//    public void setPosForItem(int posForItem) {
//        this.posForItem = posForItem;
//    }
    @Override
    public int getSIZE() {
        return SIZE;
    }

    @Override
    public int getPos() {
        return pos;
    }

    @Override
    public void setPos(int pos) {
        this.pos = pos;
    }

    @Override
    public int getPosCorner() {
        return posCorner;
    }
    
    
    @Override
    public void setPosCorner(int posForItem) {
        this.posCorner = posCorner;
    }

   
    
    @Override
    public IItems getItemForMoving() {
        return itemToMove;
    }
    
    @Override
    public void setItemForMoving(IItems itemToMove) {
        this.itemToMove = itemToMove;
    }
     //</editor-fold>

    public BaseDrawingCanvas(int x1, int x2, int y1, int y2) {
        initUI(x1, x2, y1, y2);
    }

    private void initUI(int x1, int x2, int y1, int y2) {

        itemToMove = null;
        pos = -1;//otan to position einai -1 simenei oti exoume 
        //kseklikarei to pontiki 
        rectangleOne = new Rectangle(new Point(x1 * 4, y1 * 4), new Point(x2 * 4, y2 * 4), 8);
        rectangleTwo = new Rectangle(new Point(x1 * 2, y1 * 2), new Point(x2 * 2, y2 * 2), 8);
        //circle = new Circle(new Point(x1*8, y1*8),0, 0);
        Triangle triangle = new Triangle(new Point(100, 10),new Point(50, 100), new Point(150, 100), 8);

        setItems(triangle);
        setItems(rectangleOne);
        setItems(rectangleTwo);
        //setItems(polygon);
        //setItems(circle);
        setUndo();
        /*ta point enai i diagwnios
         *--------*
         |        |
         |        |
         |        |
         |        |
         *--------*
         */
    }
    
    private void doDrawing(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Background backGround = new Background();

        backGround.backgroundColour(1500, 1500, 80, 80, g2);


        g2.setColor(Color.red);//to xrwmma apo ta mikra ta tetragwnakia

        setBackground(Color.gray);

        for (IItems vLookUp : myItemsList) {
            vLookUp.doDrawing(g2);
        }

        /*----------------- Error sto undo kai Redo-------*/
//        rectangleOne.doDrawing(g);
//        rectangleTwo.doDrawing(g);
        /*------------------------------------------------*/

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

    @Override
    public void doUpdate() {
        repaint();
    }

    @Override
    public void registerItem(IItems newItem) {
        setUndo();
        setItems(newItem.reCreate()); //kanoume reCreate gia na spasoume to reference
        doUpdate();
    }

    @Override
    public List<IItems> getItems() {
        return myItemsList;
    }

    @Override
    public int getHelperSize() {
        return SIZE;
    }

    @Override
    public void registerMouseListeners(MouseAdapter MA) {
        addMouseListener(MA);//sinartisi tou JPanel
        addMouseMotionListener(MA);//sinartisi tou JPanel
    }


    @Override
    public boolean undo() {
        if (undoItemsList == null || undoItemsList.isEmpty()) {
            return false;
        }
        redoItemsList.clear(); //katharizei ti lista redo gia na parei ts kainourgies times       
        for (IItems vLookUp : myItemsList) {
            redoItemsList.add(vLookUp.reCreate());//sti lista redo krataei ta 
            //points pou exoun ta tetragwna epanw sto canva
        }

        myItemsList.clear(); //katharizei ti lista apo ta items
        for (IItems vLookUp : undoItemsList) {
            myItemsList.add(vLookUp.reCreate());//prosthetei mesa sti list myItems 
            //ta point pou exei i lista undo
        }

        doUpdate();

        return true;
    }

    @Override
    public boolean redo() {
        if (redoItemsList == null || redoItemsList.isEmpty()) {
            return false;
        }
        myItemsList.clear();
        for (IItems vLookUp : redoItemsList) {
            myItemsList.add(vLookUp.reCreate());
        }
        doUpdate();

        return true;
    }

    @Override
    public void setUndo() {
        undoItemsList.clear();
        for (IItems vLookUp : myItemsList) {
            undoItemsList.add(vLookUp.reCreate());
        }

    }


    public void setItems(IItems newItem) {
        myItemsList.add(newItem);
    }
}
