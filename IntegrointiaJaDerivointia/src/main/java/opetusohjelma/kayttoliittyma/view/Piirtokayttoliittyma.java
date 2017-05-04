/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opetusohjelma.kayttoliittyma.view;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import opetusohjelma.laskutoimituksia.Funktio;

/**
 * Käyttöliittymä toimii käyttöliittymänä piirretyille funktioille.
 *
 * @author Iisa
 */
public class Piirtokayttoliittyma implements Runnable {

    private JFrame frame;
    private PolynominPiirtaja piirtoalusta1;
    private SinCosFunktionPiirtaja piirtoalusta2;
    private Funktio funktio;

    /**
     * Konstruktori Piirtokayttoliittymalle.
     *
     * @param funktio Funktio
     */
    public Piirtokayttoliittyma(Funktio funktio) {
        this.funktio = funktio;
    }

    @Override
    public void run() {

        frame = new JFrame("Green is original, blue differentiated and red integrated if constant C = 0.");
        frame.setPreferredSize(new Dimension(700, 800));
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Container-olioon lisätään funktion mukainen Piirtoalusta-olio.
     *
     * @param container Container
     */
    private void luoKomponentit(Container container) {
        if (this.funktio.getFunktio().equals("polynom")) {
            piirtoalusta1 = new PolynominPiirtaja(this.funktio);
            container.add(piirtoalusta1);
        } else if (this.funktio.getFunktio().equals("sin") || this.funktio.getFunktio().equals("cos")) {
            piirtoalusta2 = new SinCosFunktionPiirtaja(this.funktio);
            container.add(piirtoalusta2);
        }
    }

    public JFrame getFrame() {
        return frame;
    }

}
