import java.util.Scanner;
/**************************************
* A Processor can compute the definite
* integral of a function using three
* methods
*************************************/

public class Processor
{
    static double[][] data = new double[2][10000];
    static double exp = 2.0;
    /*************************************************
    * Computes integral using trapezoidal rule
    * @param x  data file name
    * @param a  integration domain
    * @return   answer
    ************************************************/
    public static double trapezoidal(double stepsize)
    {
        //Uses trapezoidal rule to compute integral
        double sum = 0;
        System.out.println("wtf");
        int i = 0;
        while(data[1][i]-data[1][i+1]!=0)
         {
             sum+=(((data[1][i]+data[1][i+1])/2.0)*stepsize);
             System.out.println("("+data[0][i+1]+"-"+data[0][i]+")*("+data[1][i]+"+"+data[1][i+1]+")/2.0");
             i++;
         }
        return sum;
    }
	 /*************************************************
    * Computes integral using Simpson's rule
    * @return   answer
    ************************************************/
    public static double simpsons()
    {
        //Uses Simpson's rule to compute integral
        return -1;
    }
	 /************************************************
    * Computes integral using Boole's rule
    * @return   answer
    ************************************************/
    public static double booles()
    {
        //Uses Boole's rule to compute intregral
        return -1;
    }
	 /************************************************
    * Redirects information to individual quadrature rule
    * @param x  quadrature rule type
    * @return   answer
    ************************************************/
    public static double compute(String x)
    {
        // Depending on the contents of the string,
        // calls appropriate method
        if(x.equals("Trapezoidal"))
            return trapezoidal(0.01);
        if(x.equals("Simpsons"))
            return simpsons();
        if(x.equals("Booles"))
            return booles();
		else
		  	return -1;
    }
    public static void makeData(String func, double[] intdo)
    {
        for(int i=0; i<(int)intdo[1]*100; i++)
        {
            double x = intdo[0]+(double)(i/100.0);
            double y = Math.pow(x, exp);
            data[0][i]=x;
            data[1][i]=y;
            System.out.println(x+", "+y);
        }
            
    }
}
