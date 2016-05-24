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
    void setPosCorner();
    List<IItems> getItems();
    int getPos();
    void setPos(int pos);
    int getHelperSize();
    void paintComponent(Graphics g);
    void registerMouseListeners(MouseAdapter MA);
    int setPosForItem(int posForItem);
    boolean undo();
    boolean redo();
    boolean setUndo();
   
 
}
