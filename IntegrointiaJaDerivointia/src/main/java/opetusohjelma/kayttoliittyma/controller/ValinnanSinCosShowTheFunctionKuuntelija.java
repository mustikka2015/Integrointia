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
public class ValinnanSinCosShowTheFunctionKuuntelija implements ActionListener {
private JTextField funktiokentta;
    private JTextField kerroin;
    private JTextField sisafunktionKerroin;
    private SinCos sincos;


    public ValinnanSinCosShowTheFunctionKuuntelija(JTextField funktiokentta, JTextField kerroin, JTextField sisafunktionKerroin, SinCos sincos) {
        this.funktiokentta = funktiokentta;
        this.kerroin = kerroin;
        this.sisafunktionKerroin = sisafunktionKerroin;
        this.sincos = sincos;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String ker ="";
        ker = kerroin.getText();
        String sisker ="";
        sisker = sisafunktionKerroin.getText();
        
        double kerDouble = 1.0;
        double kerDoubleSisa = 1.0;

        if (!ker.isEmpty()) {
            kerDouble = Double.parseDouble(ker);
        }

        if (!sisker.isEmpty()) {
            kerDoubleSisa = Double.parseDouble(sisker);
        }
        this.sincos.setKerroin(kerDouble);
        this.sincos.setSisafunktionKerroin(kerDoubleSisa);
        String eka = sincos.toString();
        this.funktiokentta.setText(eka);

    }

    
}
