package test;

import org.junit.Test;
import primeNumber.PrimeNumber;

import static org.junit.Assert.*;

public class PrimeNumberTest {

    int prime = 19;

    PrimeNumber p = new PrimeNumber(prime);

    @Test
    public void testGetPrimeTrue()  {
        assertTrue(p.getPrime(prime) == 67);
    }

    @Test
    public void testGetPrimeFalse() {
        assertFalse(p.getPrime(prime) == 19);
    }
}
