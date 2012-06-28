package org.seagatesoft.math;

public class EIRCalculator
{
	public double calculateEIR(double presentValue, double[] cashFlow)
	{
		// transform presentValue and cashFlow to polynomial function coefficients
		double[] coefficients = new double[cashFlow.length+1];
		coefficients[cashFlow.length]  = presentValue;
		
		for (int index=0; index < cashFlow.length; index++)
		{
			coefficients[cashFlow.length-index-1] = -1.00 * cashFlow[index];
		}

		// get zero of the function (its root)
		UnivariateFunction polynomialFunction = new PolynomialFunction(coefficients);
		double root = polynomialFunction.getRoot(new NewtonUnivariateSolver());	
		
		return ( root - 1.00 );
	}
}