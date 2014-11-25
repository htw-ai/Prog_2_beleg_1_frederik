package co.dudzik;

import org.junit.Test;

import static org.junit.Assert.*;

public class VektorTest {
    @Test
    public void testLänge() throws Exception {
         double[] v = { 1, 2, 3 };
         double x = 14;
         Vektor vektor = new Vektor(v);
         assertEquals(Math.sqrt(x), vektor.länge(), 0.0);
    }

    @Test
    public void testSumme() throws Exception {
        double[] v = { 1, 2, 3 };
        double[] vErgebnis = { 2, 4, 6 };
        Vektor vektor = new Vektor(v);
        Vektor vektor1 = new Vektor(v);
        assertArrayEquals(vErgebnis, vektor.summe(vektor1).Ausgabe(), 0.0);
    }

    @Test
    public void testAusgabe() throws Exception {
        double[] v = { 1, 2, 3 };
        double[] vErgebnis = { 1, 2, 3 };
        Vektor vektor = new Vektor(v);
        assertArrayEquals(vErgebnis, vektor.Ausgabe(), 0.0);
    }

    @Test
    public void testDifferenz() throws Exception {
        double[] v = { 1, 2, 3 };
        double[] vErgebnis = { 0, 0, 0 };
        Vektor vektor = new Vektor(v);
        Vektor vektor1 = new Vektor(v);
        assertArrayEquals(vErgebnis, vektor.differenz(vektor1).Ausgabe(), 0.0);
    }

    @Test
    public void testSkalarprodukt() throws Exception {
        double[] v = { 1, 3, 5 };
        double[] v1 = { 2, 0, 4 };
        Vektor vektor = new Vektor(v);
        Vektor vektor1 = new Vektor(v1);
        assertEquals(22, vektor.skalarprodukt(vektor1), 0.0);
    }

    @Test
    public void testEinheitsvektor() throws Exception {
        double[] v = { 3, -2, 6 };
        double[] expected = {0.428571, -0.285714, 0.857143};
        Vektor vektor = new Vektor(v);
        assertArrayEquals(expected, vektor.einheitsvektor().Ausgabe(), 0.0001);
    }

    @Test
    public void testVektorprodukt() throws Exception {
        double[] v = { 1, -5, 2 };
        double[] v1 = { 2, 0, 3 };
        Vektor vektor = new Vektor(v);
        Vektor vektor1 = new Vektor(v1);
        double[] ergebnis = { -15, 1, 10 };
        assertArrayEquals(ergebnis, vektor.vektorprodukt(vektor1).Ausgabe(), 0.0);
    }

    @Test
    public void testSpatprodukt() throws Exception {
        double[] v  = { 2, -1, 3 };
        double[] v1 = { -9, -5, -2 };
        Vektor vektor = new Vektor(v);
        Vektor kreuz = new Vektor(v1);
        double ergebnis = -19;
        assertEquals(ergebnis, vektor.spatprodukt(kreuz), 0.0);
    }

    @Test
    public void testIsOfDimension() throws Exception {
        double[] v = { 1, 2, 3, 5};
        Vektor vektor = new Vektor(v);
        assertTrue(vektor.isOfDimension(4));
    }

    @Test
    public void testHasDimensionOf() throws Exception {
        double[] v = { 1, 2, 3, 5};
        Vektor vektor = new Vektor(v);
        assertEquals(4, vektor.hasDimensionOf());
    }

    @Test
    public void testToString() throws Exception {
        double[] v = { 1, 2, 3, 5};
        Vektor vektor = new Vektor(v);
        assertEquals("[1.0, 2.0, 3.0, 5.0]", vektor.toString());
    }
}