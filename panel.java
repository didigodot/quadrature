import javax.swing.*;
import java.awt.*;
public class panel extends JPanel 
{
    public void paintComponent(Graphics g) 
    {
        
        g.setColor(Color.BLACK);
        g.fillRect(75, 50, 100, 120);
        g.drawLine(10, 20, 50, 20);
    }
}
	    
