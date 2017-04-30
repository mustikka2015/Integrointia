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
 *
 * @author Iisa
 */
public class ValinnanIntegrateKuuntelijaSinCos implements ActionListener {

    private JTextField kerroin;
    private JTextField sisafunktionKerroin;
    private JTextField vastaus;
    private SinCos sincos;

    public ValinnanIntegrateKuuntelijaSinCos(SinCos sincos, JTextField vastaus, JTextField kerroin, JTextField sisafunktionKerroin) {
        this.kerroin = kerroin;
        this.sisafunktionKerroin = sisafunktionKerroin;
        this.sincos = sincos;
        this.vastaus = vastaus;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String ker = "";
        ker = kerroin.getText();
        String sisker = "";
        sisker = sisafunktionKerroin.getText();

        double kerDouble = 1.0;
        double kerDoubleSisa = 1.0;

        try {
            kerDouble = Double.parseDouble(ker);
            this.sincos.setKerroin(kerDouble);
            kerDoubleSisa = Double.parseDouble(sisker);
            this.sincos.setSisafunktionKerroin(kerDoubleSisa);
            SinCos integroitava = new SinCos(this.sincos.getKerroin(), this.sincos.getSisafunktionKerroin(), this.sincos.getFunktio());
            integroitava.integroi();
            this.vastaus.setText(integroitava.toString());

        } catch (Exception e) {
            this.vastaus.setText("Coefficients are decimal numbers. (For example 2.7)");
        }

    }

}