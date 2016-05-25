/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methexample.Canvas.MainCanvas.Interfaces;

import java.awt.Graphics;
import java.util.List;
import methexample.Canvas.MainCanvas.DrawingPanel.Shapes.Interfaces.IItems;
import methexample.Canvas.MainCanvas.ToolboxPanel.Items.Rectangle;

/**
 *
 * @author ΙΩΑΝΝΑ
 */
public interface IBaseToolboxCanvas {
    public void sendNewRegister(IItems newItem);
    public void paintComponent(Graphics g); 
    public void doRepaint();
    public List<Rectangle> getItems();
}
