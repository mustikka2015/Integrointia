/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opetusohjelma.kayttoliittyma.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;
import opetusohjelma.kayttoliittyma.view.PolynomGUI;

/**
 * Tämän luokan avulla kuunnellaan "Polynom"-näppäintä.
 *
 * @author Iisa
 */
public class PolynomKuuntelija implements ActionListener {
    
    /**
     * Tämän metodin avulla kuunnellaan Polynom-näppäintä. Kuuntelun tuloksena
     * tietokone näyttää uuden käyttöliittymänäkymän, johon opiskelija syöttää 
     * polynomin eksponentin ja kertoimen ja valitsee, integroidaanko vai 
     * derivoidaanko polynomi.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        PolynomGUI polynomGUI = new PolynomGUI();
        SwingUtilities.invokeLater((Runnable) polynomGUI);
    }

}
