/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opetusohjelma.kayttoliittyma.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;
import opetusohjelma.kayttoliittyma.view.CosGUI;

/**
 * Luokan avulla kuunnellaan "Cosine"-näppäintä.
 *
 * @author Iisa
 */
public class CosNapinKuuntelija implements ActionListener {

    /**
     * Metodin avulla kuunnellaan Cosine-näppäintä. Kuuntelun tuloksena
     * tietokone näyttää uuden käyttöliittymänäkymän, johon opiskelija syöttää
     * funktion kertoimen ja sen sisäfunktion kertoimen ja valitsee,
     * integroidaanko vai derivoidaanko funktio. Hän voi myös piirtää funktion.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        CosGUI cosGUI = new CosGUI();
        SwingUtilities.invokeLater((Runnable) cosGUI);
    }
}
