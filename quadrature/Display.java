//Didi Park - Quadrature
// May 23, 2013

import javax.swing.*; //swing graphics
import java.awt.*; // awt classes
import java.lang.Math; // Math class
import java.util.*; // Utilities
import java.awt.event.*; // Events
import java.io.*; // Input output
/***********************************************************
* Display has a paintComponent and draws
* the plotting area and function in the 
* center of the panel
* @author Didi Park, website: https://github.com/didigodot
************************************************************/
public class Display extends JPanel 
{
    public static double A = 2.0; //exponent
    static String type; //type of quadrature
    static double[] intd; //integration domain
    public static boolean integrated = false; //integration has happened?
    
	/****************************************************
	* Draws axes on Display
	* @param g	Graphics object
	****************************************************/
    public void drawAxes(Graphics g)
    {
        g.setColor(Color.BLACK); // Set color to black
        g.drawLine(360, 20, 360, 550); //y-axis
        g.drawLine(50, 280, 650, 280); //x-axis
        g.drawString("5",620,295); //label
        g.drawString("-5", 80, 295); //label
    }
    /*******************************************************
    * Checks whether a given point is bounded by the plot
    * @param    x  x-coordinate
    * @param    y y-coordinate
    * @return   boundedness
    *******************************************************/ 
    public static boolean bounded(int x, int y, int y1)
    {
    	// Check if x and y are contained within window    
		  if(x>=50 && x<=650 && y<=550 && y>=20 && y1<=550 && y1>=20)
            return true;
        else
		  		return false;
    }
    /******************************************************
    * Sets parameters of graph/integraion technique
    * @param func   Function type
    * @param intdo  Integration domain
    ******************************************************/
    public static void setParams(String func, double[] intdo)
    {
        if(func.equals("x^2"))
            A=2.0;
        if(func.equals("x^3"))
            A=3.0;
        if(func.equals("x^4"))
            A=4.0;
    }
    /******************************************************
    * Draws visual of quadrature technique on graph
    * @param g  Graphics object
    ******************************************************/
    public static void drawInt(Graphics g)
    {
        /** only does trapezoidal**/
        /** MAKE SURE IT ONLY DRAWS IN THE INTEGRATION DOMAIN **/
        for(int i = 50; i<650; i+=(int)(Processor.stepsize*20))
       {
            g.setColor(Color.RED);
            double y1 = Math.pow((((double)i-360.0)/260.0), A);
            double y2 = Math.pow((((double)(i+(int)(Processor.stepsize*20))-360.0)/260.0), A);
            int x = i; 
            int Y1 = (int)((280-(y1*250))); 
            int Y2 = (int)((280-(y2*250)));
            int[] xpoints = {x, x, x+(int)(Processor.stepsize*20), x+(int)(Processor.stepsize*20)};
            int[] ypoints = {280, Y1, Y2, 280};
            if(bounded(x, Y2, Y1)&&(double)(x-360)/58.0<intd[1] && (double)(x-360)/58.0>intd[0])
                {
                    g.drawLine(x, Y1, x+(int)(Processor.stepsize*20), Y2);
                    g.fillPolygon(xpoints, ypoints, 4);
                    g.setColor(Color.BLUE);
                    g.drawLine(x, 280, x, Y1);
                    g.drawLine(x+(int)(Processor.stepsize*20),280, x+(int)(Processor.stepsize*20), Y2);
                }
       }
    }
	 /***************************************************
    * Draws function on coordinate plane
    * @param g  Graphics object
    ***************************************************/
    public static void drawPlot(Graphics g)
    {
       g.setColor(Color.BLACK); // Set color to black
	   // Plot graph depending on graph type 
       for(int i = 50; i<650; i++)
       {
            double y = Math.pow((((double)i-360.0)/260.0), A);
            int x = i; int y1 = (int)((280-(y*250)));
            if(bounded(x, y1, 20))
                g.drawLine(x, y1, x, y1);
       }
       
    }        
    /***************************************************
    * Runs all other methods to draw function, axes, etc.
    * @param g  Graphics object
    ***************************************************/ 
    public void paintComponent(Graphics g2)
    {
	 	// Set color to white
        g2.setColor(Color.WHITE);
        // Draw filled rectangle at (50,20), width=600, height=530
        g2.fillRect(50, 20, 600, 530);
		  // Set color to black
        g2.setColor(Color.BLACK);
		  // Draw rectangle at (50, 20), width=600, height=530
        g2.drawRect(50,20,600,530);
		  //Draw axes 
        drawAxes(g2);
       // Plot integration if needed
       if(integrated==true)
           drawInt(g2);
       //draw plot
        drawPlot(g2);
    }
}
