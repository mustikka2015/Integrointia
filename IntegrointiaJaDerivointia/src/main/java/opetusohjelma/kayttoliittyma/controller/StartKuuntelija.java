/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opetusohjelma.kayttoliittyma.controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;
import opetusohjelma.kayttoliittyma.view.KoneValitseeGUI;

/**
 * Tämän luokan avulla kuunnellaan "Select"-näppäintä.
 */
public class StartKuuntelija implements ActionListener {

    public StartKuuntelija() {

    }

    /**
     * Tämän metodin avulla kuunnellaan select-näppäintä. Kuuntelun tuloksena
     * tietokone näyttää uuden käyttöliittymänäkymän, johon tietokone on arponut
     * funktion ja pyytää integroimaan tai derivoimaan funktion.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        KoneValitseeGUI konevalinta = new KoneValitseeGUI();
        SwingUtilities.invokeLater((Runnable) konevalinta);

    }

}
