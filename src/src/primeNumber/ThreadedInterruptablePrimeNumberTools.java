package primeNumber;

/**
 * Hilfsklasse fuer Primzahlfunktionen
 * @author probably Prof. Dr.-Ing. Volodymyr Brovkov or Prof. Dr. Ralf Vandenhouten
 */
public class ThreadedInterruptablePrimeNumberTools extends Thread {
	private final int number;
	public ThreadedInterruptablePrimeNumberTools(int number)	{
		this.number = number;
	}
	
	public void run()	{
		this.printPrimeFactors(this.number);
	}
	
	/**
	 * Gibt die Primfaktorzerlegung einer ganzen Zahl aus
	 * @param num - die Zahl, die zerlegt werden soll
	 */
	public void printPrimeFactors(final int num) {
		int number = num;
		int whichprime = 1;
		int prime;
		String prefix;

		prefix = "primeFactors(" + number + ")= ";

		while (number > 1) {
			prime = getPrime(whichprime);

			if ((number % prime) == 0) {
				System.out.print(prefix + prime);
				prefix = " ";
				number /= prime;
			} else {
				++whichprime;
			}
		}

		System.out.println();
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
				// TODO Auto-generated catch block
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