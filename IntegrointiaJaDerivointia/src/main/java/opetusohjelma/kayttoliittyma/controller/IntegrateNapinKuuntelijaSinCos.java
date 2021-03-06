/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opetusohjelma.kayttoliittyma.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import opetusohjelma.laskutoimituksia.SinCos;

/**
 * Tämän avulla kuunnellaan "Intregrate"-näppäintä SinGUI- ja CosGUI-näkymissä.
 *
 * @author Iisa
 */
public class IntegrateNapinKuuntelijaSinCos implements ActionListener {

    private JTextField kerroin;
    private JTextField sisafunktionKerroin;
    private JTextField vastaus;
    private SinCos sincos;

    /**
     * Konstrunktori IntegrateNapinKuuntelijaSinCos-luokalle.
     *
     * @param sincos SinCos
     * @param vastaus JTextField
     * @param kerroin JTextField
     * @param sisafunktionKerroin JTextField
     */
    public IntegrateNapinKuuntelijaSinCos(SinCos sincos, JTextField vastaus, JTextField kerroin, JTextField sisafunktionKerroin) {
        this.kerroin = kerroin;
        this.sisafunktionKerroin = sisafunktionKerroin;
        this.sincos = sincos;
        this.vastaus = vastaus;
    }

    /**
     * Funktion kerroin ja sisäfunktion kerroin kuunnellaan tekstikentistä,
     * joihin ne on syötetty, ja vastauskenttään syötetään integroitu funktio
     * String-muodossa.
     *
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        String ker = kerroin.getText();
        String sisker = sisafunktionKerroin.getText();

        try {
            double kerroin1 = Double.parseDouble(ker);
            this.sincos.setKerroin(kerroin1);
            double sisafunktionKerroin1 = Double.parseDouble(sisker);
            this.sincos.setSisafunktionKerroin(sisafunktionKerroin1);
            SinCos integroitava = new SinCos(this.sincos.getKerroin(), this.sincos.getSisafunktionKerroin(), this.sincos.getFunktio());
            integroitava.integroi();
            this.vastaus.setText(integroitava.toString());

        } catch (Exception e) {
            this.vastaus.setText("Coefficients are decimal numbers. (For example 2.7)");
        }

    }

}
