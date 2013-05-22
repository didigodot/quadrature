import javax.swing.*;
import java.awt.*;
//////////////////import java.lang.Math;
import java.util.*;
import java.awt.event.*;

public class Panel extends JPanel 
{
    Display display;
    private JLabel title; //"Quadrature"
    private JLabel inp;
    private JLabel dom;
    private JLabel intdom;
    private JLabel rule;
    private JTextField domain; //Box to input function domain
    private JTextField intdomain; //Box to input integration domain
    private JComboBox rbox;
    private JComboBox input;
    public Panel()
    {
        setLayout(new BorderLayout());
        display = new Display();

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(14,3));
        JPanel titlep = new JPanel();
        titlep.setLayout(new FlowLayout()); 

        title = new JLabel("Quadrature");
        title.setFont(new Font("Helvetica", Font.BOLD, 40));
        title.setForeground(Color.blue);
        titlep.add(title);
   
        String[] i = {"x^2", "x^3", "x^4"};
        input = new JComboBox(i);
        input.setSelectedIndex(0);
        
        //input = new JTextField("ax^2+bx+c");
        domain = new JTextField("-10"+","+" 10");
        intdomain = new JTextField("-5, 5");

        inp = new JLabel("Function:");
        dom = new JLabel("Domain:");
        intdom = new JLabel("Integration interval:");
        panel.add(inp);
        panel.add(input);
        panel.add(dom);
        panel.add(domain);
        panel.add(intdom);
        panel.add(intdomain);
        
        JButton run = new JButton("run");
        run.addActionListener(new Listener());
        
        String[] rules = {"Trapezoidal", "Simpson's", "Boole's"};
        rbox = new JComboBox(rules);
        rbox.setSelectedIndex(0);
        rule = new JLabel("Integration method:");
        panel.add(rule);
        panel.add(rbox);
        panel.add(run);

        add(titlep, BorderLayout.NORTH); 
        add(display, BorderLayout.CENTER);
        add(panel, BorderLayout.EAST);
        
     }
   public static void dostuff(JComboBox a, JComboBox b, JTextField c)
   {
    // tell display to draw function and collect data points
    // tell quadengine to draw integration
    // tell quadengine to output answer
    // tell panel to draw answer
        System.out.println(a.getSelectedItem());
        System.out.println(b.getSelectedItem());
        System.out.println(c.getText());
   }
    private class Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            dostuff(input, rbox, intdomain);
            
        }
    }

  public Dimension getPreferredSize(){
      return new Dimension(800,700);
  }
}
