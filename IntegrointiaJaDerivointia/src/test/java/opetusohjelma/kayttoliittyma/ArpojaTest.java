package opetusohjelma.kayttoliittyma;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ArpojaTest {

    public ArpojaTest() {

    }

    @Test
    public void eksponenttiArvottuOikeinTest1() {
        Arpoja arpoja = new Arpoja();
        int eksp = arpoja.arvoPolynominEksponentti();
        assertTrue(-10 <= eksp && eksp <= 10);
    }

    @Test
    public void eksponenttiArvottuOikeinTest2() {
        Arpoja arpoja = new Arpoja();
        int eksp = arpoja.arvoPolynominEksponentti();
        assertFalse(eksp > 10 || eksp < -10);
    }


    @Test
    public void funktioArvottuOikeinTest() {
        Arpoja arpoja = new Arpoja();
        String funktio = arpoja.arvoFunktio();
        assertTrue(funktio.equals("polynom") || funktio.equals("sin") || funktio.equals("cos"));
    }

    @Test
    public void toimintoArvottuOikeinTest() {
        Arpoja arpoja = new Arpoja();
        String toiminto = arpoja.arvoToiminto();
        assertTrue(toiminto.equals("Integroi") || toiminto.equals("Derivoi"));
    }

    @Test
    public void kerroinArvottuOikeinTest1() {
        Arpoja arpoja = new Arpoja();
        double kerroin = arpoja.arvoKerroin();
        assertTrue(-10.0 <= kerroin && kerroin <= 10.0);
    }

    @Test
    public void kerroinArvottuOikeinTest2() {
        Arpoja arpoja = new Arpoja();
        double kerroin = arpoja.arvoKerroin();
        assertFalse(kerroin < -10.0 || kerroin > 10.0);
    }

}
