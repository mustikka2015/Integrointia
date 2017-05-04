/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opetusohjelma.kayttoliittyma.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JLabel;

/**
 * Tämän luokan avulla kuunnellaan "New assignment-näppäintä".
 *
 * @author Iisa
 */
public class NewAssignmentNapinKuuntelija implements ActionListener {

    private JLabel tehtavakentta;
    private ArrayList<String> funktioJaVastaus;
    private ShowSolutionNapinKuuntelija skuuntelija;

    /**
     * Tämä on konstruktori, jossa asetetaan private-muuttujat headerLabel,
     * funktiojaVastaus ja skuuntelija ympäristöstä, josta
     * ValinnanNewAssignmentKuuntelijaa kutsutaan.
     *
     * @param tehtavakentta JLabel
     * @param funktioJaVastaus ArrayList
     * @param skuuntelija ShowSolutionKuuntelija
     */
    public NewAssignmentNapinKuuntelija(JLabel tehtavakentta, ArrayList<String> funktioJaVastaus, ShowSolutionNapinKuuntelija skuuntelija) {
        this.tehtavakentta = tehtavakentta;
        this.funktioJaVastaus = funktioJaVastaus;
        this.skuuntelija = skuuntelija;
    }

    /**
     * Tämän metodin avulla kuunnellaan "New assignment"-näppäintä. Kuuntelun
     * tuloksena tietokone arpoo uuden tehtävän, joka asetetaan taas
     * headerLabel:iin. Uuden funktio ja sen vastaukset lisätään
     * ValinnanShowSolutionKuuntelijaan.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Arpoja arpoja = new Arpoja();
        String toiminto = arpoja.arvoToiminta();
        this.funktioJaVastaus = arpoja.arvoFunktioJaVastaukset(arpoja.arvoFunktio());
        String funktio = funktioJaVastaus.get(0);
        String tehtava = arpoja.tulostaTehtava(toiminto, funktio);
        tehtavakentta.setText(tehtava);

        skuuntelija.setFunktioJaVastaus(funktioJaVastaus);
        skuuntelija.setToiminto(toiminto);
    }

}
