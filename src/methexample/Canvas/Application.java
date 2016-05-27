package methexample.Canvas;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import methexample.Canvas.MainCanvas.BaseFrame;

/**
 *
 * @author ΙΩΑΝΝΑ
 */
public class Application {
    public void application(){
        BaseFrame ex = new BaseFrame();
        ex.setVisible(true);
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
        
        
          ex=null;
      try
      {
         FileInputStream fileIn = new FileInputStream("C:\\Users\\ΙΩΑΝΝΑ\\Documents\\netBeans\\groundPlan.ser");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         ex = (BaseFrame) in.readObject();
         in.close();
         fileIn.close();
         
          System.out.println("Mpike sto base frame");
      }catch(IOException i)
      {
         i.printStackTrace();
         return;
      }catch(ClassNotFoundException c)
      {
         System.out.println("groundPlan class not found");
         c.printStackTrace();
         return;
      }
    }
}
