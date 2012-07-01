package org.seagatesoft.math;

public class PolynomialFunction implements UnivariateFunction
{
	private double[] coefficients;
	
	public PolynomialFunction(double[] coefficients)
	{
		this.coefficients = coefficients;
	}

	public UnivariateFunction getDerivativeFunction()
	{
		double[] derivativeCoefficients = new double[this.coefficients.length-1];
		
		for (int index=0; index < derivativeCoefficients.length; index++)
		{
			derivativeCoefficients[index] = this.coefficients[index+1]*(index+1);
		}
		
		return new PolynomialFunction(derivativeCoefficients);
	}
	
	public double getValue(double input)
	{
		double value = this.coefficients[0];
		
		for (int exponent=1; exponent < this.coefficients.length; exponent++)
		{
			value += this.coefficients[exponent] * Math.pow(input, exponent);
		}
		
		return value;
	}
}