/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opetusohjelma.kayttoliittyma.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import opetusohjelma.laskutoimituksia.Funktio;
import opetusohjelma.laskutoimituksia.Polynomi;

/**
 * Tämän luokan avulla kuunnellaan "Show the function"-näppäintä.
 *
 * @author Iisa
 */
public class ValinnanPolynomShowTheFunctionKuuntelija implements ActionListener {

    private JTextField funktiokentta;
    private JTextField eksponentti;
    private JTextField kerroin;
    private Polynomi polynomi;


    public ValinnanPolynomShowTheFunctionKuuntelija(JTextField funktiokentta, JTextField eksponentti, JTextField kerroin, Polynomi polynomi) {
        this.funktiokentta = funktiokentta;
        this.eksponentti = eksponentti;
        this.kerroin = kerroin;
        this.polynomi = polynomi;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String eksp = "";
        eksp = eksponentti.getText();
        String ker = "";
        ker = kerroin.getText();
        int ekspInt = 1;
        double kerDouble = 1.0;

        if (!eksp.isEmpty()) {
            ekspInt = Integer.parseInt(eksp);
        }

        if (!ker.isEmpty()) {
            kerDouble = Double.parseDouble(ker);
        }
        polynomi.setEksponentti(ekspInt);
        polynomi.setKerroin(kerDouble);
        String eka = polynomi.toString();
        this.funktiokentta.setText(eka);

    }

}
