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
 * Tämän luokan avulla kuunnellaan "Show the function"-näppäintä
 * PolynomGUI-näkymässä.
 *
 * @author Iisa
 */
public class ShowTheFunctionNapinKuuntelijaPolynomilla implements ActionListener {

    private JTextField funktiokentta;
    private JTextField eksponentti;
    private JTextField kerroin;
    private Polynomi polynomi;

    /**
     * Konstrunktori ShowTheFunctionNapinKuuntelijaPolynomilla-luokalle.
     *
     * @param funktiokentta JTextField
     * @param eksponentti JTextField
     * @param kerroin JTextField
     * @param polynomi Polynomi
     */
    public ShowTheFunctionNapinKuuntelijaPolynomilla(JTextField funktiokentta, JTextField eksponentti, JTextField kerroin, Polynomi polynomi) {
        this.funktiokentta = funktiokentta;
        this.eksponentti = eksponentti;
        this.kerroin = kerroin;
        this.polynomi = polynomi;
    }

    /**
     * Polynomin kerroin ja eksponentti kuunnellaan tekstikentistä, joihin ne on
     * syötetty, ja funktiokenttään syötetään polynomi String-muodossa.
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
                String eka = polynomi.toString();
                this.funktiokentta.setText(eka);
            } catch (Exception e) {
                this.funktiokentta.setText("Coefficient is a decimal number. (For example 3.5)");
            }

        } catch (Exception e) {
            this.funktiokentta.setText("Exponent is an integer. (For example 2)");

        }

    }

}
