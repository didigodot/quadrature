// Didi Park - Quadrature
// May 23, 2013
// Stubs
/************************************************
* Displays JFrame with Panel and Display contents
* @author   Didi Park, website: https://github.com/didigodot
* @version  1.0
************************************************/
import javax.swing.JFrame; //JFrame Class

public class Driver
{
    /**************************************
    * Instantiates Panel, puts it on frame
    * Packs frame, sets appropriate settings
    ***************************************/
    public static void main(String[] args)
    {
        // Instantiate new JFrame
        JFrame frame = new JFrame("Quadrature");
        // set location to (350, 150)
        frame.setLocation(350,150);
        // set default close operation to exit on close
        frame.setDefaultCloseOperation(
                                JFrame.EXIT_ON_CLOSE);
        // Instantiate new Panel
        Panel p = new Panel();
        // Add new Display object to Panel
        p.add(new Display());
        // Add Panel to JFrame
        frame.getContentPane().add(p);
        // Pack frame
        frame.pack();
        // Set frame to visible 
        frame.setVisible(true);
    }

}
