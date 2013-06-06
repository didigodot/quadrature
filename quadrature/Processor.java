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
    public static double[] intdomain;
    /*************************************************
    * Computes integral using rectangular rule
    * @param stepsize   Step size
    * @return   answer
    ************************************************/
    public static double rectangular()
    {
        //Uses rectangular rule to compute integral
        double sum = 0.0;
        for(int i = 0; i<(int)(intdomain[1]-intdomain[0])*(1.0/stepsize); i++)
         {
             double x = (intdomain[0]+(double)(i*stepsize))+stepsize/2.0;
             double y = Math.pow(x, Display.A);
             sum+=y;
         }
	    return sum*stepsize;
	
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
        for(int i = 0; i<(int)(intdomain[1]-intdomain[0])*(1.0/stepsize); i++)
         {
             double x = (intdomain[0]+(double)(i*stepsize));
             double y1 = Math.pow(x, Display.A);
             double y2 = Math.pow(x+stepsize, Display.A);
             sum+=stepsize*((y1+y2)/2.0);
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
       double fa = Math.pow(intdomain[0], Display.A);
       double fab = Math.pow((intdomain[0]+intdomain[1])/2.0, Display.A);
       double fb = Math.pow(intdomain[1], Display.A);
       double sum=((intdomain[1]-intdomain[0])/6.0)*(fa+4*fab+fb);
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
        double x = 0.0;
        if(a!=0)
            x=Math.abs((b-a)/a)*100.0;
        else if(a==0 && b==0)
            x=0.0;
        return x;
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

}
