package methexample.Canvas.MainCanvas.DrawingPanel.options;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import methexample.Canvas.MainCanvas.BaseFrame;

/**
 *
 * @author ΙΩΑΝΝΑ
 */
public class Load {

    public void load() {
        BaseFrame ex = new BaseFrame();
        
        System.out.println("LOADD");
       
        try {
            FileInputStream fileIn = new FileInputStream("C:\\Users\\ΙΩΑΝΝΑ\\Documents\\netBeans\\groundPlan.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            ex = (BaseFrame) in.readObject();
            in.close();
            fileIn.close();

            System.out.println("Mpike sto base frame");
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("groundPlan class not found");
            c.printStackTrace();
            return;
        }
    }
}
