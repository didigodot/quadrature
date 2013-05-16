import javax.swing.JFrame;
public class Driver
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Quadrature");
        frame.setSize(800,600);
        frame.setLocation(350,150);
        frame.setDefaultCloseOperation(
                            JFrame.EXIT_ON_CLOSE);
        //frame.setContentPane(new panel());
        panel p = new panel();
        p.add(new Display());
        frame.getContentPane().add(p);
        frame.setSize(800,600);
        frame.pack();
        
        //UIManager.setLookAndFeel(
          //          UIManager.getSystemLookAndFeelClassName());
        frame.setVisible(true);
    }

}
