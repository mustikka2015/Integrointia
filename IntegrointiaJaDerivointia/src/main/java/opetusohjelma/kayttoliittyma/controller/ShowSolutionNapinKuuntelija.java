/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opetusohjelma.kayttoliittyma.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTextField;

/**
 * Luokka toteuttaa "Show solution"-näppäimen kuuntelun.
 *
 * @author Iisa
 */
public class ShowSolutionNapinKuuntelija implements ActionListener {

    private JTextField vastaus;
    private ArrayList<String> funktioJaVastaus;
    private String komento;

    /**
     * Konstruktori ShowSolutionNapinKuuntelijalle.
     *
     * @param vastaus JTextField
     * @param funktioJaVastaus ArrayList
     * @param komento String
     */
    public ShowSolutionNapinKuuntelija(JTextField vastaus, ArrayList<String> funktioJaVastaus, String komento) {
        this.vastaus = vastaus;
        this.funktioJaVastaus = funktioJaVastaus;
        this.komento = komento;
    }

    /**
     * Metodi asettaa vastauksen tekstikenttään "vastaus". Mikäli kone on
     * arponut komennon "Differentiate", poimitaan ArrayList:stä
     * funktioJaVastaus arvotun funktion derivoitu muoto. Mikäli kone on arponut
     * komennon "Integrate", poimitaan integroitu muoto.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if (this.komento.equals("Differentiate")) {
            this.vastaus.setText(this.funktioJaVastaus.get(1));
        }
        if (this.komento.equals("Integrate")) {
            this.vastaus.setText(this.funktioJaVastaus.get(2));
        }
    }

    public void setFunktioJaVastaus(ArrayList<String> funktioJaVastaus) {
        this.funktioJaVastaus = funktioJaVastaus;
    }

    public void setToiminto(String toiminto) {
        this.komento = toiminto;
    }

}
