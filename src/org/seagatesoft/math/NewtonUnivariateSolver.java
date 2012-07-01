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
 * A class that can find the root of univariate function (zero of the function) using Newton-Raphson method.
 * 
 * @author Sigit Dewanto
 *
 */
public class NewtonUnivariateSolver implements UnivariateSolver
{
	/**
	 * Maximum iteration steps.
	 */
	private int MAX_ITERATION = 1000000;
	/**
	 * We found the root of the function if current root - previous root < <tt>ACCURACY</tt>
	 */
	private double ACCURACY = 0.0000000000001;
	/**
	 * Default initial value for the first iteration. Used if method's caller doesn't specify the start value. 
	 */
	private double DEFAULT_START_VALUE = 1.25;
	
	/**
	 * Calculate the root (zero of the function) of given univariate function.
	 * 
	 * @param univariateFunction the univariate function
	 * @return the root (zero of the function) of given univariate function.
	 */
	public double calculateRoot(UnivariateFunction univariateFunction)
	{
		return calculateRoot(univariateFunction, DEFAULT_START_VALUE);
	}

	/**
	 * Calculate the root (zero of the function) of given univariate function using Newton-Raphson method.
	 * 
	 * @param univariateFunction univariateFunction the univariate function
	 * @param startValue the initial value for the first iteration in numerical method used to find zero of the function.
	 * @return the root (zero of the function) of given univariate function.
	 */
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