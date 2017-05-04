/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opetusohjelma.kayttoliittyma.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;
import opetusohjelma.kayttoliittyma.view.KoneValitseeGUI;

/**
 * Tämän luokan avulla kuunnellaan "Start!"-näppäintä.
 */
public class StartNapinKuuntelija implements ActionListener {

    /**
     * Konstruktori StartNapinKuuntelijalle.
     */
    public StartNapinKuuntelija() {

    }

    /**
     * Tämän metodin avulla kuunnellaan Start!-näppäintä. Kuuntelun tuloksena
     * tietokone näyttää uuden käyttöliittymänäkymän, johon tietokone on arponut
     * funktion ja pyytää integroimaan tai derivoimaan funktion. Näkymässä voi
     * arpoa uusia tehtävänantoja.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        KoneValitseeGUI konevalinta = new KoneValitseeGUI();
        SwingUtilities.invokeLater((Runnable) konevalinta);

    }

}
