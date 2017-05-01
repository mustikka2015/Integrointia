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
import opetusohjelma.laskutoimituksia.Polynomi;

/**
 *
 * @author Iisa
 */
public class Piirtokayttoliittyma implements Runnable {

    
    
    private JFrame frame;
    private PiirtoalustaPolynomille piirtoalusta1;
    private PiirtoalustaSinCos piirtoalusta2;
    private Funktio funktio;
    
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
 
    private void luoKomponentit(Container container) {
        if (this.funktio.getFunktio().equals("polynom")) {
            piirtoalusta1 = new PiirtoalustaPolynomille(this.funktio);
            container.add(piirtoalusta1);
        } else if (this.funktio.getFunktio().equals("sin") || this.funktio.getFunktio().equals("cos")) {
            piirtoalusta2 = new PiirtoalustaSinCos(this.funktio);
            container.add(piirtoalusta2);
        }
    }
 
    public JFrame getFrame() {
        return frame;
    }

    
}
