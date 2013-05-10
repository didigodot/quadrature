import javax.swing.*;
import java.awt.*;
import java.lang.Math;
public class panel extends JPanel 
{
    public void paintComponent(Graphics g) 
    {
        
        g.setColor(Color.BLACK);
        g.drawLine(50, 550, 700, 550);
        g.drawLine(50, 550, 50, 50);
        for(int i = 50; i<700; i++){
            int y = (int)(Math.pow(Math.E, (double)((i-50)/350)));
            g.drawRect(i, 100*(y+300), 1, 1);
            }
    }
}
	    
