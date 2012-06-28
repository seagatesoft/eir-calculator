package org.seagatesoft.math;

public interface UnivariateSolver
{
	public double calculateRoot(UnivariateFunction univariateFunction);
	public double calculateRoot(UnivariateFunction univariateFunction, double startValue);
}