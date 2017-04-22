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
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Tämän luokan avulla kuunnellaan "New assignment-näppäintä"
 *
 * @author Iisa
 */
public class ValinnanNewAssignmentKuuntelija implements ActionListener {

    private JLabel headerLabel;
    private ArrayList<String> funktioJaVastaus;
    private ValinnanShowSolutionKuuntelija skuuntelija;

    /**
     * Tämä on konstruktori, jossa asetetaan private-muuttujat headerLabel,
     * funktiojaVastaus ja skuuntelija ympäristöstä, josta
     * ValinnanNewAssignmentKuuntelijaa kutsutaan.
     */
    public ValinnanNewAssignmentKuuntelija(JLabel headerLabel, ArrayList<String> funktioJaVastaus, ValinnanShowSolutionKuuntelija skuuntelija) {
        this.headerLabel = headerLabel;
        this.funktioJaVastaus = funktioJaVastaus;
        this.skuuntelija = skuuntelija;
    }

    /**
     * Tämän metodin avulla kuunnellaan "New assignment"-näppäintä. Kuuntelun
     * tuloksena tietokone arpoo uuden tehtävän, joka asetetaan taas
     * headerLabel:iin. Uuden funktio ja sen vastaukset lisätään
     * ValinnanShowSolutionKuuntelijaan.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        TehtavanArpoja tehtArpoja = new TehtavanArpoja();
        String toiminto = tehtArpoja.arvoToiminto();
        this.funktioJaVastaus = tehtArpoja.arvoFunktio();
        String funktio = funktioJaVastaus.get(0);
        String tehtava = tehtArpoja.arvoTehtava(toiminto, funktio);
        headerLabel.setText(tehtava);

        skuuntelija.setFunktioJaVastaus(funktioJaVastaus);
        skuuntelija.setToiminto(toiminto);
    }

}
