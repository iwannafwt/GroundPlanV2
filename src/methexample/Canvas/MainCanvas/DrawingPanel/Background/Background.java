package methexample.Canvas.MainCanvas.DrawingPanel.Background;

import java.awt.Graphics2D;

/**
 *
 * @author ΙΩΑΝΝΑ
 */
public class Background {

    public void backgroundColour(int width, int height, int rows, int cols, Graphics2D g) {
        //opos kanei auto edw.. pou apla to kaleses kai "auto"zografistike mono tou   to katalaba kai piga n t kanw alla den kserw pws na t kalesw
        //sta8ero exeis? ^_^
        int i;

        // draw the rows
        int rowHt = height / (rows);
        for (i = 0; i < rows; i++) {
            g.drawLine(0, i * rowHt, width, i * rowHt);
        }

        // draw the columns
        int rowWid = width / (cols);
        for (i = 0; i < cols; i++) {
            g.drawLine(i * rowWid, 0, i * rowWid, height);
        }
    }
}
