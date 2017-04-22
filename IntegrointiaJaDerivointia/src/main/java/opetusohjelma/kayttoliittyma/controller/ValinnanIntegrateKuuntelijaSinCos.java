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

    private JTextField vastaus;
    private SinCos sincos;

    public ValinnanIntegrateKuuntelijaSinCos(SinCos sincos, JTextField vastaus) {
        this.sincos= sincos;
        this.vastaus = vastaus;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SinCos integroitava = new SinCos(this.sincos.getKerroin(), this.sincos.getSisafunktionKerroin(), this.sincos.getFunktio());
        integroitava.integroi();
        this.vastaus.setText(integroitava.toString());

    }
    
}
