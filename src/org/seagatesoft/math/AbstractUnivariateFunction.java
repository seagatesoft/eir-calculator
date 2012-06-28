package org.seagatesoft.math;

public abstract class AbstractUnivariateFunction implements UnivariateFunction
{
	public double getRoot(UnivariateSolver univariateSolver)
	{
		return univariateSolver.calculateRoot(this);
	}
}