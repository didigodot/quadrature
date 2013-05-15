import javax.swing.*;
import java.awt.*;
import java.lang.Math;
import java.util.*;
import java.awt.event.*;
public class panel extends JPanel 
{
    private JLabel title; //"Quadrature"
    private JTextField input; //Box to input function
    public panel()
    {
        setLayout(new FlowLayout());
        title = new JLabel("Quadrature");
        title.setFont(new Font("Helvetica", Font.BOLD, 40));
        title.setForeground(Color.blue);
        add(title);
    
        input = new JTextField("0.0, 7");
        add(input);

        JButton run = new JButton("run");
        run.addActionListener(new Listener());
        add(run);
    }
    public void drawAxes(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.drawLine(50, 550, 700, 550);
        g.drawLine(50, 550, 50, 50);
    } 
    
    public void paintComponent(Graphics g) 
    {
        drawAxes(g);
        for(int i = 50; i<700; i++)
            {
            double y = Math.pow((((double)i-50.0)/130.0), 2.0);
            g.drawRect(i, (int)((550-(y*22))), 0, 0);
            }
    }
    public void parsefunc(String s)
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
