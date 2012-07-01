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
 * A class to calculate the effective interest rate (EIR) given the present value and a series of cash flow.
 * 
 * @author Sigit Dewanto
 *
 */
public class EIRCalculator
{
	/**
	 * An <tt>UnivariateSolver</tt> used to find the root of function derived from the present value and a series of cash flow.
	 */
	private UnivariateSolver univariateSolver = new NewtonUnivariateSolver();

	/**
	 * Method to calculate the effective interest rate (EIR) given the present value and a series of cash flow.
	 * 
	 * @param presentValue present value
	 * @param cashFlow series of cash flow
	 * @return the effective interest rate (EIR)
	 */
	public double calculateEIR(double presentValue, double[] cashFlow)
	{
		// transform presentValue and cashFlow to polynomial function's coefficients
		double[] coefficients = new double[cashFlow.length+1];
		coefficients[cashFlow.length]  = presentValue;
		
		for (int index=0; index < cashFlow.length; index++)
		{
			coefficients[cashFlow.length-index-1] = -1.00 * cashFlow[index];
		}

		// get zero of the function (its root)
		UnivariateFunction polynomialFunction = new PolynomialFunction(coefficients);
		double root = univariateSolver.calculateRoot(polynomialFunction);	
		
		return ( root - 1.00 );
	}
}