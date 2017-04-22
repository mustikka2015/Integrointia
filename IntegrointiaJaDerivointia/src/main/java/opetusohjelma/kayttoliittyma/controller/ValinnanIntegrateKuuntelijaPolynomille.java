/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opetusohjelma.kayttoliittyma.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTextField;
import opetusohjelma.laskutoimituksia.Funktio;
import opetusohjelma.laskutoimituksia.Polynomi;

/**
 * Tämän avulla kuunnellaan "Integrate"-nappia.
 *
 * @author Iisa
 */
public class ValinnanIntegrateKuuntelijaPolynomille implements ActionListener {

    private JTextField vastaus;
    private Polynomi polynomi;

    public ValinnanIntegrateKuuntelijaPolynomille(Polynomi polynomi, JTextField vastaus) {
        this.polynomi= polynomi;
        this.vastaus = vastaus;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Polynomi integroitava = new Polynomi(this.polynomi.getEksponentti(), this.polynomi.getKerroin());
        integroitava.integroi();
        this.vastaus.setText(integroitava.toString());

    }

}
