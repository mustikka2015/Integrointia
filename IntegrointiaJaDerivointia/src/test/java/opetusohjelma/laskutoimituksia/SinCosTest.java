package opetusohjelma.laskutoimituksia;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SinCosTest {

    public SinCosTest() {

    }

    @Test
    public void kerroinOikeinTest() {
        SinCos sin = new SinCos(2.0, 5.0, "sin");

        double ker = sin.getKerroin();
        String kerroin = Double.toString(ker);
        assertEquals("2.0", kerroin);
    }

    @Test
    public void sisafunktionKerroinOikeinTest() {
        SinCos sin = new SinCos(2.0, 5.0, "sin");

        double ker = sin.getSisafunktionKerroin();
        String kerroin = Double.toString(ker);
        assertEquals("5.0", kerroin);
    }

    @Test
    public void kertoimenAsetusOikeinTest() {
        SinCos sin = new SinCos(2.0, 5.0, "sin");
        sin.setKerroin(7.0);
        double ker = sin.getKerroin();
        String kerroin = Double.toString(ker);
        assertEquals("7.0", kerroin);
    }

    @Test
    public void sisafunktionKertoimenAsetusOikeinTest() {
        SinCos sin = new SinCos(2.0, 5.0, "sin");
        sin.setSisafunktionKerroin(4.0);
        double ker = sin.getSisafunktionKerroin();
        String kerroin = Double.toString(ker);
        assertEquals("4.0", kerroin);
    }

    @Test
    public void funktioOikeinTest1() {
        SinCos sin = new SinCos(2.0, 5.0, "sin");
        String funktio = sin.getFunktio();

        assertEquals("sin", funktio);
    }

    @Test
    public void funktioOikeinTest2() {
        SinCos sin = new SinCos(2.0, 5.0, "Sin");
        String funktio = sin.getFunktio();

        assertEquals("sin", funktio);
    }

    @Test
    public void funktioOikeinTest3() {
        SinCos cos = new SinCos(2.0, 5.0, "cos");
        String funktio = cos.getFunktio();

        assertEquals("cos", funktio);
    }

    @Test
    public void funktioOikeinTest4() {
        SinCos cos = new SinCos(2.0, 5.0, "Cos");
        String funktio = cos.getFunktio();

        assertEquals("cos", funktio);
    }

    @Test
    public void funktioOikeinTest5() {
        SinCos tan = new SinCos(2.0, 5.0, "tan");
        String funktio = tan.getFunktio();

        assertEquals("", funktio);
    }

    @Test
    public void derivoinninJalkeenKerroinOikeinTest1() {
        SinCos sini = new SinCos(2.0, 5.0, "sin");
        sini.derivoi();
        double ker = sini.getKerroin();
        String kerroin = Double.toString(ker);
        assertEquals("10.0", kerroin);

    }

    @Test
    public void derivoinninJalkeenKerroinOikeinTest2() {
        SinCos kosini = new SinCos(2.0, 4.0, "cos");
        kosini.derivoi();
        double ker = kosini.getKerroin();
        String kerroin = Double.toString(ker);
        assertEquals("-8.0", kerroin);

    }

    @Test
    public void derivoinninJalkeenFunktioOikeinTest1() {
        SinCos sini = new SinCos(2.0, 5.0, "sin");
        sini.derivoi();
        String funk = sini.getFunktio();

        assertEquals("cos", funk);

    }

    @Test
    public void derivoinninJalkeenFunktioOikeinTest2() {
        SinCos kosini = new SinCos(2.0, 5.0, "cos");
        kosini.derivoi();
        String funk = kosini.getFunktio();

        assertEquals("sin", funk);

    }

    @Test
    public void integroinninJalkeenKerroinOikeinTest1() {
        SinCos sini = new SinCos(2.0, 5.0, "sin");
        sini.integroi();
        double ker = sini.getKerroin();
        String kerroin = Double.toString(ker);
        assertEquals("-0.4", kerroin);

    }

    @Test
    public void onIntegroituOikeinTest() {
        SinCos sini = new SinCos(2.0, 5.0, "sin");
        sini.integroi();
        boolean onko = sini.getIntergroitu();
        assertEquals(true, onko);
    }

    @Test
    public void integroinninJalkeenKerroinOikeinTest2() {
        SinCos kosini = new SinCos(6.0, 2.0, "cos");
        kosini.integroi();
        double ker = kosini.getKerroin();
        String kerroin = Double.toString(ker);
        assertEquals("3.0", kerroin);

    }

    @Test
    public void integroinninJalkeenFunktioOikeinTest1() {
        SinCos sini = new SinCos(2.0, 5.0, "sin");
        sini.integroi();
        String funk = sini.getFunktio();

        assertEquals("cos", funk);

    }

    @Test
    public void integroinninJalkeenFunktioOikeinTest2() {
        SinCos kosini = new SinCos(2.0, 5.0, "cos");
        kosini.integroi();
        String funk = kosini.getFunktio();

        assertEquals("sin", funk);

    }

    @Test
    public void tulostusOikeinTest() {
        SinCos kosini = new SinCos(2.0, 5.0, "cos");

        String tulostus = kosini.toString();
        assertEquals("2.0 * cos(5.0x)", tulostus);
    }

    @Test
    public void tulostusOikeinDerivoinninJalkeenTest() {
        SinCos kosini = new SinCos(2.0, 5.0, "cos");
        kosini.derivoi();

        String tulostus = kosini.toString();
        assertEquals("-10.0 * sin(5.0x)", tulostus);
    }

    @Test
    public void tulostusOikeinIntegroinninJalkeenTest() {
        SinCos kosini = new SinCos(2.0, 5.0, "cos");
        kosini.integroi();

        String tulostus = kosini.toString();
        assertEquals("0.4 * sin(5.0x) + C", tulostus);
    }

     @Test
    public void kertoimenPyoristysOikeinTest() {
        SinCos sin = new SinCos(2.34, 6.7, "sin");
        sin.integroi();
        String kerroin = Double.toString(sin.getKerroin());
        assertEquals(kerroin, "-0.35");
    }
}
