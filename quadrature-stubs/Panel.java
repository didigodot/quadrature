// Didi Park - Quadrature
// May 23, 2013
// Stubs
 /*******************************************************
 * A Panel has 5 JLabels, a JTextField, and 2 JComboBoxes.
 * It calls Display and sends user input to Display and
 * Processor.
 * @author  Didi Park
 * @version 1.0
 ********************************************************/

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class Panel extends JPanel 
{
    Display display; // Instantiates display
    private JLabel title; //"Quadrature"
    private JLabel inp; // Input label
    private JLabel intdom; //Integration domain label
    private JLabel rule; // Quadrature type label
    private JLabel answer; // Answer to integration problem
    private JTextField intdomain; //Box to input integration domain
    private JComboBox input; // combobox for input
    private JComboBox rbox; // combobox for quadrature rule
    
    /******************************************************
    * Sets layout and gives attributes to JComponents;
    * also gives action listeners and adds components to 
    * the panel
    *****************************************************/
    public Panel()
    {
        //Set layour to border layout
        // instantiate new display
        display = new Display();
        // instantiate new JPanel panel
        // set panel layout to grid layout
        // instantiate new JPanel titlep
        // Set titlep layout to flow layout
        // set title label to "Quadrature"
        // Set title font to blue helvetica, 40 pt
        // set answer to jlabel "Answer: "
        answer = new JLabel();
        answer.setText("Answer: ");
        // Add title label to titlep
        String[] i = {"x^2", "x^3", "x^4"};
        // set input to combobox of string array i
        // set integration domain label to text "-5,5"
        // set inp label to "function"
        // set intdom label to "Integration interval"
        // add above components to panel 
        // create jbutton run, set text to "run"
        // add action listener to run
        String[] rules = {"Trapezoidal", "Simpson's", "Boole's"};
        // set rbox to combobox of rules
        // set rule jlabel to say "rules"
        // add rule, rbox, run to panel
        // add titlep to north, display to center, panel to east
        
     }
   /**********************************************
   * Sends information to Display and Processor
   * @param a   JComboBox with function input
   * @param b   JComboBox with quadrature rule
   * @param c   JTextField with integration domain
   **********************************************/
   public static void doStuff(JComboBox a, JComboBox b, JTextField c, JLabel d, Display e)
   {
        // tell Display to draw function and collect data points
        // update display 
        e.updateUI();
        // tell Processor to draw integration
        Processor.drawInt();
        // tell Processor to output answer,
        // print answer to screen
        answer.setText("Answer: "+Processor.compute());
        
   }
   /*****************************************
    * ActionListener for Run button
    *****************************************/
    private class Listener implements ActionListener
    {
    /*****************************************
    * Runs when action has occurred 
    * @param e  ActionEvent
    ******************************************/
        public void actionPerformed(ActionEvent e)
        {
            //runs doStuff method
            doStuff(input, rbox, intdomain, display);
        }
    }
/**************************************
* Sets preferred size of JFrame
*************************************/
  public Dimension getPreferredSize(){
      // returns preferred dimension of 800x700
      return new Dimension(800,700);
  }
}
