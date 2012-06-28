package org.seagatesoft.math;

public class NewtonUnivariateSolver implements UnivariateSolver
{
	private int MAX_ITERATION = 1000000;
	private double ACCURACY = 0.0000000000001;
	private double DEFAULT_START_VALUE = 1.25;
	
	public double calculateRoot(UnivariateFunction univariateFunction)
	{
		return calculateRoot(univariateFunction, DEFAULT_START_VALUE);
	}

	public double calculateRoot(UnivariateFunction univariateFunction, double startValue)
	{
		UnivariateFunction derivative = univariateFunction.getDerivativeFunction();
		double x0 = startValue;
		double x1;
		
		for (int counter=0; counter < this.MAX_ITERATION; counter++)
		{
			x1 = x0 - ( univariateFunction.getValue(x0) / derivative.getValue(x0) );
			
			if ( Math.abs(x1 - x0) < this.ACCURACY )
				return x1;
				
			x0 = x1;
		}
		
		return Double.NaN;
	}
}