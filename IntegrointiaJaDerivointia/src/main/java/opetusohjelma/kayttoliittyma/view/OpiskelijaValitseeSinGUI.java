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
 * Tämä luokka toteuttaa näkymän, kun opiskelija valitsee "Sine".
 *
 * @author Iisa
 */
public class OpiskelijaValitseeSinGUI implements Runnable {

    private JFrame mainFrame;
    private JPanel coeffPanel;
    private JPanel incePanel;
    private JPanel textPanel;
    private JPanel showPanel;
    private JPanel functionPanel;
    private JPanel intderPanel;
    private JPanel answerPanel;
    private JLabel answerIsLabel;
    private JPanel drawPanel;

    public OpiskelijaValitseeSinGUI() {
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

        valitseKerroin();
        valitseSisafunktionKerroin();
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
     * Metodi luo "Valitse funktion kerroin" -rivin
     */
    public void valitseKerroin() {
        coeffPanel = new JPanel();
        textPanel = new JPanel();
        BoxLayout layout = new BoxLayout(textPanel, BoxLayout.Y_AXIS);

        textPanel.add(new JLabel("Choose the coefficient of Sin"));
        textPanel.add(new JLabel("(decimal number):"));

        coeffPanel.setLayout(new GridLayout(1, 2));

        JTextField vastaus = new JTextField();

        coeffPanel.add(textPanel);
        coeffPanel.add(vastaus);

        mainFrame.add(coeffPanel);
    }

    /**
     * Metodi luo "Valitse sisäfunktion kerroin" -rivin
     */
    public void valitseSisafunktionKerroin() {
        incePanel = new JPanel();
        textPanel = new JPanel();
        BoxLayout layout = new BoxLayout(textPanel, BoxLayout.Y_AXIS);

        textPanel.add(new JLabel("Choose the coefficient of x"));
        textPanel.add(new JLabel("(decimal number):"));

        incePanel.setLayout(new GridLayout(1, 2));

        JTextField vastaus = new JTextField();

        incePanel.add(textPanel);
        incePanel.add(vastaus);

        mainFrame.add(incePanel);
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
