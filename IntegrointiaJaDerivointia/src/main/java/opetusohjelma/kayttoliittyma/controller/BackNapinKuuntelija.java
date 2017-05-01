/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opetusohjelma.kayttoliittyma.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.event.WindowEvent.WINDOW_CLOSING;
import javax.swing.JFrame;

/**
 * Tämän avulla kuunnellaan Back-näppäintä.
 *
 * @author Iisa
 */
public class BackNapinKuuntelija implements ActionListener {

    private JFrame mainFrame;

    /**
     * Konstrunktori BackNapinKuuntelijalle.
     *
     * @param mainFrame JFrame
     */
    public BackNapinKuuntelija(JFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    /**
     * Painamalla Back-näppäintä kyseessä oleva ikkuna suljetaan.
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        this.mainFrame.dispose();
    }

}
