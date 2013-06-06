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
    public static Display display; // Instantiates display
    private JLabel title; //"Quadrature"
    private JLabel inp; // Input label
    private JLabel intdom; //Integration domain label
    private JLabel rule; // Quadrature type label
    private JLabel answer; // Answer to integration problem
    private JLabel correctans; //Accurate answer to integration
    private JLabel Stpsize; //Stepsize label
    private JLabel accuracy; //Accuracy of quadrature
    private JTextField intdomain; //Box to input integration domain
    private JTextField stpsize; //Box to input stepsize
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
        setLayout(new BorderLayout(10, 10)); 
		  // Instantiate new Display
        display = new Display();
		  // instantiate new JPanel panel	
        JPanel panel = new JPanel();
		  // set panel layout to GridLayout
        panel.setLayout(new GridLayout(16,1));
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
		  
		// Set answer to JLabel "Answer: "
        answer = new JLabel();
        correctans = new JLabel();
        accuracy = new JLabel();

        answer.setText("Answer: ");
        // Set correct answer to JLabel "Correct answer: "
        correctans.setText("Correct answer:          ");
        // Set accuracy to JLabel "Accuracy"
        accuracy.setText("Accuracy: ");

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
        // set stepsize label to text "0.5"
        stpsize = new JTextField("0.5");
        // set intdom to JLabel for integration domain
        intdom = new JLabel("Integration interval:");
		// set stepsize label to text "Stepsize"
        Stpsize = new JLabel("Step-size:");
		  // create array of quadrature rule choices
        String[] rules = {"Rectangular", "Trapezoidal", "Simpson's"};
    	  // instantiate rbox JComboBox    
		  rbox = new JComboBox(rules);
		  // set selected index to "Rectangular"
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
        panel.add(Stpsize);
        panel.add(stpsize);
        panel.add(rule);
        panel.add(rbox);
        panel.add(run);
        panel.add(answer);
        panel.add(correctans);
        panel.add(accuracy);

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
	        //set up display to draw
            Display.setParams((String)input.getSelectedItem());
            double s = Double.parseDouble((String)stpsize.getText());
            Processor.stepsize=s; // set stepsize
            Display.integrated=true; //set intregrated to true
            Display.intd=id((String)intdomain.getText()); // set integration domain
            Display.type=(String)rbox.getSelectedItem(); //set quadrature rule
            if(s>=0.05 && s<4.7 && Display.intd[0]>=-5.0 && Display.intd[1]<=5.0)
            {
                display.repaint(); //redraw
                add(display, BorderLayout.CENTER); //redraw
                //answers to be drawn on screen
                Processor.intdomain=Display.intd;
                String f = Double.toString(Processor.compute(Display.type));
                String g = Double.toString(Processor.corrAns());
                String h = Double.toString(Processor.acc(Processor.corrAns(), 
                                            Processor.compute(Display.type)));
                answer.setText("Answer: "+ f.substring(0,f.indexOf(".")+2));
                correctans.setText("Correct Answer: "+g.substring(0,g.indexOf(".")+2));
                accuracy.setText("Error: "+h.substring(0,h.indexOf(".")+2)+"%");
            }
            else
            {
                JOptionPane frame = new JOptionPane();
                JOptionPane.showMessageDialog(frame, 
                "Integration domain or step size out of range", "Bad input", JOptionPane.WARNING_MESSAGE);
            }
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

