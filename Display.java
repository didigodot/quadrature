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
	/****************************************************
	* Draws axes on Display
	* @param g	Graphics object
	****************************************************/
    public void drawAxes(Graphics g)
    {
        g.setColor(Color.BLACK); // Set color to black
        g.drawLine(360, 20, 360, 550); //y-axis
        g.drawLine(50, 280, 650, 280); //x-axis
    }

    /*******************************************************
    * Checks whether a given point is bounded by the plot
    * @param    x  x-coordinate
    * @param    y1 y-coordinate
    * @param    y2 second y-coordinate
    * @return   boundedness
    *******************************************************/ 
    public static boolean bounded(int x, int y1, int y2)
    {
    	// Check if x, y1, and y2 are contained within window    
		  if(x>=50 && x<=650 && y1<=550 && y1>=20 && y2<=550 && y2>=20)
            return true;
        else
		  		return false;
    }
	 /***************************************************
    * Draws function on coordinate plane
    * @param g  Graphics object
    ***************************************************/
    public static void drawPlot(Graphics g)
    {
       g.setColor(Color.BLACK); // Set color to black
		 // Plot graph depending on graph type 
		 // Set different color if needed
		 // Plot integration if needed
       //print data to text file
			/*use a switch!*/
       for(int i = 50; i<650; i++)
       {
            double y = Math.pow((((double)i-360.0)/260.0), 2.0);
            int x = i; int y1 = (int)((280-(y*250))); int y2 = (int)((280-(y*250)));
            if(bounded(x, y1, y2))
                g.drawLine(x, y1, x, y2);
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
		  //Draw graph
        drawPlot(g2);
    }
}
