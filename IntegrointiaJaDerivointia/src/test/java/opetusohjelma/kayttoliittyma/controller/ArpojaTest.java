/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opetusohjelma.kayttoliittyma.controller;

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

}
