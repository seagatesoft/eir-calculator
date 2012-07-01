eir-calculator
==============

<p>A program to calculate effective interest rate (EIR) from given present value and a series of cash flow. 
It's similar to <em>IRR</em> function in Microsoft Excel.</p>
<p>Given the present value and a series of cash flow, we can transform them into a polynomial function. 
The root of this function is calculated using Newton-Raphson method and then will be used to find the EIR.</p>