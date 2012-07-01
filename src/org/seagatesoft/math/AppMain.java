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
 * Main class. 
 * 
 * @author Sigit Dewanto
 *
 */
public class AppMain
{
	/**
	 * Main method.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		double presentValue = 495000000.00;
		double[] cashFlow = {44424394.34, 44424394.34, 44424394.34, 44424394.34, 44424394.34, 44424394.34, 44424394.34, 44424394.34, 44424394.34, 44424394.34, 44424394.34, 44424394.34};

		EIRCalculator eirCalculator = new EIRCalculator();
		double eir = eirCalculator.calculateEIR(presentValue, cashFlow);

		System.out.printf("EIR monthly = %s\n", eir);
		System.out.printf("EIR annually = %s\n", (eir*12));
	}
}