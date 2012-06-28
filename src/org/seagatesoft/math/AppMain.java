package org.seagatesoft.math;

public class AppMain
{
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