import javax.swing.*;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
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
        JComponent p = new ppanel();
        GroupLayout layout = new GroupLayout(p);
        p.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        
        //setLayout(new FlowLayout());
        //add(new ppanel());
        title = new JLabel("Quadrature");
        title.setFont(new Font("Helvetica", Font.BOLD, 40));
        title.setForeground(Color.blue);
        add(title);
    
        input = new JTextField("0.0, 7");
        add(input);

        JButton run = new JButton("run");
        run.addActionListener(new Listener());

        JRadioButton trapezoidal = new JRadioButton("trapezoidal");
        trapezoidal.setMnemonic(KeyEvent.VK_C);
        ButtonGroup group = new ButtonGroup();
        group.add(trapezoidal);
        add(trapezoidal);
        add(run);
    }
    public void drawAxes(Graphics g)
    {
        g.setColor(Color.BLACK);
        //g.drawLine(50, 550, 700, 550);
        //g.drawLine(50, 550, 50, 50);
        g.drawLine(375, 50, 375, 550); //y-axis
        g.drawLine(50, 260, 650, 260); //x-axis
        int[] a1 = {650,650,655};
        int[] a2 = {255,265,250};
        Polygon arrow = new Polygon(a1,a2, 3);
        g.fillPolygon(arrow);
    } 
    public void drawPlot(Graphics g, int A, int B, int C)
    {
        //Ax^2+Bx+C
    }        
        
    public void paintComponent(Graphics g) 
    {
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                            RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(Color.WHITE);
        g.fillRect(50, 50, 500, 500); //x,y,width,height
        drawAxes(g);
        //drawPlot(int 
        for(int i = 50; i<700; i++)
            {
            double y = Math.pow((((double)i-50.0)/130.0), 2.0);
            g2.drawRect(i, (int)((550-(y*22))), 1, 0);
            }
    }
    public void parsefunc(String s)
    {
    String[] arr = input.getText().split("");
    }
    private class Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            parsefunc(input.getText());
        }
    }
}
