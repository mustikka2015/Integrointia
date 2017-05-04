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
import opetusohjelma.laskutoimituksia.SinCos;

/**
 * Luokka kuuntelee "Draw the Solutions"-painiketta.
 *
 * @author Iisa
 */
public class DrawNapinKuuntelijaSinCos implements ActionListener {

    private JTextField kerroin;
    private JTextField sisafunktionKerroin;
    private JTextField vastaus;
    private SinCos sincos;

    /**
     * Konstrunktori DrawNapinKuuntelijaSinCos-luokalle.
     *
     * @param sincos SinCos
     * @param vastaus JTextField
     * @param kerroin JTextField
     * @param sisafunktionKerroin JTextField
     */
    public DrawNapinKuuntelijaSinCos(SinCos sincos, JTextField vastaus, JTextField kerroin, JTextField sisafunktionKerroin) {
        this.kerroin = kerroin;
        this.sisafunktionKerroin = sisafunktionKerroin;
        this.sincos = sincos;
        this.vastaus = vastaus;
    }

    /**
     * Funktion kerroin ja sisäfunktion kerroin kuunnellaan tekstikentistä,
     * joihin ne on syötetty, ja funktio, sen derivaatta ja integraali
     * piirretään.
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
            SinCos piirrettava = new SinCos(this.sincos.getKerroin(), this.sincos.getSisafunktionKerroin(), this.sincos.getFunktio());
            Piirtokayttoliittyma piirtokayttoliittyma = new Piirtokayttoliittyma(piirrettava);
            SwingUtilities.invokeLater(piirtokayttoliittyma);

        } catch (Exception e) {
            this.vastaus.setText("Coefficients are decimal numbers. (For example 2.7)");
        }

    }

}
