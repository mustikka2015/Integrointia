/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opetusohjelma.kayttoliittyma.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import opetusohjelma.laskutoimituksia.Polynomi;

/**
 *
 * @author Iisa
 */
public class DifferentiateKuuntelijaPolynomille implements ActionListener {

    private JTextField eksponentti;
    private JTextField kerroin;
    private JTextField vastaus;
    private Polynomi polynomi;

    /**
     * Konstrunktori DifferentiateKuuntelijaPolynomille.
     * @param polynomi Polynomi
     * @param vastaus JTextField
     * @param eksponentti JTextField
     * @param kerroin JTextField
     */
    public DifferentiateKuuntelijaPolynomille(Polynomi polynomi, JTextField vastaus, JTextField eksponentti, JTextField kerroin) {
        this.eksponentti = eksponentti;
        this.kerroin = kerroin;
        this.polynomi = polynomi;
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
                Polynomi derivoitava = new Polynomi(this.polynomi.getEksponentti(), this.polynomi.getKerroin());
                derivoitava.derivoi();
                String eka = derivoitava.toString();
                this.vastaus.setText(eka);

            } catch (Exception e) {
                this.vastaus.setText("Coefficient is a decimal number. (For example 3.5)");

            }

        } catch (Exception e) {
            this.vastaus.setText("Exponent is an integer. (For example 2)");
        }

    }

}
