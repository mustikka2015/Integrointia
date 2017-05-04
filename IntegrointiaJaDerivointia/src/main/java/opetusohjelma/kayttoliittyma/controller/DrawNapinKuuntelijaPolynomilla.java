/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opetusohjelma.kayttoliittyma.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import opetusohjelma.kayttoliittyma.view.Piirtokayttoliittyma;
import opetusohjelma.laskutoimituksia.Polynomi;

/**
 * Luokka kuuntelee "Draw the Solutions"-painiketta.
 *
 * @author Iisa
 */
public class DrawNapinKuuntelijaPolynomilla implements ActionListener {

    private Polynomi polynomi;
    private JTextField eksponentti;
    private JTextField kerroin;
    private JTextField vastaus;

    /**
     * Konstruktori DrawNapinKuuntelijaPolynomilla-luokalle.
     *
     * @param polynomi Polynomi
     * @param eksponentti JTextField
     * @param kerroin JTextField
     * @param vastaus JTextField
     */
    public DrawNapinKuuntelijaPolynomilla(Polynomi polynomi, JTextField eksponentti, JTextField kerroin, JTextField vastaus) {
        this.polynomi = polynomi;
        this.eksponentti = eksponentti;
        this.kerroin = kerroin;
        this.vastaus = vastaus;
    }

    /**
     * Funktion eksponentti ja kerroin kuunnellaan tekstikentistä, joihin ne on
     * syötetty, ja funktio, sen derivaatta ja integraali piirretään.
     *
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        String eksp = eksponentti.getText();
        String ker = kerroin.getText();
        try {
            int eksponentti1 = Integer.parseInt(eksp);
            polynomi.setEksponentti(eksponentti1);
            try {
                double kerroin1 = Double.parseDouble(ker);
                polynomi.setKerroin(kerroin1);
                Polynomi piirrettava = new Polynomi(this.polynomi.getEksponentti(), this.polynomi.getKerroin());
                Piirtokayttoliittyma piirtokayttoliittyma = new Piirtokayttoliittyma(piirrettava);
                SwingUtilities.invokeLater(piirtokayttoliittyma);
            } catch (Exception e) {
                this.vastaus.setText("Coefficient is a decimal number. (For example 3.5)");
            }
        } catch (Exception e) {
            this.vastaus.setText("Exponent is an integer. (For example 2)");
        }

    }

}
