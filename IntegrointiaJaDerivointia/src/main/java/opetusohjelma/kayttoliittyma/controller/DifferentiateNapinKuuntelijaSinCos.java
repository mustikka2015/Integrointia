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
 * Luokan avulla kuunnellaan "Differentiate"-näppäintä SinGUI- ja
 * CosGUI-näkymissä.
 *
 * @author Iisa
 */
public class DifferentiateNapinKuuntelijaSinCos implements ActionListener {

    private JTextField kerroin;
    private JTextField sisafunktionKerroin;
    private JTextField vastaus;
    private SinCos sincos;

    /**
     * Konstrunktori DifferentiateNapinKuuntelijaSinCos-luokalle.
     *
     * @param sincos SinCos
     * @param vastaus JTextField
     * @param kerroin JTextField
     * @param sisafunktionKerroin JTextField
     */
    public DifferentiateNapinKuuntelijaSinCos(SinCos sincos, JTextField vastaus, JTextField kerroin, JTextField sisafunktionKerroin) {
        this.sincos = sincos;
        this.vastaus = vastaus;
        this.kerroin = kerroin;
        this.sisafunktionKerroin = sisafunktionKerroin;
    }

    /**
     * Funktion kerroin ja sisäfunktion kerroin kuunnellaan tekstikentistä,
     * joihin ne on syötetty, ja vastauskenttään syötetään derivoitu funktio
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
            SinCos derivoitava = new SinCos(this.sincos.getKerroin(), this.sincos.getSisafunktionKerroin(), this.sincos.getFunktio());
            derivoitava.derivoi();
            this.vastaus.setText(derivoitava.toString());

        } catch (Exception e) {
            this.vastaus.setText("Coefficients are decimal numbers. (For example 2.7)");
        }

    }

}
