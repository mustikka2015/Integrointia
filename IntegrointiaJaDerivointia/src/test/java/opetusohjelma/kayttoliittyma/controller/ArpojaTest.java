/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opetusohjelma.kayttoliittyma.controller;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ArpojaTest {

    public ArpojaTest() {

    }

    @Test
    public void eksponenttiEiNolla() {
        Arpoja arpoja = new Arpoja();
        int eksp = arpoja.arvoPolynominEksponentti();
        assertFalse(eksp == 0);
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
        assertTrue(toiminto.equals("Integrate") || toiminto.equals("Differentiate"));
    }

    @Test
    public void kerroinArvottuOikeinTest1() {
        Arpoja arpoja = new Arpoja();
        double kerroin = arpoja.arvoKerroin();
        assertTrue(-10.00 <= kerroin && kerroin <= 10.00);
    }

    @Test
    public void kerroinArvottuOikeinTest2() {
        Arpoja arpoja = new Arpoja();
        double kerroin = arpoja.arvoKerroin();
        assertFalse(kerroin < -10.0 || kerroin > 10.0 || kerroin == 0);
    }

    @Test
    public void tehtavaArvottuOikeinTest() {
        Arpoja arpoja = new Arpoja();
        String tuloste = arpoja.arvoTehtava("Integrate", "2.4 * sin(5.7x)");
        assertEquals("Integrate function y = 2.4 * sin(5.7x). Click to check.", tuloste);
    }

    @Test
    public void sinCosFunktioArvottuOikeinTest1() {
        ArrayList<String> funktioJaVast = new ArrayList<String>();
        String funktio = "sin";
        Arpoja arpoja = new Arpoja();
        funktioJaVast = arpoja.sinCosFunktionArpominen(funktioJaVast, funktio);
        String funktio1 = funktioJaVast.get(0);
        boolean sisaltyyko = funktio1.contains("sin");
        assertTrue(sisaltyyko);
    }

    @Test
    public void sinCosFunktioArvottuOikeinTest2() {
        ArrayList<String> funktioJaVast = new ArrayList<String>();
        String funktio = "sin";
        Arpoja arpoja = new Arpoja();
        funktioJaVast = arpoja.sinCosFunktionArpominen(funktioJaVast, funktio);
        String funktio1 = funktioJaVast.get(1);
        boolean sisaltyyko = funktio1.contains("cos");
        assertTrue(sisaltyyko);
    }

    @Test
    public void sinCosFunktioArvottuOikeinTest3() {
        ArrayList<String> funktioJaVast = new ArrayList<String>();
        String funktio = "sin";
        Arpoja arpoja = new Arpoja();
        funktioJaVast = arpoja.sinCosFunktionArpominen(funktioJaVast, funktio);
        String funktio1 = funktioJaVast.get(2);
        boolean sisaltyyko = funktio1.contains("cos");
        assertTrue(sisaltyyko);
    }

    @Test
    public void arvoFunktioJaVastauksetTest1() {
        Arpoja arpoja = new Arpoja();
        ArrayList<String> funktioJaVast = arpoja.arvoFunktioJaVastaukset(arpoja.arvoFunktio());
        String funktio = funktioJaVast.get(0);
        String derivaatta = funktioJaVast.get(1);
        String integraali = funktioJaVast.get(2);
        boolean onko = false;
        if (funktio.contains("sin") && derivaatta.contains("cos") && integraali.contains("cos")) {
            onko = true;
        }
        if (funktio.contains("cos") && derivaatta.contains("sin") && integraali.contains("sin")) {
            onko = true;
        }
        if (funktio.contains("x^(") && derivaatta.contains("x^(") && integraali.contains("x^(")) {
            onko = true;
        }
        assertTrue(onko);
    }

    @Test
    public void arvoFunktioJaVastauksetTest2() {
        Arpoja arpoja = new Arpoja();
        ArrayList<String> funktioJaVast = arpoja.arvoFunktioJaVastaukset("sin");
        String funktio = funktioJaVast.get(0);
        String derivaatta = funktioJaVast.get(1);
        String integraali = funktioJaVast.get(2);
        boolean onko = false;
        if (funktio.contains("sin") && derivaatta.contains("cos") && integraali.contains("cos")) {
            onko = true;
        }
        assertTrue(onko);
    }

    @Test
    public void arvoFunktioJaVastauksetTest3() {
        Arpoja arpoja = new Arpoja();
        ArrayList<String> funktioJaVast = arpoja.arvoFunktioJaVastaukset("cos");
        String funktio = funktioJaVast.get(0);
        String derivaatta = funktioJaVast.get(1);
        String integraali = funktioJaVast.get(2);
        boolean onko = false;
        if (funktio.contains("cos") && derivaatta.contains("sin") && integraali.contains("sin")) {
            onko = true;
        }
        assertTrue(onko);
    }

    @Test
    public void arvoFunktioJaVastauksetTest4() {
        Arpoja arpoja = new Arpoja();
        ArrayList<String> funktioJaVast = arpoja.arvoFunktioJaVastaukset("polynom");
        String funktio = funktioJaVast.get(0);
        String derivaatta = funktioJaVast.get(1);
        String integraali = funktioJaVast.get(2);
        boolean onko = false;
        if (funktio.contains("x^(") && derivaatta.contains("x^(") && integraali.contains("x^(")) {
            onko = true;
        }
        assertTrue(onko);
    }

    @Test
    public void polynomifunktioArvottuOikeinTest() {
        ArrayList<String> funktioJaVast = new ArrayList<String>();
        Arpoja arpoja = new Arpoja();
        funktioJaVast = arpoja.polynomifunktionArpominen(funktioJaVast);
        boolean onko = false;
        String funktio = funktioJaVast.get(0);
        String derivaatta = funktioJaVast.get(1);
        String integraali = funktioJaVast.get(2);
        String[] funk = funktio.split("x");
        int eksponentti1 = Integer.parseInt(funk[1].substring(2, 3));
        String[] deriv = derivaatta.split("x");
        int eksponentti2 = Integer.parseInt(deriv[1].substring(2, 3));
        String[] integ = integraali.split("x");
        int eksponentti3 = Integer.parseInt(integ[1].substring(2, 3));
        if (eksponentti1 - 1 == eksponentti2 && eksponentti3 - eksponentti1 == 1) {
            onko = true;
        }
        assertTrue(onko);
    }
}
