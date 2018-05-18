package primeNumber;

public class PrimeNumber extends Thread {

	int number;
	public PrimeNumber(int n)	{
		number = n;
	}
	
	public void run()	{
		this.getPrime(this.number);
	}
	
	/**
	 * Gibt die n-te Primzahl zurueck
	 * @param n
	 * @return die n-te Primzahl
	 */
	public int getPrime(final int n) {
		int i = 1;
		int ret = 2;

		while (i < n) {
			++ret;
			try {
				if (isPrime(ret)) {
					++i;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		return ret;
	}
	
	/**
	 * testet, ob num Primzahl ist
	 * @param num
	 * @return true, falls num eine Primzahl ist
	 */
	private boolean isPrime(int num) throws InterruptedException {
		for (int i = 2; i < num; ++i) {
			if(this.isInterrupted()) throw new InterruptedException();
			if ((num % i) == 0) {
				return false;
			}
		}
		return true;
	}
}
