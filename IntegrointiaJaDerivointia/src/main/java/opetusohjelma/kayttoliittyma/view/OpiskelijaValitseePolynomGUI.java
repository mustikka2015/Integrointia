/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opetusohjelma.kayttoliittyma.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Tämä luokka toteuttaa näkymän, kun opiskelija valitsee "Polynom".
 *
 * @author Iisa
 */
public class OpiskelijaValitseePolynomGUI implements Runnable {

    private JFrame mainFrame;
    private JPanel expPanel;
    private JPanel coeffPanel;
    private JPanel showPanel;
    private JPanel textPanel;
    private JPanel functionPanel;
    private JPanel intderPanel;
    private JLabel answerIsLabel;
    private JPanel answerPanel;
    private JPanel drawPanel;

    public OpiskelijaValitseePolynomGUI() {
        prepareGUI();
    }

    /**
     * Pääkehys alustetaan.
     */
    public void prepareGUI() {
        mainFrame = new JFrame("Integration and derivation");
        mainFrame.setSize(400, 400);
        mainFrame.setLayout(new GridLayout(8, 1));

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
        valitseKerroin();
        lisaaNaytaFunktioNappi();
        JTextField funktio = new JTextField();
        funktiorivinAsetus(funktio);
        integrateDerivateButtons();
        answerIsRivinAsetus();
        JTextField vastaus = new JTextField();
        vastausrivinAsetus(vastaus);
        piirtonapinAsetus();

        mainFrame.setVisible(true);
    }

    /**
     * Metodi luo "Valitse eksponentti" -rivin
     */
    public void valitseEksponentti() {
        expPanel = new JPanel();
        GridLayout layout1 = new GridLayout(1, 2);
        expPanel.setLayout(layout1);
        JLabel teksti = new JLabel("", JLabel.CENTER);
        teksti.setText("Choose the exponent (integer):");
        JTextField vastaus = new JTextField("", JLabel.CENTER);
        expPanel.add(teksti);
        expPanel.add(vastaus);

        mainFrame.add(expPanel);
    }

    /**
     * Metodi luo "Valitse kerroin" -rivin
     */
    public void valitseKerroin() {
        coeffPanel = new JPanel();
        textPanel = new JPanel();
        BoxLayout layout = new BoxLayout(textPanel, BoxLayout.Y_AXIS);

        textPanel.add(new JLabel("Choose the coefficient"));
        textPanel.add(new JLabel("(decimal number):"));

        coeffPanel.setLayout(new GridLayout(1, 2));

        JTextField vastaus = new JTextField();

        coeffPanel.add(textPanel);
        coeffPanel.add(vastaus);

        mainFrame.add(coeffPanel);
    }

    /**
     * Metodi luo "Show the function" -napin
     */
    public void lisaaNaytaFunktioNappi() {
        showPanel = new JPanel();
        mainFrame.add(showPanel);
        showPanel.add(new JButton("Show the function"));
    }

    /**
     * Metodi luo tekstikentän, jossa funktio näytetään.
     */
    public void funktiorivinAsetus(JTextField funktio) {
        functionPanel = new JPanel();
        functionPanel.setLayout(new GridLayout());
        functionPanel.add(funktio);
        mainFrame.add(functionPanel);
    }

    /**
     * Metodi luo "Integrate"- ja "Derivate"-näppäinrivin.
     */
    public void integrateDerivateButtons() {
        intderPanel = new JPanel();
        intderPanel.setLayout(new GridLayout(1, 2));
        intderPanel.add(new JButton("Integrate"));
        intderPanel.add(new JButton("Derivate"));
        mainFrame.add(intderPanel);
    }

    /**
     * Metodi luo vastausrivin.
     */
    public void answerIsRivinAsetus() {
        answerIsLabel = new JLabel("", JLabel.CENTER);
        mainFrame.add(answerIsLabel);
        answerIsLabel.setText("Answer is:");
    }

    /**
     * Metodi luo tekstikentän, jossa funktio näytetään.
     */
    public void vastausrivinAsetus(JTextField vastaus) {
        answerPanel = new JPanel();
        answerPanel.setLayout(new GridLayout());
        answerPanel.add(vastaus);
        mainFrame.add(answerPanel);
    }

    /**
     * Metodi luo "Draw the solution" -napin.
     */
    public void piirtonapinAsetus() {
        drawPanel = new JPanel();
        mainFrame.add(drawPanel);
        drawPanel.add(new JButton("Draw the solution"));
    }

}
