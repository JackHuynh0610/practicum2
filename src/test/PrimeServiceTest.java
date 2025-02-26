import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimesServiceTest {
    PrimesService primesService = new PrimesService();

    @Test
    void _60IsNotPrime() {
        int n = 60;
        boolean expected = false;
        boolean actual = primesService.isPrime(n);
        assertEquals(expected, actual);
    }

    @Test
    void _136279841IsPrime() {
        long n = 136279841L;
        boolean expected = true;
        boolean actual = primesService.isPrime(n);
        assertEquals(expected, actual);
    }

    @Test
    void _285198IsNotPrime() {
        long n = 285198;
        boolean expected = false;
        boolean actual = primesService.isPrime(n);
        assertEquals(expected, actual);
    }

}