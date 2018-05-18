package primeNumber;

import java.util.ArrayList;
import java.util.List;

/**
 * Hilfsklasse fuer Primzahlfunktionen
 * @author probably Prof. Dr.-Ing. Volodymyr Brovkov or Prof. Dr. Ralf Vandenhouten
 */
public class ThreadedInteruptablePrimeNumberTools extends Thread {
	private final int number;
	public ThreadedInteruptablePrimeNumberTools(int number)	{
		this.number = number;
	}
	
	public static class InvalidNumberException extends Exception	{
		@Override public String getMessage()	{
			return "keine Zerlegung für natürliche Zahlen kleiner als 2";
		}
	}
	public static List<Integer> getFactors(int number) throws InvalidNumberException	{
		if (2 > number) throw new InvalidNumberException();
		List<Integer> r = new ArrayList<>();
		return r;
	}
	
	public void run()	{
		List<Integer> numbers = new ArrayList<>();
		for (int n : numbers) {
			if (n == this.number)	{
				
			}
		}
		numbers.add(this.number);
		this.printPrimeFactors(number);
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
		PrimeNumber p = new PrimeNumber(whichprime);

		prefix = "primeFactors(" + number + ")= ";

		while (number > 1) {
			
			prime = p.getPrime(whichprime);

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
}