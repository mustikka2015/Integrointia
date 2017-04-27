/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opetusohjelma.kayttoliittyma.controller;

import java.util.ArrayList;
import opetusohjelma.laskutoimituksia.Polynomi;
import opetusohjelma.laskutoimituksia.SinCos;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Iisa
 */
public class TehtavanArpojaTest {

    @Test
    public void toimintoArvottuOikeinTest() {
        TehtavanArpoja tehtarpoja = new TehtavanArpoja();
        String toiminto = tehtarpoja.arvoToiminto();
        assertTrue(toiminto.equals("Integrate") || toiminto.equals("Differentiate"));
    }

    @Test
    public void tehtavaArvottuOikeinTest() {
        TehtavanArpoja tehtarpoja = new TehtavanArpoja();
        String tuloste = tehtarpoja.arvoTehtava("Integrate", "2.4 * sin(5.7x)");
        assertEquals("Integrate function y = 2.4 * sin(5.7x). Click to check.", tuloste);
    }

    @Test
    public void sinCosFunktioArvottuOikeinTest() {
        ArrayList<String> funktioJaVast = new ArrayList<String>();
        String funktio = "sin";
        Arpoja arpoja = new Arpoja();
        TehtavanArpoja tehtarpoja = new TehtavanArpoja();
        funktioJaVast = tehtarpoja.sinCosFunktionArpominen(funktioJaVast, funktio, arpoja);
        String funktio1 = funktioJaVast.get(0);
        boolean sisaltyyko = funktio1.contains("sin");
        assertTrue(sisaltyyko);
    }

    @Test
    public void sinCosFunktioArvottuOikeinTest2() {
        ArrayList<String> funktioJaVast = new ArrayList<String>();
        String funktio = "sin";
        Arpoja arpoja = new Arpoja();
        TehtavanArpoja tehtarpoja = new TehtavanArpoja();
        funktioJaVast = tehtarpoja.sinCosFunktionArpominen(funktioJaVast, funktio, arpoja);
        String funktio1 = funktioJaVast.get(1);
        boolean sisaltyyko = funktio1.contains("cos");
        assertTrue(sisaltyyko);
    }

    @Test
    public void sinCosFunktioArvottuOikeinTest3() {
        ArrayList<String> funktioJaVast = new ArrayList<String>();
        String funktio = "sin";
        Arpoja arpoja = new Arpoja();
        TehtavanArpoja tehtarpoja = new TehtavanArpoja();
        funktioJaVast = tehtarpoja.sinCosFunktionArpominen(funktioJaVast, funktio, arpoja);
        String funktio1 = funktioJaVast.get(2);
        boolean sisaltyyko = funktio1.contains("cos");
        assertTrue(sisaltyyko);
    }

    @Test
    public void arvoFunktioTest() {
        TehtavanArpoja tehtarpoja = new TehtavanArpoja();
        ArrayList<String> funktioJaVast = tehtarpoja.arvoFunktio();
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
        TehtavanArpoja tehtarpoja = new TehtavanArpoja();
        funktioJaVast = tehtarpoja.polynomifunktionArpominen(funktioJaVast, arpoja);
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
