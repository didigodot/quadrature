import javax.swing.JFrame;
public class driver
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Quadrature");
        frame.setSize(800,600);
        frame.setLocation(350,150);
        frame.setDefaultCloseOperation(
                            JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new panel());
        frame.setVisible(true);
    }
}
