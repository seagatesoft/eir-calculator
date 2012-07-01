package org.seagatesoft.math;

public interface UnivariateFunction
{
	public UnivariateFunction getDerivativeFunction();
	
	public double getValue(double input);
}