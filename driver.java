import javax.swing.JFrame;
public class driver
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Quadrature");
        frame.setSize(200, 200);
        frame.setLocation(100,50);
        frame.setDefaultCloseOperation(
                            JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new panel());
        frame.setVisible(true);
    }
}
