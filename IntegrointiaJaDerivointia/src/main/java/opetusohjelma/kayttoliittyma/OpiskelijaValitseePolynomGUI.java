/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opetusohjelma.kayttoliittyma;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Tämä luokka toteuttaa toiminnallisuuden, kun käyttäjä valitsee, että kone arpoo hänelle tehtävänannon.
 * @author Iisa
 */
public class OpiskelijaValitseePolynomGUI implements Runnable {
    
    private JFrame mainFrame;
    private JPanel ekspPanel;
    
    public OpiskelijaValitseePolynomGUI() {
        prepareGUI();
    }
            
    /**
     * Pääkehys alustetaan.
     */
    public void prepareGUI() {
        mainFrame = new JFrame("Integration and derivation");
        mainFrame.setSize(400, 400);
        mainFrame.setLayout(new GridLayout(7, 1));

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        mainFrame.setVisible(true);
    }

    @Override
    public void run() {
        valitseEksponentti();
        
        
        
        mainFrame.setVisible(true);
    }
    
    public void valitseEksponentti() {
        ekspPanel = new JPanel();
        GridLayout layout1 = new GridLayout(1, 2);
        ekspPanel.setLayout(layout1);
        JLabel teksti = new JLabel("", JLabel.CENTER);
        teksti.setText("Valitse eksponentti:");
        JTextField vastaus = new JTextField();
        ekspPanel.add(teksti);
        ekspPanel.add(vastaus);
        
        mainFrame.add(ekspPanel);
    }
    
}
