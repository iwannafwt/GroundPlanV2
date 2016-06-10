/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methexample.Canvas.MainCanvas.Interfaces;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.util.List;
import methexample.Canvas.MainCanvas.DrawingPanel.Shapes.Interfaces.IItems;

/**
 *
 * @author ΙΩΑΝΝΑ
 */
public interface IBaseDrawingCanvas {
    void doUpdate();
    void registerItem(IItems newItem);
    int getPosCorner();
    void setPosCorner(int posForItem);
    List<IItems> getItems();
    int getPos();
    void setPos(int pos);
    int getHelperSize();
    void paintComponent(Graphics g);
    void registerMouseListeners(MouseAdapter MA); 
    public IItems getItemForMoving(); 
    public void setItemForMoving(IItems itemToMove);
    boolean undo();
    boolean redo();
    void setUndo();
   int getSIZE();
 
}
