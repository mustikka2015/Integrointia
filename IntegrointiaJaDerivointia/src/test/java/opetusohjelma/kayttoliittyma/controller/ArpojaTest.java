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

/**
 * Tämän luokan avulla testataan luokkaa Arpoja, jonka oliot arpovat sekä itse
 * funktion, että sen kertoimet.
 *
 * @author Iisa
 */
public class ArpojaTest {

    public ArpojaTest() {

    }

    /**
     * Metodin avulla testataan, että arvottu eksponentti on väliltä [-10,10].
     */
    @Test
    public void eksponenttiArvottuOikeinTest1() {
        opetusohjelma.kayttoliittyma.controller.Arpoja arpoja = new opetusohjelma.kayttoliittyma.controller.Arpoja();
        int eksp = arpoja.arvoPolynominEksponentti();
        assertTrue(-10 <= eksp && eksp <= 10);
    }

    /**
     * Metodin avulla testataan, että arvottu eksponentti on väliltä [-10,10].
     */
    @Test
    public void eksponenttiArvottuOikeinTest2() {
        opetusohjelma.kayttoliittyma.controller.Arpoja arpoja = new opetusohjelma.kayttoliittyma.controller.Arpoja();
        int eksp = arpoja.arvoPolynominEksponentti();
        assertFalse(eksp > 10 || eksp < -10);
    }

    /**
     * Metodin avulla testataan, että arvottu funktio on joko "polynom", "sin"
     * tai "cos".
     */
    @Test
    public void funktioArvottuOikeinTest() {
        opetusohjelma.kayttoliittyma.controller.Arpoja arpoja = new opetusohjelma.kayttoliittyma.controller.Arpoja();
        String funktio = arpoja.arvoFunktio();
        assertTrue(funktio.equals("polynom") || funktio.equals("sin") || funktio.equals("cos"));
    }

    /**
     * Metodin avulla testataan, että arvottu toiminto on joko "Integrate" tai
     * "Derivate".
     */
    @Test
    public void toimintoArvottuOikeinTest() {
        opetusohjelma.kayttoliittyma.controller.Arpoja arpoja = new opetusohjelma.kayttoliittyma.controller.Arpoja();
        String toiminto = arpoja.arvoToiminto();
        assertTrue(toiminto.equals("Integrate") || toiminto.equals("Derivate"));
    }

    /**
     * Metodin avulla testataan, että arvottu kerroin on väliltä [-10.0,10.0].
     */
    @Test
    public void kerroinArvottuOikeinTest1() {
        opetusohjelma.kayttoliittyma.controller.Arpoja arpoja = new opetusohjelma.kayttoliittyma.controller.Arpoja();
        double kerroin = arpoja.arvoKerroin();
        assertTrue(-10.0 <= kerroin && kerroin <= 10.0);
    }

    /**
     * Metodin avulla testataan, että arvottu kerroin on väliltä [-10.0,10.0].
     */
    @Test
    public void kerroinArvottuOikeinTest2() {
        opetusohjelma.kayttoliittyma.controller.Arpoja arpoja = new opetusohjelma.kayttoliittyma.controller.Arpoja();
        double kerroin = arpoja.arvoKerroin();
        assertFalse(kerroin < -10.0 || kerroin > 10.0);
    }

}
