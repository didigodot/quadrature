import javax.swing.*;
import java.awt.*;
import java.lang.Math;
import java.util.*;
import java.awt.event.*;

public class Display extends JPanel 
{
    public int A;
    private int B;
    private int C;

    public void drawAxes(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.BLACK);
        g2.drawLine(360, 20, 360, 550); //y-axis
        g2.drawLine(50, 280, 650, 280); //x-axis
        int[] a1 = {650,650,655};
        int[] a2 = {255,265,250};
        Polygon arrow = new Polygon(a1,a2, 1);
        g2.fillPolygon(arrow);
    }
    /*public static  parseF(int a, int b, int c)
    {
         A = a;
         B = b;
         C = c;
         System.out.println(A+","+B+","+C);
    } */

    public static boolean bounded(int x, int y1, int y2)
    {
        if(x>=50 && x<=650 && y1<=550 && y1>=20 && y2<=550 && y2>=20)
            return true;
        return false;
    }
    public static void drawPlot(Graphics g)
    {
       Graphics2D g2 = (Graphics2D)g;
       g2.setColor(Color.BLACK);
       for(int i = 50; i<650; i++)
       {
            double y = Math.pow((((double)i-360.0)/260.0), 2.0);
            int x = i; int y1 = (int)((280-(y*250))); int y2 = (int)((280-(y*250)));
            if(bounded(x, y1, y2))
                g2.drawLine(x, y1, x, y2);
       }

    }        
        
    public void paintComponent(Graphics g) 
    {
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                            RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.WHITE);
        //draw background
        g2.fillRect(50, 20, 600, 530); //x,y,width,height
        g2.setColor(Color.BLACK);
        g2.drawRect(50,20,600,530);
        drawAxes(g);
        drawPlot(g);
    }
}
