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
 * Luokan avulla kuunnellaan "Integrate"-nappia PolynomGUI-näkymässä.
 *
 * @author Iisa
 */
public class IntegrateNapinKuuntelijaPolynomilla implements ActionListener {

    private JTextField eksponentti;
    private JTextField kerroin;
    private JTextField vastaus;
    private Polynomi polynomi;

    /**
     * Konstrunktori IntegrateNapinKuuntelijaPolynomille.
     *
     * @param polynomi Polynomi
     * @param vastaus JTextField
     * @param eksponentti JTextField
     * @param kerroin JTextField
     */
    public IntegrateNapinKuuntelijaPolynomilla(Polynomi polynomi, JTextField vastaus, JTextField eksponentti, JTextField kerroin) {
        this.eksponentti = eksponentti;
        this.kerroin = kerroin;
        this.polynomi = polynomi;
        this.vastaus = vastaus;
    }

    /**
     * Polynomin kerroin ja eksponentti kuunnellaan tekstikentistä, joihin ne on
     * syötetty, ja vastauskenttään syötetään integroitu polynomi
     * String-muodossa.
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
                Polynomi integroitava = new Polynomi(this.polynomi.getEksponentti(), this.polynomi.getKerroin());
                integroitava.integroi();
                String eka = integroitava.toString();
                this.vastaus.setText(eka);

            } catch (Exception e) {
                this.vastaus.setText("Coefficient is a decimal number. (For example 3.5)");

            }

        } catch (Exception e) {
            this.vastaus.setText("Exponent is an integer. (For example 2)");
        }

    }

}
