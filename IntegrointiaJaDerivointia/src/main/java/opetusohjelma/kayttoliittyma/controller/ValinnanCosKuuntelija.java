/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opetusohjelma.kayttoliittyma.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;
import opetusohjelma.kayttoliittyma.view.OpiskelijaValitseeCosGUI;

/**
 * Tämän luokan avulla kuunnellaan "Cosine"-näppäintä.
 *
 * @author Iisa
 */
public class ValinnanCosKuuntelija implements ActionListener {

    /**
     * Tämän metodin avulla kuunnellaan Cosine-näppäintä. Kuuntelun tuloksena
     * tietokone näyttää uuden käyttöliittymänäkymän, johon opiskelija syöttää
     * funktion kertoimen ja sen sisäfunktion kertoimen ja valitsee,
     * integroidaanko vai derivoidaanko funktio.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        OpiskelijaValitseeCosGUI cosGUI = new OpiskelijaValitseeCosGUI();
        SwingUtilities.invokeLater((Runnable) cosGUI);
    }
}