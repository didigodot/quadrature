import javax.swing.*;
import java.awt.*;
import java.lang.Math;
import java.util.*;
import java.awt.event.*;

public class panel extends JPanel 
{
    Display display;
    private JLabel title; //"Quadrature"
    private JTextField input; //Box to input function
    public panel()
    {
        setLayout(new BorderLayout());
        display = new Display();
        //add(display, BorderLayout.NORTH);

        title = new JLabel("Quadrature");
        title.setFont(new Font("Helvetica", Font.BOLD, 40));
        title.setForeground(Color.blue);
        add(title, BorderLayout.NORTH);
    
        input = new JTextField("0.0, 7");
        add(input, BorderLayout.WEST);

        JButton run = new JButton("run");
        run.addActionListener(new Listener());

        JRadioButton trapezoidal = new JRadioButton("trapezoidal");
        trapezoidal.setMnemonic(KeyEvent.VK_C);
        ButtonGroup group = new ButtonGroup();
        group.add(trapezoidal);
        add(trapezoidal, BorderLayout.EAST); add(run, BorderLayout.SOUTH); 
        
    }
   public static void parsefunc(String s)
   {
    System.out.println(s);
   }
    private class Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            parsefunc(input.getText());
        }
    }
}
