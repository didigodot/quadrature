import javax.swing.JFrame;
public class Driver
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Quadrature");
        frame.setLocation(350,150);
        frame.setDefaultCloseOperation(
                            JFrame.EXIT_ON_CLOSE);
        Panel p = new Panel();
        p.add(new Display());
        frame.getContentPane().add(p);
        frame.pack();
        
        //UIManager.setLookAndFeel(
          //          UIManager.getSystemLookAndFeelClassName());
        frame.setVisible(true);
    }

}
