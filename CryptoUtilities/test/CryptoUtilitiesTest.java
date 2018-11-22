import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

/**
 * @author Put your name here
 *
 */
public class CryptoUtilitiesTest {

    /*
     * Tests of reduceToGCD
     */

    @Test
    public void testReduceToGCD_0_0() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber m = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals("0", n.toString());
        assertEquals("0", m.toString());
    }

    @Test
    public void testReduceToGCD_30_21() {
        NaturalNumber n = new NaturalNumber2(30);
        NaturalNumber m = new NaturalNumber2(21);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals("3", n.toString());
        assertEquals("0", m.toString());
    }

    /*
     * Tests of isEven
     */

    @Test
    public void testIsEven_0() {
        NaturalNumber n = new NaturalNumber2(0);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals("0", n.toString());
        assertTrue(result);
    }

    @Test
    public void testIsEven_1() {
        NaturalNumber n = new NaturalNumber2(1);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals("1", n.toString());
        assertTrue(!result);
    }

    /*
     * Tests of powerMod
     */

    @Test
    public void testPowerMod_0_0_2() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber p = new NaturalNumber2(0);
        NaturalNumber m = new NaturalNumber2(2);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals("1", n.toString());
        assertEquals("0", p.toString());
        assertEquals("2", m.toString());
    }

    @Test
    public void testPowerMod_17_18_19() {
        NaturalNumber n = new NaturalNumber2(17);
        NaturalNumber p = new NaturalNumber2(18);
        NaturalNumber m = new NaturalNumber2(19);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals("1", n.toString());
        assertEquals("18", p.toString());
        assertEquals("19", m.toString());
    }

    @Test
    public void testIsWitnessToCompositeness_15_17() {
        NaturalNumber w = new NaturalNumber2(15);
        NaturalNumber n = new NaturalNumber2(17);

        boolean prime = CryptoUtilities.isWitnessToCompositeness(w, n);
        assertEquals(false, prime);
    }

    @Test
    public void testIsWitnessToCompositeness_14_24() {
        NaturalNumber w = new NaturalNumber2(14);
        NaturalNumber n = new NaturalNumber2(24);

        boolean prime = CryptoUtilities.isWitnessToCompositeness(w, n);
        assertEquals(true, prime);
    }

    @Test
    public void testIsPrime2_71() {
        NaturalNumber n = new NaturalNumber2(71);

        boolean prime2 = CryptoUtilities.isPrime2(n);
        assertEquals(true, prime2);
    }

    @Test
    public void testIsPrime2_82() {
        NaturalNumber n = new NaturalNumber2(82);

        boolean prime2 = CryptoUtilities.isPrime2(n);
        assertEquals(false, prime2);
    }

    @Test
    public void testGenerateNextLikelyPrime_12() {
        NaturalNumber n = new NaturalNumber2(12);

        CryptoUtilities.generateNextLikelyPrime(n);
        assertEquals(13, n.toInt());
    }

    @Test
    public void testGenerateNextLikelyPrime_13() {
        NaturalNumber n = new NaturalNumber2(13);

        CryptoUtilities.generateNextLikelyPrime(n);
        assertEquals(13, n.toInt());
    }
}