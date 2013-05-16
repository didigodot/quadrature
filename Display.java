import javax.swing.*;
import java.awt.*;
import java.lang.Math;
import java.util.*;
import java.awt.event.*;

public class Display extends JPanel 
{
    public void drawAxes(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.BLACK);
        //g.drawLine(50, 550, 700, 550);
        //g.drawLine(50, 550, 50, 50);
        g2.drawLine(375, 50, 375, 550); //y-axis
        g2.drawLine(50, 260, 650, 260); //x-axis
        int[] a1 = {650,650,655};
        int[] a2 = {255,265,250};
        Polygon arrow = new Polygon(a1,a2, 3);
        g2.fillPolygon(arrow);
    } 
    public void drawPlot(Graphics g, int A, int B, int C)
    {
        //Ax^2+Bx+C
    }        
        
    public void paintComponent(Graphics g) 
    {
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                            RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.WHITE);
        g2.fillRect(50, 50, 500, 500); //x,y,width,height
        drawAxes(g);
        //drawPlot(int 
        for(int i = 50; i<700; i++)
            {
            double y = Math.pow((((double)i-50.0)/130.0), 2.0);
            g2.drawLine(i, (int)((550-(y*22))), i, (int)((550-(y*22))));
            }
    }
}
