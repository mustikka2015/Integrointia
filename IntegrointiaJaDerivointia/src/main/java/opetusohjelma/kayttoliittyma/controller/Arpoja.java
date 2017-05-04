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
 * Luokka tarjoaa funktion, eksponentin, kertoimen ja koko tehtävänannon
 * arpomiseen tarvittavia metodeja.
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
     * @return String "polynom", "sin" tai "cos".
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

        int eksponentti = this.arpoja.nextInt(21);
        eksponentti = eksponentti - 10;

        return eksponentti;
    }

    /**
     * Metodi arpoo double-tyyppisen kertoimen. Kerroin voi saada arvoja
     * -10.0:stä 10.0:een. Kerroin ei saa olla 0.
     *
     * @return arvottu kerroin double-muodossa.
     */
    public double arvoKerroin() {

        int arvottu = this.arpoja.nextInt(201);

        while (arvottu == 100) {
            arvottu = this.arpoja.nextInt(201);
        }

        double kerroin = (double) (this.arpoja.nextInt(201) - 100) / 10;

        return kerroin;
    }

    /**
     * Metodi arpoo, integroidaanko vai derivoidaanko funktio.
     *
     * @return String: "Integrate" tai "Differentiate".
     */
    public String arvoToiminta() {

        ArrayList<String> vaihtoehdot = new ArrayList<>();

        vaihtoehdot.add("Integrate");
        vaihtoehdot.add("Differentiate");

        int arvottu = this.arpoja.nextInt(vaihtoehdot.size());

        String toiminta = vaihtoehdot.get(arvottu);

        return toiminta;
    }

    /**
     * Metodi kertoo tehtävänannon String-muodossa, kun sille on syötetty jo
     * aikaisemmin arvotut toiminta ja funktio.
     *
     * @param toiminta String-muodossa
     * @param funktio String-muodossa
     *
     * @return String: tehtävänanto
     */
    public String tulostaTehtava(String toiminta, String funktio) {

        String tehtava = toiminta;
        tehtava = tehtava + " function y = " + funktio;
        tehtava = tehtava + ". Click to check.";
        return tehtava;
    }

    /**
     * Metodi palauttaa ArrayList-olion, joka sisältää itse funktion
     * String-muodossa, funktion derivoituna String-muodossa sekä funktion
     * integroituna String-muodossa.
     *
     * @param funktio String -muodossa
     *
     * @return ArrayList:n, joka sisältää sekä funktion että sen derivaatan ja
     * integraalin String-muodossa.
     */
    public ArrayList<String> arvoFunktioJaVastaukset(String funktio) {
        ArrayList<String> funktioJaVast = new ArrayList<>();
        if (funktio.equals("sin") || funktio.equals("cos")) {
            funktioJaVast = sinCosFunktionArpominen(funktioJaVast, funktio);
        } else {
            funktioJaVast = polynomifunktionArpominen(funktioJaVast);
        }
        return funktioJaVast;
    }

    /**
     * Metodi arpoo polynomifunktion kertoimen ja eksponentin. Se palauttaa
     * ArrayList-olion, joka sisältää itse funktion, funktion derivoituna, sekä
     * funktion integroituna String-muodossa.
     *
     * @param funktioJaVast ArrayList -muodossa
     *
     * @return ArrayList, joka sisältää sekä funktion että sen derivaatan ja
     * integraalin.
     */
    public ArrayList<String> polynomifunktionArpominen(ArrayList<String> funktioJaVast) {
        double kerroin = arvoKerroin();
        int eksponentti = arvoPolynominEksponentti();
        Polynomi polynomi = new Polynomi(eksponentti, kerroin);
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
     * ArrayList-olion, joka sisältää itse funktion, funktion derivoituna, sekä
     * funktion integroituna String-muodossa.
     *
     * @param funktioJaVast ArrayList-muodossa
     * @param funktio String-muodossa
     *
     * @return ArrayList, joka sisältää sekä funktion että sen derivaatan ja
     * integraalin String-muodossa.
     */
    public ArrayList<String> sinCosFunktionArpominen(ArrayList<String> funktioJaVast, String funktio) {
        double kerroin = arvoKerroin();
        double sisafunktionKerroin = arvoKerroin();
        SinCos sincos = new SinCos(kerroin, sisafunktionKerroin, funktio);
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
