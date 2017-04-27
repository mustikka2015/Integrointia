/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opetusohjelma.kayttoliittyma.view;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import opetusohjelma.kayttoliittyma.controller.BackNapinKuuntelija;
import opetusohjelma.kayttoliittyma.controller.ValinnanDifferentiateKuuntelijaPolynomille;
import opetusohjelma.kayttoliittyma.controller.ValinnanIntegrateKuuntelijaPolynomille;
import opetusohjelma.kayttoliittyma.controller.ValinnanPolynomShowTheFunctionKuuntelija;
import opetusohjelma.laskutoimituksia.Polynomi;

/**
 * Tämä luokka toteuttaa näkymän, kun opiskelija valitsee "Polynom".
 *
 * @author Iisa
 */
public class OpiskelijaValitseePolynomGUI implements Runnable {

    private JFrame mainFrame;
    private JTextField funktio;
    private JTextField vastaus1;
    private JTextField vastaus2;
    private JTextField vastaus;
    private JPanel expPanel;
    private JPanel coeffPanel;
    private JPanel showPanel;
    private JPanel textPanel;
    private JPanel functionPanel;
    private JPanel intderPanel;
    private JLabel answerIsLabel;
    private JPanel answerPanel;
    private JPanel drawPanel;
    private Polynomi polynomi;

    public OpiskelijaValitseePolynomGUI() {
        prepareGUI();
    }

    /**
     * Pääkehys alustetaan.
     */
    public void prepareGUI() {
        mainFrame = new JFrame("Integration and differentiation");
        mainFrame.setSize(500, 500);
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
        this.polynomi = new Polynomi(1,1);
        valitseEksponentti();
        valitseKerroin();
        this.funktio = new JTextField();
        funktio.setHorizontalAlignment(JTextField.CENTER);
        funktiorivinAsetus(funktio);
        this.vastaus = new JTextField();
        vastaus.setHorizontalAlignment(JTextField.CENTER);
        lisaaNaytaFunktioNappi();
        answerIsRivinAsetus();
        vastausrivinAsetus(vastaus);
        integrateDerivateButtons();
        piirtoYmsNapinAsetus();

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
        this.vastaus1 = new JTextField("", JLabel.CENTER);
        expPanel.add(teksti);
        expPanel.add(vastaus1);

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

        this.vastaus2 = new JTextField();

        coeffPanel.add(textPanel);
        coeffPanel.add(vastaus2);

        mainFrame.add(coeffPanel);
    }

    /**
     * Metodi luo "Show the function" -napin
     */
    public void lisaaNaytaFunktioNappi() {
        showPanel = new JPanel();
        mainFrame.add(showPanel);
        JButton nappi1 = new JButton("Show the function");
        ValinnanPolynomShowTheFunctionKuuntelija kuulija = new ValinnanPolynomShowTheFunctionKuuntelija(funktio, vastaus1, vastaus2, polynomi);
        nappi1.addActionListener(kuulija);
        showPanel.add(nappi1);
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
     * Metodi luo "Integrate"- ja "Differenriate"-näppäinrivin.
     */
    public void integrateDerivateButtons() {
        intderPanel = new JPanel();
        intderPanel.setLayout(new GridLayout(1, 2));
        JButton integButton = new JButton("Integrate");
        ValinnanIntegrateKuuntelijaPolynomille intKuulija = new ValinnanIntegrateKuuntelijaPolynomille(polynomi, vastaus);
        integButton.addActionListener(intKuulija);
        intderPanel.add(integButton);
        JButton diffButton = new JButton("Differentiate");
        ValinnanDifferentiateKuuntelijaPolynomille diffKuulija = new ValinnanDifferentiateKuuntelijaPolynomille(polynomi, vastaus);
        diffButton.addActionListener(diffKuulija);
        intderPanel.add(integButton);
        intderPanel.add(diffButton);
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
     * Metodi luo "Back"- ja "Draw the solution" -napit
     */
    public void piirtoYmsNapinAsetus() {
        drawPanel = new JPanel();
        mainFrame.add(drawPanel);
        JButton back = new JButton("Back");
        BackNapinKuuntelija kuulija = new BackNapinKuuntelija(mainFrame);
        back.addActionListener(kuulija);
        drawPanel.add(back);
        drawPanel.add(new JButton("Draw the solution"));
    }

}
