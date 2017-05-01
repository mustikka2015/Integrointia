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
 * Tämän luokan avulla kuunnellaan "Show the function"-näppäintä SinGUI- ja
 * CosGUI-näkymissä.
 *
 * @author Iisa
 */
public class SinCosShowTheFunctionKuuntelija implements ActionListener {

    private JTextField funktiokentta;
    private JTextField kerroin;
    private JTextField sisafunktionKerroin;
    private SinCos sincos;

    /**
     * Konstrunktori SinCosShowTheFunctionKuuntelijalle.
     *
     * @param funktiokentta JTextField
     * @param kerroin JTextField
     * @param sisafunktionKerroin JTextField
     * @param sincos SinCos
     */
    public SinCosShowTheFunctionKuuntelija(JTextField funktiokentta, JTextField kerroin, JTextField sisafunktionKerroin, SinCos sincos) {
        this.funktiokentta = funktiokentta;
        this.kerroin = kerroin;
        this.sisafunktionKerroin = sisafunktionKerroin;
        this.sincos = sincos;
    }

    /**
     * Funktion kerroin ja sisäfunktion kerroin kuunnellaan tekstikentistä,
     * joihin ne on syötetty, ja funktiokenttään syötetään funktio
     * String-muodossa.
     */
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
            String eka = sincos.toString();
            this.funktiokentta.setText(eka);

        } catch (Exception e) {
            this.funktiokentta.setText("Coefficients are decimal numbers. (For example 2.7)");
        }

    }

}
