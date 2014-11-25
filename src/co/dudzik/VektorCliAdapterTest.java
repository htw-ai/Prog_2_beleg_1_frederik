package co.dudzik;

import org.junit.Test;

import static org.junit.Assert.*;

public class VektorCliAdapterTest {

    @Test
    public void testConvert() throws Exception {
        double[] ergebnis  = { 3, 123, 2 };
        String x = "3:123:2";
        assertArrayEquals(ergebnis, VektorCliAdapter.convert(x).Ausgabe(), 0.0);
    }

}