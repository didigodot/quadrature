//Didi Park - Quadrature
// May 23, 2013
// Stubs

import javax.swing.*; //swing graphics
import java.awt.*; // awt ???
import java.lang.Math; // Math class
import java.util.*; // Utilities
import java.awt.event.*; // Events
import java.io.*; 
/***********************************************************
* Display has a paintComponent and draws
* the plotting area and function in the 
* center of the panel
* @author Didi Park, website: https://github.com/didigodot
************************************************************/

public class Display extends JPanel 
{
   
    public void drawAxes(Graphics g)
    {
        // Set color to black
        // draw x-axis from (50, 280) to (650, 280)
        // draw y-axis from (360, 20) to (360, 550)
        // void - returns nothing 
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
        // 650>x>50?
        // 20< y1 and y2 <550?
        // if contained, return true
        // if not contained, return false
        return false;
    }
    /***************************************************
    * Draws function on coordinate plane
    * @param g  Graphics object
    ***************************************************/
    public static void drawPlot(Graphics g)
    {
       // Set color to black
       // Plot graph depending on graph type 
		 // Set different color if needed
		 // Plot integration if needed
       //print data to text file
      
    }       
	 /***************************************************
    * Runs all other methods to draw function, axes, etc.
    * @param g  Graphics object
    ***************************************************/ 
    public void paintComponent(Graphics g) 
    {
        // Set color to white
        // Draw filled rectangle at (50,20), width=600, height=530
        // Set color to black
        // Draw rectangle at (50, 20), width=600, height=530
    	  //Draw axes    
		  drawAxes(g);
		  //Draw graph
		  drawPlot(g);
    }
}
