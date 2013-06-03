import java.util.Scanner;
/**************************************
* A Processor can compute the definite
* integral of a function using three
* methods
*************************************/

public class Processor
{
    static double[][] data = new double[2][10000];
    public static double exp = 2.0;
    public static String type= "";
    public static double stepsize = 0.5;
    /*************************************************
    * Computes integral using trapezoidal rule
    * @param stepsize   Step size
    * @return   answer
    ************************************************/
    public static double trapezoidal()
    {
        //Uses trapezoidal rule to compute integral
        double sum = 0;
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
        double sum = 0;
        int i = 0;
        while(data[1][i]-data[1][i+1]!=0)
         {
             sum+=(((data[1][i]+data[1][i+1])+4*data[1][(int)((i+i+1)/2.0)])*stepsize/6.0); 
             i++;
         }
        return sum;
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
            return trapezoidal();
        if(x.equals("Simpson's"))
            return simpsons();
        if(x.equals("Boole's"))
            return booles();
		else
		  	return -1;
    }
    public static void makeData(String func, double[] intdo)
    {
        data = new double[2][1000];
        for(int i=0; i<(int)intdo[1]*(1.0/stepsize); i++)
        {
            double x = intdo[0]+(double)(i*stepsize);
            double y = Math.pow(x, exp);
            data[0][i]=x;
            data[1][i]=y;
        }
            
    }
}
