package methexample.Canvas.MainCanvas.DrawingPanel.options;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import methexample.Canvas.MainCanvas.BaseFrame;

/**
 *
 * @author ΙΩΑΝΝΑ
 */
public class Save {
    public void save(){
        BaseFrame ex = new BaseFrame();
        System.out.println("SAVEEEEEEEEEEE");
        
        try {
            // Write to disk with FileOutputStream
            FileOutputStream fileOut
                    = new FileOutputStream("C:\\Users\\ΙΩΑΝΝΑ\\Documents\\netBeans\\groundPlan.ser");
            // Write object with ObjectOutputStream(grafw to antikeimeno)
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            // Write object out to disk
            out.writeObject(ex);
            out.close();
            fileOut.close();
            System.out.printf("C:\\Users\\ΙΩΑΝΝΑ\\Documents\\netBeans\\groundPlan.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
        
        
    }
    
}
