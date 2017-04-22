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
public class ValinnanDifferentiateKuuntelijaPolynomille implements ActionListener {

    private JTextField vastaus;
    private Polynomi polynomi;

    public ValinnanDifferentiateKuuntelijaPolynomille(Polynomi polynomi, JTextField vastaus) {
        this.polynomi= polynomi;
        this.vastaus = vastaus;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Polynomi derivoitava = new Polynomi(this.polynomi.getEksponentti(), this.polynomi.getKerroin());
        derivoitava.derivoi();
        this.vastaus.setText(derivoitava.toString());

    }
    
}
