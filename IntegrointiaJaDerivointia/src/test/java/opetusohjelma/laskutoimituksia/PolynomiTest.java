package opetusohjelma.laskutoimituksia;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PolynomiTest {

    public PolynomiTest() {

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
    
    
}