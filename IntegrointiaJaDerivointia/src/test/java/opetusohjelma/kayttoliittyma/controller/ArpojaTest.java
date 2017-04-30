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
    public void eksponenttiArvottuOikeinTest1() {
        opetusohjelma.kayttoliittyma.controller.Arpoja arpoja = new opetusohjelma.kayttoliittyma.controller.Arpoja();
        int eksp = arpoja.arvoPolynominEksponentti();
        assertTrue(-10 <= eksp && eksp <= 10);
    }

    public void eksponenttiArvottuOikeinTest2() {
        opetusohjelma.kayttoliittyma.controller.Arpoja arpoja = new opetusohjelma.kayttoliittyma.controller.Arpoja();
        int eksp = arpoja.arvoPolynominEksponentti();
        assertFalse(eksp > 10 || eksp < -10);
    }

    @Test
    public void funktioArvottuOikeinTest() {
        opetusohjelma.kayttoliittyma.controller.Arpoja arpoja = new opetusohjelma.kayttoliittyma.controller.Arpoja();
        String funktio = arpoja.arvoFunktio();
        assertTrue(funktio.equals("polynom") || funktio.equals("sin") || funktio.equals("cos"));
    }

    @Test
    public void toimintoArvottuOikeinTest() {
        opetusohjelma.kayttoliittyma.controller.Arpoja arpoja = new opetusohjelma.kayttoliittyma.controller.Arpoja();
        String toiminto = arpoja.arvoToiminto();
        assertTrue(toiminto.equals("Integrate") || toiminto.equals("Differentiate"));
    }

    @Test
    public void kerroinArvottuOikeinTest1() {
        opetusohjelma.kayttoliittyma.controller.Arpoja arpoja = new opetusohjelma.kayttoliittyma.controller.Arpoja();
        double kerroin = arpoja.arvoKerroin();
        assertTrue(-10.00 <= kerroin && kerroin <= 10.00);
    }

    @Test
    public void kerroinArvottuOikeinTest2() {
        opetusohjelma.kayttoliittyma.controller.Arpoja arpoja = new opetusohjelma.kayttoliittyma.controller.Arpoja();
        double kerroin = arpoja.arvoKerroin();
        assertFalse(kerroin < -10.0 || kerroin > 10.0);
    }
    
    @Test
    public void kerroinEiNollaTest() {
        opetusohjelma.kayttoliittyma.controller.Arpoja arpoja = new opetusohjelma.kayttoliittyma.controller.Arpoja();
        double kerroin = arpoja.arvoKerroin();
        assertFalse(kerroin == 0.0);
    }
    
    @Test
    public void tehtavaArvottuOikeinTest() {
        Arpoja arpoja = new Arpoja();
        String tuloste = arpoja.arvoTehtava("Integrate", "2.4 * sin(5.7x)");
        assertEquals("Integrate function y = 2.4 * sin(5.7x). Click to check.", tuloste);
    }
//
    @Test
    public void sinCosFunktioArvottuOikeinTest() {
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
    public void arvoFunktioTest() {
        Arpoja arpoja = new Arpoja();
        ArrayList<String> funktioJaVast = arpoja.arvoFunktioJaVastaukset();
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
    public void polynomifunktioArvottuOikeinTest() {
        ArrayList<String> funktioJaVast = new ArrayList<String>();
        Arpoja arpoja = new Arpoja();
        funktioJaVast = arpoja.polynomifunktionArpominen(funktioJaVast);
        boolean onko = false;
        String funktio1 = funktioJaVast.get(0);
        String derivaatta = funktioJaVast.get(1);
        String integraali = funktioJaVast.get(2);
        if (funktio1.contains("x^(") && derivaatta.contains("x^(") && integraali.contains("x^(")) {
            onko = true;
        }
        assertTrue(onko);
    }
}

