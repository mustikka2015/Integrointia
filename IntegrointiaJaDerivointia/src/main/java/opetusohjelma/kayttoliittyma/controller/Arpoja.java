/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opetusohjelma.kayttoliittyma.controller;

import java.util.ArrayList;
import java.util.Random;
import opetusohjelma.laskutoimituksia.Polynomi;
import opetusohjelma.laskutoimituksia.SinCos;

/**
 * Luokka tarjoaa funktion, eksponentin ja kertoimen arpomiseen tarvittavia
 * metodeja.
 *
 * @author Iisa
 */
public class Arpoja {

    private Random arpoja;

    /**
     * Metodi alustaa Random-tyyppisen Arpoja-olion. 
     */
    public Arpoja() {
        this.arpoja = new Random();
    }

    /**
     * Metodi arpoo funktion, jonka opiskelijan tulee integroida tai derivoida.
     * Funktiovaihtoehdot ovat polynomi-, sini- ja kosinifunktio.
     *
     * @return String: "polynom", "sin" tai "cos".
     */
    public String arvoFunktio() {
        ArrayList<String> funktiot = new ArrayList<String>();
        funktiot.add("polynom");
        funktiot.add("sin");
        funktiot.add("cos");

        int arvottu = this.arpoja.nextInt(funktiot.size());

        String funktio = funktiot.get(arvottu);

        return funktio;
    }

    /**
     * Metodi arpoo polynomifunktion eksponentin. Eksponentti voi saada arvoja
     * -10:stä 10:een.
     *
     * @return arvottu eksponentti int-muodossa.
     */
    public int arvoPolynominEksponentti() {

        int arvottu = this.arpoja.nextInt(21);
        arvottu = arvottu - 10;

        return arvottu;
    }

    /**
     * Metodi arpoo double-tyyppisen kertoimen. Kerroin voi saada arvoja
     * -10.0:stä 10.0:een. Kerroin ei saa olla 0.
     *
     * @return arvottu kerroin double-muodossa.
     */
    public double arvoKerroin() {
        
        int arvottu1 = this.arpoja.nextInt(201);
        
        while (arvottu1 == 100) {
            arvottu1 = this.arpoja.nextInt(201);
        }

        double arvottu = (double) (this.arpoja.nextInt(201) - 100) / 10;
        
        


        return arvottu;
    }

    /**
     * Metodi arpoo, integroidaanko vai derivoidaanko funktio.
     *
     * @return String: "Integrate" tai "Differentiate".
     */
    public String arvoToiminto() {

        ArrayList<String> vaihtoehdot = new ArrayList<String>();

        vaihtoehdot.add("Integrate");
        vaihtoehdot.add("Differentiate");

        int arvottu = this.arpoja.nextInt(vaihtoehdot.size());

        String toiminta = vaihtoehdot.get(arvottu);

        return toiminta;
    }
    
    /**
     * Metodi kertoo tehtävänannon String-muodossa, kun sille on syötetty jo
     * aikaisemmin arvotut toiminto ja funktio.
     *
     * @param toiminto String-muodossa
     * @param funktio String-muodossa
     *
     * @return String: tehtävänanto
     */
    public String arvoTehtava(String toiminto, String funktio) {

        String tehtava = toiminto;
        tehtava = tehtava + " function y = " + funktio;
        tehtava = tehtava + ". Click to check.";
        return tehtava;
    }
    
     /**
     * Metodi arpoo funktion. Se palauttaa ArrayList-olion, joka sisältää itse
     * funktion String-muodossa, funktion derivoituna String-muodossa sekä
     * funktion integroituna String-muodossa.
     *
     * @return ArrayList<String>, joka sisältää sekä funktion että sen
     * derivaatan ja integraalin.
     */
    public ArrayList<String> arvoFunktioJaVastaukset() {
//        Arpoja arpoja = new Arpoja();
        ArrayList<String> funktioJaVast = new ArrayList<String>();
        String funktio = arvoFunktio();
        if (funktio.equals("sin") || funktio.equals("cos")) {
            funktioJaVast = sinCosFunktionArpominen(funktioJaVast, funktio);

        } else {
            funktioJaVast = polynomifunktionArpominen(funktioJaVast);
        }

        return funktioJaVast;
    }
    
    /**
     * Metodi arpoo polynomifunktion kertoimen ja eksponentin. Se palauttaa
     * ArrayList-olion, joka sisältää itse funktion String-muodossa, funktion
     * derivoituna String-muodossa sekä funktion integroituna String-muodossa.
     *
     * @param funktioJaVast ArrayList<String>-muodossa
     *
     * @return ArrayList<String>, joka sisältää sekä funktion että sen
     * derivaatan ja integraalin.
     */
    public ArrayList<String> polynomifunktionArpominen(ArrayList<String> funktioJaVast) {
        double kerroin = arvoKerroin();
        int eks = arvoPolynominEksponentti();
        Polynomi polynomi = new Polynomi(eks, kerroin);
        String funktio = polynomi.toString();
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
     * Metodi arpoo sini- tai kosinifunktion kertoimet. Se palauttaa
     * ArrayList-olion, joka sisältää itse funktion String-muodossa, funktion
     * derivoituna String-muodossa sekä funktion integroituna String-muodossa.
     *
     * @param funktioJaVast ArrayList<String>-muodossa
     * @param funktio String-muodossa
     *
     * @return ArrayList<String>, joka sisältää sekä funktion että sen
     * derivaatan ja integraalin.
     */
    public ArrayList<String> sinCosFunktionArpominen(ArrayList<String> funktioJaVast, String funktio) {
        double kerroin1 = arvoKerroin();
        double kerroin2 = arvoKerroin();
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

}
