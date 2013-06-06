import java.util.Scanner;
/**************************************
* A Processor can compute the definite
* integral of a function using three
* methods
*************************************/

public class Processor
{
    static double[][] data = new double[2][100000];
    public static String type= "";
    public static double stepsize = 0.5;
    /*************************************************
    * Computes integral using rectangular rule
    * @param stepsize   Step size
    * @return   answer
    ************************************************/
    public static double rectangular()
    {
        //Uses rectangular rule to compute integral
        double sum = 0;
        int i = 0;
        while(data[1][i]-data[1][i+1]!=0)
         {
             sum+=((data[1][(int)(i+stepsize/2.0)])*stepsize);
             i++;
         }
	    System.out.println(sum);
	    return sum;
	
    }
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
        System.out.println("computed trapezoidal!!!");
	System.out.println(sum);
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
    /***********************************************
    * Computes accurate answer using power rule
    * @return answer
    ***********************************************/
    public static double corrAns()
    {
        return ((1.0/(Display.A+1.0))*Math.pow(Display.intd[1],Display.A+1.0))-
        ((1.0/(Display.A+1.0))*Math.pow(Display.intd[0], Display.A+1.0));
    }
    /***********************************************
    * Computes error of quadrature
    * @param a  Precise value
    * @param b  Approximate value
    * @return   Percent error
    ***********************************************/
    public static double acc(double a, double b)
    {
        return (Math.abs(b-a)/a)*100.0;
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
        if(x.equals("Rectangular"))
            return rectangular();
        if(x.equals("Trapezoidal"))
            return trapezoidal();
        if(x.equals("Simpson's"))
            return simpsons();
		else
		  	return -1;
    }
    /*************************************************
    * Makes list of data points for computations
    * @param intdo  integration domain
    ************************************************/
    public static void makeData(double[] intdo)
    {
        data = new double[2][1000];
	for(int i=0; i<(int)intdo[1]*(1.0/stepsize); i++)
        {
            double x = intdo[0]+(double)(i*stepsize);
            double y = Math.pow(x, Display.A);
            data[0][i]=x;
            data[1][i]=y;
        }
            
    }
}
