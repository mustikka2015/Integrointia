/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opetusohjelma.kayttoliittyma.controller;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import opetusohjelma.kayttoliittyma.view.PiirtoalustaPolynomille;
import opetusohjelma.kayttoliittyma.view.Piirtokayttoliittyma;
import opetusohjelma.laskutoimituksia.Funktio;
import opetusohjelma.laskutoimituksia.Polynomi;

/**
 * Luokka kuuntelee "Draw the Solutions"-painiketta.
 *
 * @author Iisa
 */
public class DrawKuuntelijaPolynomille implements ActionListener {

    private Polynomi polynomi;
    private JTextField eksponentti;
    private JTextField kerroin;
    private JTextField vastaus;

    /**
     * Konstruktori DrawKuuntelijalle.
     *
     * @param funktio Funktio
     * @param eksponentti JTextField
     * @param kerroin JTextField
     */
    public DrawKuuntelijaPolynomille(Polynomi polynomi, JTextField eksponentti, JTextField kerroin, JTextField vastaus) {
        this.polynomi = polynomi;
        this.eksponentti = eksponentti;
        this.kerroin = kerroin;
        this.vastaus = vastaus;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String eksp = "";
        eksp = eksponentti.getText();
        String ker = "";
        ker = kerroin.getText();
        int ekspInt = 1;
        double kerDouble = 1.0;
        try {
            ekspInt = Integer.parseInt(eksp);
            polynomi.setEksponentti(ekspInt);
            try {
                kerDouble = Double.parseDouble(ker);
                polynomi.setKerroin(kerDouble);
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
