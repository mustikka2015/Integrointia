/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opetusohjelma.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTextField;

/**
 * Tämä luokka toteuttaa "Show solution"-näppäimen kuuntelun.
 * 
 * @author Iisa
 */
public class ValinnanShowSolutionKuuntelija implements ActionListener {
    
    private JTextField vastaus;
    private ArrayList<String> funktioJaVastaus;
    private String komento;
    
    public ValinnanShowSolutionKuuntelija(JTextField vastaus, ArrayList<String> funktioJaVastaus, String komento) {
        this.vastaus = vastaus;
        this.funktioJaVastaus = funktioJaVastaus;
        this.komento = komento;
    }

    /**
     * Metodi asettaa vastauksen tekstikenttään "vastaus".
     * Mikäli kone on arponut komennon "Derivate",
     * poimitaan ArrayList:stä funktioJaVastaus arvotun funktion derivoitu muoto.
     * Mikäli kone on arponut komennon "Integrate", poimitaan integroitu muoto.
     *
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.komento.equals("Derivate")) {
            this.vastaus.setText(this.funktioJaVastaus.get(1));
        }
        if (this.komento.equals("Integrate")) {
            this.vastaus.setText(this.funktioJaVastaus.get(2));
        }
    }
    
}
