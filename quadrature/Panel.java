// Didi Park - Quadrature
// May 23, 2013
// Program

import javax.swing.*; //Swing graphics classes
import java.awt.*; // awt classes
import java.util.*; //util classes
import java.awt.event.*; // event classes
import java.lang.String; //String class

 /*******************************************************
 * A Panel has 5 JLabels, a JTextField, and 2 JComboBoxes.
 * It calls Display and sends user input to Display and
 * Processor.
 * @author  Didi Park
 * @version 1.0
 ********************************************************/
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
	 	  //Set layout to BorderLayout
        setLayout(new BorderLayout()); 
		  // Instantiate new Display
        display = new Display();
		  // instantiate new JPanel panel	
        JPanel panel = new JPanel();
		  // set panel layout to GridLayout
        panel.setLayout(new GridLayout(14,3));
		  // instantiate new JPanel titlep
        JPanel titlep = new JPanel();
		  // Set titlep layout to FlowLayout
        titlep.setLayout(new FlowLayout()); 
		  // set title label to "Quadrature"
        title = new JLabel("Quadrature");
		  // Set title font to blue helvetica, 40 pt
        title.setFont(new Font("Helvetica", Font.BOLD, 40));
		  title.setForeground(Color.blue);
		  // Add title to titlep Panel
        titlep.add(title);
		  
		  // Instantiate and set answer to JLabel "Answer: "
        answer = new JLabel();
        answer.setText("Answer: ");
        
   	  // set inp to JLabel for function input
        inp = new JLabel("Function:");
		  // create array of function choices
        String[] i = {"x^2", "x^3", "x^4"};
		  // set input to combobox of string array i
        input = new JComboBox(i);
		  // set selected index to the first: x^2
        input.setSelectedIndex(0);
        
		  // set integration domain label to text "0,5"
        intdomain = new JTextField("0, 5");
        // set intdom to JLabel for integration domain
        intdom = new JLabel("Integration interval:");
		  
		  // create array of quadrature rule choices
        String[] rules = {"Trapezoidal", "Simpson's", "Boole's"};
    	  // instantiate rbox JComboBox    
		  rbox = new JComboBox(rules);
		  // set selected index to "Trapezoidal"
        rbox.setSelectedIndex(0);
		  // instantiate rule JLabel to text "Integration method:"
        rule = new JLabel("Integration method:");

		  // create run button, add action listener
        JButton run = new JButton("run");
        run.addActionListener(new Listener());
		  
		  // add above components to subpanel panel
        panel.add(inp);
        panel.add(input);
        panel.add(intdom);
        panel.add(intdomain);
        panel.add(rule);
        panel.add(rbox);
        panel.add(run);

		  // add subpanels to BorderLayout
        add(titlep, BorderLayout.NORTH); 
        add(display, BorderLayout.CENTER);
        add(panel, BorderLayout.EAST);
        
     }
  /*********************************************
  * Returns parsed version of integration domain
  * @param x    string containing integration domain
  * @return     array with integration domain
  *********************************************/
  public static double[] id(String x)
  {
      //Split string, convert numbers to ints, put into array
      String[] a = x.split("[,()]");
      double[] arr = {Double.parseDouble(a[0]), Double.parseDouble(a[1])};
      return arr;
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
		    Display.setParams((String)input.getSelectedItem(), id((String)intdomain.getText()));
            answer.setText("Answer: "+
                    Processor.compute((String)rbox.getSelectedItem(), id(intdomain.getText())));
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
