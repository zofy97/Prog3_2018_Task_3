public class ThreadedPrimeNumberTools extends ThreadedInterruptablePrimeNumberTools implements Runnable	{
	private final int number;
	public ThreadedPrimeNumberTools(int n)	{
		super(n);
		number = n;
	}
	
	public void run()	{
		this.printPrimeFactors(this.number);
	}
}
