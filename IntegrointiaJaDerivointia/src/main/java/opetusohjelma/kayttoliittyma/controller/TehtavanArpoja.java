/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opetusohjelma.kayttoliittyma.controller;

import java.util.ArrayList;
import opetusohjelma.laskutoimituksia.Polynomi;
import opetusohjelma.laskutoimituksia.SinCos;

/**
 *
 * @author Iisa
 */
public class TehtavanArpoja {
    
    private ArrayList<String>funktioJaVast;
    
    public TehtavanArpoja() {
        
    } 
    
    /**
     * Metodi arpoo funktion. Se palauttaa ArrayList-olion, joka sisältää itse
     * funktion String-muodossa, funktion derivoituna String-muodossa sekä
     * funktion integroituna String-muodossa.
     *
     * @return ArrayList<String>, joka sisältää sekä funktion että sen
     * derivaatan ja integraalin.
     */
    public ArrayList<String> arvoFunktio() {
        Arpoja arpoja = new Arpoja();
        ArrayList<String> funktioJaVast = new ArrayList<String>();
        String funktio = arpoja.arvoFunktio();
        if (funktio.equals("sin") || funktio.equals("cos")) {
            funktioJaVast = sinCosFunktionArpominen(funktioJaVast, funktio, arpoja);

        } else {
            funktioJaVast = polynomifunktionArpominen(funktioJaVast, funktio, arpoja);
        }

        return funktioJaVast;
    }

    /**
     * Metodi arpoo sini- tai kosinifunktion kertoimet. Se palauttaa
     * ArrayList-olion, joka sisältää itse funktion String-muodossa, funktion
     * derivoituna String-muodossa sekä funktion integroituna String-muodossa.
     *
     * @return ArrayList<String>, joka sisältää sekä funktion että sen
     * derivaatan ja integraalin.
     */
    public ArrayList<String> sinCosFunktionArpominen(ArrayList<String> funktioJaVast, String funktio, Arpoja arpoja) {
        double kerroin1 = arpoja.arvoKerroin();
        double kerroin2 = arpoja.arvoKerroin();
        SinCos sincos = new SinCos(kerroin1, kerroin2, funktio);
        funktio = sincos.toString();
        funktioJaVast.add(funktio);
        SinCos derivoitu = new SinCos(sincos.getKerroin(), sincos.getSisafunktionKerroin(), sincos.getFunktio());
        SinCos integroitu = new SinCos(sincos.getKerroin(), sincos.getSisafunktionKerroin(), sincos.getFunktio());
        derivoitu.derivoi();
        integroitu.integroi();
        funktioJaVast.add(derivoitu.toString());
        funktioJaVast.add(integroitu.toString());
        return funktioJaVast;
    }

    /**
     * Metodi arpoo polynomifunktion kertoimen ja eksponentin. Se palauttaa
     * ArrayList-olion, joka sisältää itse funktion String-muodossa, funktion
     * derivoituna String-muodossa sekä funktion integroituna String-muodossa.
     *
     * @return ArrayList<String>, joka sisältää sekä funktion että sen
     * derivaatan ja integraalin.
     */
    public ArrayList<String> polynomifunktionArpominen(ArrayList<String> funktioJaVast, String funktio, Arpoja arpoja) {
        double kerroin = arpoja.arvoKerroin();
        int eks = arpoja.arvoPolynominEksponentti();
        Polynomi polynomi = new Polynomi(eks, kerroin);
        funktio = polynomi.toString();
        funktioJaVast.add(funktio);
        Polynomi derivoitu = new Polynomi(polynomi.getEksponentti(), polynomi.getKerroin());
        Polynomi integroitu = new Polynomi(polynomi.getEksponentti(), polynomi.getKerroin());
        derivoitu.derivoi();
        integroitu.integroi();
        funktioJaVast.add(derivoitu.toString());
        funktioJaVast.add(integroitu.toString());
        return funktioJaVast;
    }

    /**
     * Metodi arpoo, integroidaanko vai derivoidaanko funktio.
     *
     * @return String: "Integrate" tai "Derivate"
     */
    public String arvoToiminto() {
        Arpoja arpoja = new Arpoja();
        String toiminto = arpoja.arvoToiminto();
        return toiminto;
    }

    /**
     * Metodi kertoo tehtävänannon String-muodossa, kun sille on syötetty jo
     * aikaisemmin arvotut toiminto ja funktio.
     *
     * @return String: tehtävänanto
     */
    public String arvoTehtava(String toiminto, String funktio) {

        String tehtava = toiminto;
        tehtava = tehtava + " function y = " + funktio;
        tehtava = tehtava + ". Click to check.";
        return tehtava;
    }
}
