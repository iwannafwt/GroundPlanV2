package methexample.Canvas.MainCanvas;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import methexample.Canvas.MainCanvas.DrawingPanel.Adapters.Keyboard.NewListener;
import methexample.Canvas.MainCanvas.DrawingPanel.Adapters.Keyboard.SaveLoadListener;
import methexample.Canvas.MainCanvas.DrawingPanel.Adapters.Keyboard.UndoRedoListener;
import methexample.Canvas.MainCanvas.DrawingPanel.Adapters.Mouse.MovingAdapter;
import methexample.Canvas.MainCanvas.DrawingPanel.Adapters.Mouse.ResizeAdapter;
import methexample.Canvas.MainCanvas.DrawingPanel.BaseDrawingCanvas;
import methexample.Canvas.MainCanvas.DrawingPanel.Shapes.Interfaces.IItems;
import methexample.Canvas.MainCanvas.Interfaces.IBaseDrawingCanvas;
import methexample.Canvas.MainCanvas.Interfaces.IBaseToolboxCanvas;
import methexample.Canvas.MainCanvas.ToolboxPanel.BaseToolboxCanvas;

/**
 *
 * @author ΙΩΑΝΝΑ
 */


public class BaseFrame extends JFrame implements java.io.Serializable{

    protected JSplitPane split;
    private IBaseDrawingCanvas BaseCanvas;
    private IBaseToolboxCanvas toolBox;

    public BaseFrame() {
        initUI();
    }

    public void registerToCanvas(IItems newItem) {
        if (BaseCanvas != null) {
            BaseCanvas.registerItem(newItem);
        }
    }

    private void initUI() {
        BaseCanvas = new BaseDrawingCanvas(150, 50, 150, 100);//diastaseis apo ta tetragwnakia
        toolBox = new BaseToolboxCanvas(this);/*this*/

        BaseCanvas.registerMouseListeners(new ResizeAdapter(BaseCanvas));
        BaseCanvas.registerMouseListeners(new MovingAdapter(BaseCanvas));
        addKeyListener(new UndoRedoListener(this));
        addKeyListener(new SaveLoadListener());
        addKeyListener(new NewListener());

        if (BaseCanvas instanceof JPanel) {

            split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, (JPanel) toolBox, (JPanel) BaseCanvas);
            split.setContinuousLayout(false);
            split.setOneTouchExpandable(true);

            getContentPane().add(split, BorderLayout.CENTER);

        } else {
            System.out.println("An Error occured when trying registering the IResize.");
            System.exit(2);
        }

        setTitle("Ground Plan");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
    }

    public void redo() {
        BaseCanvas.redo();
    }

    public void undo() {
        BaseCanvas.undo();
    }
}

