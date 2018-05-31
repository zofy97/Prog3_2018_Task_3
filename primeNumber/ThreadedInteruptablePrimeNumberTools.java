package primeNumber;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Hilfsklasse fuer Primzahlfunktionen
 *
 * @author probably Prof. Dr.-Ing. Volodymyr Brovkov or Prof. Dr. Ralf Vandenhouten
 */
public class ThreadedInteruptablePrimeNumberTools extends Thread {
    private final int number;

    public ThreadedInteruptablePrimeNumberTools(int number) {
        this.number = number;
    }

    public static class InvalidNumberException extends Exception {
        @Override
        public String getMessage() {
            return "don't use numbers smaller than 2";
        }
    }

    public static List<Integer> getFactors(int number) throws InvalidNumberException {
        if (2 > number) throw new InvalidNumberException();
        List<Integer> r = new ArrayList<>();
        return r;
    }

    public void run() {
        this.printPrimeFactors(number);
        this.outputPrimeFactors(number, this.printPrimeFactors(number));
    }

    public void calculatePrimeNumbers() {
        final int MAX_VALUE = Integer.MAX_VALUE;
        List<PrimeNumber> primeThreads = new ArrayList<>();
        List<Integer> primeNumbers = new ArrayList<>();
        for (int i = 0; i <= MAX_VALUE; i++)	{
            PrimeNumber p = new PrimeNumber(i);
            primeThreads.add(p);
            p.start();
        }
    }

    public void outputPrimeFactors(final int num, List<String> fac) {
        String output = "primeFactors(" + num + ") = \n";
        for (String a : fac) {
            output += a;
            output += "\n";
        }
        System.out.println(output);
    }

    /**
     * Gibt die Primfaktorzerlegung einer ganzen Zahl aus
     *
     * @param num - die Zahl, die zerlegt werden soll
     */
    public List printPrimeFactors(final int num) {
        int number = num;
        int whichprime = 1;
        int prime;
        List<String> factors = new ArrayList<>();
        PrimeNumber p = new PrimeNumber(whichprime);

        while (number > 1) {

            prime = p.getPrime(whichprime);

            if ((number % prime) == 0) {
                factors.add(prime + " ");
                number /= prime;
            } else {
                ++whichprime;
            }
        }
        return factors;
    }
}