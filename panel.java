import javax.swing.*;
import java.awt.*;
import java.lang.Math;
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
    private JTextField input; //Box to input function
    private JTextField domain; //Box to input function domain
    private JTextField intdomain; //Box to input integration domain

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
    
        input = new JTextField("ax^2+bx+c");
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
        JComboBox rbox = new JComboBox(rules);
        rbox.setSelectedIndex(0);
        rule = new JLabel("Integration method:");
        panel.add(rule);
        panel.add(rbox);
        panel.add(run);

        add(titlep, BorderLayout.NORTH); 
        add(display, BorderLayout.CENTER);
        add(panel, BorderLayout.EAST);
        
     }
   public static void parsefunc(String s)
   {
    String[] arr = s.split("");
    int A = Integer.parseInt(arr[0]);
    int B = Integer.parseInt(arr[5]);
    int C = Integer.parseInt(arr[8]);
    Display.parseF(A,B,C);
   }
    private class Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            parsefunc(input.getText());
        }
    }
  public Dimension getPreferredSize(){
      return new Dimension(800,700);
  }
}
