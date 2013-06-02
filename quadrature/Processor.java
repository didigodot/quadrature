/**************************************
* A Processor can compute the definite
* integral of a function using three
* methods
*************************************/

public class Processor
{
    static double[][] data = new double[2][200];
    static double exp = 2.0;
    /*************************************************
    * Computes integral using trapezoidal rule
    * @param x  data file name
    * @param a  integration domain
    * @return   answer
    ************************************************/
    public static double trapezoidal(String x, double[] a)
    {
        //Uses trapezoidal rule to compute integral
        //asdf
        return -1;
    }
	 /*************************************************
    * Computes integral using Simpson's rule
    * @param x  data file name
    * @param a  integration domain
    * @return   answer
    ************************************************/
    public static double simpsons(String x, double[] a)
    {
        //Uses Simpson's rule to compute integral
        return -1;
    }
	 /************************************************
    * Computes integral using Boole's rule
    * @param x  data file name
    * @param a  integration domain
    * @return   answer
    ************************************************/
    public static double booles(String x, double[] a)
    {
        //Uses Boole's rule to compute intregral
        return -1;
    }
	 /************************************************
    * Redirects information to individual quadrature rule
    * @param x  quadrature rule type
    * @return   answer
    ************************************************/
    public static double compute(String x, double[] a)
    {
        // Depending on the contents of the string,
        // calls appropriate method
        if(x.equals("trapezoidal"))
            return (trapezoidal("trapezoidal.txt", a));
        if(x.equals("simpsons"))
            return(simpsons("simpsons.txt", a));
        if(x.equals("booles"))
            return(booles("booles.txt", a));
		  else
		  		return -1;
    }
    public static void makeData(String func, double[] intdo)
    {
        for(int i=0; i<(int)intdo[1]; i++)
        {
            double x = intdo[0]+(double)(i)/2;
            double y = Math.pow(x, exp);
            data[0][i]=x;
            data[1][i]=y;
        }
            
    }
}
