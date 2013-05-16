import javax.swing.*;
import java.awt.*;
import java.lang.Math;
import java.util.*;
import java.awt.event.*;
public class ppanel extends JPanel 
{
    public void drawAxes(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.drawLine(50, 550, 700, 550);
        g.drawLine(50, 550, 50, 50);
    } 
    
    public void paintComponent(Graphics g) 
    {
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                            RenderingHints.VALUE_ANTIALIAS_ON);
        drawAxes(g);
        for(int i = 50; i<500; i++)
            {
            double y = Math.pow((((double)i-50.0)/130.0), 2.0);
            g2.drawRect(i, (int)((550-(y*22))), 1, 0);
            }
    }
}
