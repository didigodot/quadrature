import javax.swing.*;
import java.awt.*;
import java.lang.Math;
import java.util.*;

public class panel extends JPanel 
{
   public void drawAxes(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.drawLine(50, 550, 700, 550);
        g.drawLine(50, 550, 50, 50);
    } 

    public void paintComponent(Graphics g) 
    {
        drawAxes(g);
        for(int i = 50; i<700; i++)
            {
            double y = Math.pow((((double)i-50.0)/130.0), 2.0);
            g.drawRect(i, (int)((550-(y*22))), 0, 1);
            }
    }
}
	    
