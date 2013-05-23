/**************************************
* A Processor can compute the definite
* integral of a function using three
* methods
*************************************/

public class Processor
{
    public static double trapezoidal(String x, int[] a)
    {
        //Uses trapezoidal rule to compute integral
        return -1;
    }
    public static double simpsons(String x, int[] a)
    {
        //Uses Simpson's rule to compute integral
        return -1;
    }
    public static double booles(String x, int[] a)
    {
        //Uses Boole's rule to compute intregral
        return -1
    }
    public static double compute(String x)
    {
        // Depending on the contents of the string,
        // calls appropriate method
        if(x.equals("trapezoidal")
            return (trapezoidal("trapezoidal.txt"));
        if(x.equals("simpsons")
            return(simpsons("simpsons.txt"));
        if(x.equals("booles")
            return(booles("booles.txt"));
    }

}
