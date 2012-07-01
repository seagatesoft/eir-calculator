/*
 * EIR Calculator 
 * Copyright (c) 2012 Sigit Dewanto, http://seagatesoft.com
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions: The above copyright
 * notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.seagatesoft.math;

/**
 * A subclass of <tt>UnivariateFunction</tt> that represents a polynomial function.
 * 
 * @author Sigit Dewanto
 *
 */
public class PolynomialFunction implements UnivariateFunction
{
	/**
	 * Array that holds function's coefficients. 
	 * The 0th element of this array holds x^0 coefficient, the 1st element holds x^1 coefficient and so on.
	 */
	private double[] coefficients;
	
	/**
	 * Constructor that accepts array of polynomial function's coefficients as its argument.
	 * The 0th element of this array holds x^0 coefficient, the 1st element holds x^1 coefficient and so on.
	 * 
	 * @param coefficients array that holds function's coefficients. The 0th element of this array holds x^0 coefficient, the 1st element holds x^1 coefficient and so on.
	 */
	public PolynomialFunction(double[] coefficients)
	{
		this.coefficients = coefficients;
	}

	/**
	 * Returns the derivative function of this function.
	 * 
	 * @return the derivative function of this function.
	 */
	public UnivariateFunction getDerivativeFunction()
	{
		double[] derivativeCoefficients = new double[this.coefficients.length-1];
		
		for (int index=0; index < derivativeCoefficients.length; index++)
		{
			derivativeCoefficients[index] = this.coefficients[index+1]*(index+1);
		}
		
		return new PolynomialFunction(derivativeCoefficients);
	}
	
	/**
	 * Returns the value of this function given <tt>input</tt> as its argument.
	 * 
	 * @param input function's argument.
	 * @return the value of this function given <tt>input</tt> as its argument.
	 */
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