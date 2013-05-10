import javax.swing.*;
import java.awt.*;
public class panel extends JPanel 
{
    public void paintComponent(Graphics g) 
    {
        g.setColor(Color.WHITE);
        g.drawLine(10, 20, 50, 20);
    }
}
	    
