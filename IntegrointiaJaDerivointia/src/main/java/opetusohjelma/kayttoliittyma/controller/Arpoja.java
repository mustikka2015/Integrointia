/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opetusohjelma.kayttoliittyma.controller;

import java.util.ArrayList;
import java.util.Random;

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
     * -10.0:stä 10.0:een.
     *
     * @return arvottu kerroin double-muodossa.
     */
    public double arvoKerroin() {

        double arvottu = (double) (this.arpoja.nextInt(201) - 100) / 10;

        return arvottu;
    }

    /**
     * Metodi arpoo, integroidaanko vai derivoidaanko funktio.
     *
     * @return String: "Integrate" tai "Derivate".
     */
    public String arvoToiminto() {

        ArrayList<String> vaihtoehdot = new ArrayList<String>();

        vaihtoehdot.add("Integrate");
        vaihtoehdot.add("Derivate");

        int arvottu = this.arpoja.nextInt(vaihtoehdot.size());

        String toiminta = vaihtoehdot.get(arvottu);

        return toiminta;
    }

}
