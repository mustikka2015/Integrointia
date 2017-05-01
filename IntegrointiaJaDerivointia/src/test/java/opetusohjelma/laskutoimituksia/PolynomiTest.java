package opetusohjelma.laskutoimituksia;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PolynomiTest {

    public PolynomiTest() {

    }

    @Test
    public void funktioOikeinTest() {
        Polynomi pol = new Polynomi(4, 5.0);
        String funktio = pol.getFunktio();
        assertEquals("polynom", funktio);
    }

    @Test
    public void eksponenttiOikeinTest() {
        Polynomi pol = new Polynomi(4, 5.0);
        int eksp = pol.getEksponentti();
        assertEquals(eksp, 4);
    }

    @Test
    public void kerroinOikeinTest() {
        Polynomi pol = new Polynomi(4, 5.0);
        double ker = pol.getKerroin();
        String kerroin = Double.toString(ker);
        assertEquals("5.0", kerroin);
    }

    @Test
    public void integroituMuuttujaOikeinTest() {
        Polynomi pol = new Polynomi(4, 5.0);
        int onko = pol.getIntegroitu();

        assertEquals(0, onko);
    }

    @Test
    public void onkoLogaritmiOikeinTest() {
        Polynomi pol = new Polynomi(4, 5.0);
        boolean onko = pol.getLuonnollinenLogaritmi();

        assertEquals(onko, false);
    }

    @Test
    public void eksponentinAsetusOikeinTest() {
        Polynomi pol = new Polynomi(4, 5.0);
        pol.setEksponentti(6);
        int eksp = pol.getEksponentti();
        assertEquals(6, eksp);
    }

    @Test
    public void kertoimenAsetusOikeinTest() {
        Polynomi pol = new Polynomi(4, 5.0);
        pol.setKerroin(8.4);
        double ker = pol.getKerroin();
        String kerroin = Double.toString(ker);
        assertEquals("8.4", kerroin);
    }

    @Test
    public void integroituEksponenttiOikeinTest() {
        Polynomi pol = new Polynomi(4, 5.0);
        pol.integroi();
        int eks = pol.getEksponentti();
        assertEquals(5, eks);
    }

    @Test
    public void integroituKerroinOikeinTest() {
        Polynomi pol = new Polynomi(4, 5.0);
        pol.integroi();
        double ker = pol.getKerroin();
        String kerroin = Double.toString(ker);
        assertEquals("1.0", kerroin);
    }

    @Test
    public void integroituMuuttujaOikeinTest2() {
        Polynomi pol = new Polynomi(4, 5.0);
        pol.integroi();
        int onko = pol.getIntegroitu();

        assertEquals(1, onko);
    }

    @Test
    public void onkoLuonnollinenLogaritmiOikeinTest1() {
        Polynomi pol = new Polynomi(-1, 5.0);
        pol.integroi();
        boolean onko = pol.getLuonnollinenLogaritmi();

        assertEquals(onko, true);
    }

    @Test
    public void onkoLuonnollinenLogaritmiOikeinTest2() {
        Polynomi pol = new Polynomi(-2, 5.0);
        pol.integroi();
        boolean onko = pol.getLuonnollinenLogaritmi();

        assertEquals(onko, false);
    }

    @Test
    public void derivoituEksponenttiOikeinTest() {
        Polynomi pol = new Polynomi(4, 5.0);
        pol.derivoi();
        int eks = pol.getEksponentti();
        assertEquals(3, eks);
    }

    @Test
    public void derivoituKerroinOikeinTest() {
        Polynomi pol = new Polynomi(4, 5.0);
        pol.derivoi();
        double ker = pol.getKerroin();
        String kerroin = Double.toString(ker);
        assertEquals("20.0", kerroin);
    }

    @Test
    public void kerroinOikeinTest2() {
        Polynomi pol = new Polynomi(3, 3.7);
        pol.integroi();
        double ker = pol.getKerroin();
        String kerroin = Double.toString(ker);
        assertEquals("0.93", kerroin);
    }

    @Test
    public void kerroinOikeinTest3() {
        Polynomi pol = new Polynomi(3, 1.234567);
        double ker = pol.kertoimenPyoristys(0.267, pol.getKerroin());
        String kerroin = Double.toString(ker);
        assertEquals("1.23", kerroin);
    }

    @Test
    public void integroituMuuttujaOikeinTest3() {
        Polynomi pol = new Polynomi(4, 5.0);
        pol.derivoi();
        int onko = pol.getIntegroitu();

        assertEquals(0, onko);
    }

    @Test
    public void tulostusOikeinTest() {
        Polynomi pol = new Polynomi(4, 5.0);

        String tulostus = pol.toString();
        assertEquals("5.0 * x^(4)", tulostus);
    }

    @Test
    public void tulostusOikeinIntegroidessaTest1() {
        Polynomi pol = new Polynomi(4, 5.0);
        pol.integroi();
        String tulostus = pol.toString();
        assertEquals("1.0 * x^(5) + C", tulostus);
    }

    @Test
    public void tulostusOikeinIntegroidessaTest2() {
        Polynomi pol = new Polynomi(-1, 5.0);
        pol.integroi();
        String tulostus = pol.toString();
        assertEquals("5.0 * ln|x| + C", tulostus);
    }

    @Test
    public void tulostusOikeinDerivoidessaTest1() {
        Polynomi pol = new Polynomi(4, 5.0);
        pol.derivoi();
        String tulostus = pol.toString();
        assertEquals("20.0 * x^(3)", tulostus);
    }

    @Test
    public void tulostusOikeinDerivoidessaTest2() {
        Polynomi pol = new Polynomi(4, 5.0);
        pol.integroi();
        pol.derivoi();
        String tulostus = pol.toString();
        assertEquals("5.0 * x^(4)", tulostus);
    }

    @Test
    public void kertoimenPyoristysOikeinTest() {
        Polynomi pol = new Polynomi(2, 4.0);
        pol.integroi();
        String kerroin = Double.toString(pol.getKerroin());
        assertEquals(kerroin, "1.3");
    }
    
    @Test
    public void getYOikeinTest() {
        Polynomi pol = new Polynomi(2, 4.0);
        String kerroin = Double.toString(pol.getY(3));
        assertEquals(kerroin, "36.0");
    }

}
