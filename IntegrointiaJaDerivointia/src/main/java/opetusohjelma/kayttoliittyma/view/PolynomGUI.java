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
import opetusohjelma.kayttoliittyma.controller.DifferentiateKuuntelijaPolynomille;
import opetusohjelma.kayttoliittyma.controller.DrawKuuntelijaPolynomille;
import opetusohjelma.kayttoliittyma.controller.IntegrateKuuntelijaPolynomille;
import opetusohjelma.kayttoliittyma.controller.PolynomShowTheFunctionKuuntelija;
import opetusohjelma.laskutoimituksia.Polynomi;

/**
 * Tämä luokka toteuttaa näkymän, kun opiskelija valitsee "Polynom".
 *
 * @author Iisa
 */
public class PolynomGUI implements Runnable {
    
    private JFrame mainFrame;
    private JTextField funktio;
    private JTextField vastaus1;
    private JTextField vastaus2;
    private JTextField vastaus;
    private Polynomi polynomi;

    /**
     * Konstruktori PolynomGUI:lle.
     */
    public PolynomGUI() {
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
        this.polynomi = new Polynomi(1, 1);
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
     * Metodi luo "Valitse eksponentti" -rivin.
     */
    public void valitseEksponentti() {
        JPanel expPanel = new JPanel();
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
     * Metodi luo "Valitse kerroin" -rivin.
     */
    public void valitseKerroin() {
        JPanel coeffPanel = new JPanel();
        JPanel textPanel = new JPanel();
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
     * Metodi luo "Show the function" -napin.
     */
    public void lisaaNaytaFunktioNappi() {
        JPanel showPanel = new JPanel();
        mainFrame.add(showPanel);
        JButton nappi1 = new JButton("Show the function");
        PolynomShowTheFunctionKuuntelija kuulija = new PolynomShowTheFunctionKuuntelija(funktio, vastaus1, vastaus2, polynomi);
        nappi1.addActionListener(kuulija);
        showPanel.add(nappi1);
    }

    /**
     * Metodi luo tekstikentän, jossa funktio näytetään.
     *
     * @param funktio JTextField
     */
    public void funktiorivinAsetus(JTextField funktio) {
        JPanel functionPanel = new JPanel();
        functionPanel.setLayout(new GridLayout());
        functionPanel.add(funktio);
        mainFrame.add(functionPanel);
    }

    /**
     * Metodi luo "Integrate"- ja "Differenriate"-näppäinrivin.
     */
    public void integrateDerivateButtons() {
        JPanel intderPanel = new JPanel();
        JButton integButton = new JButton("Integrate");
        integButton.setBackground(Color.cyan);
        IntegrateKuuntelijaPolynomille intKuulija = new IntegrateKuuntelijaPolynomille(polynomi, vastaus, vastaus1, vastaus2);
        integButton.addActionListener(intKuulija);
        intderPanel.add(integButton);
        JButton diffButton = new JButton("Differentiate");
        diffButton.setBackground(Color.cyan);
        DifferentiateKuuntelijaPolynomille diffKuulija = new DifferentiateKuuntelijaPolynomille(polynomi, vastaus, vastaus1, vastaus2);
        diffButton.addActionListener(diffKuulija);
        intderPanel.add(integButton);
        intderPanel.add(diffButton);
        mainFrame.add(intderPanel);
    }

    /**
     * Metodi luo vastausrivin.
     */
    public void answerIsRivinAsetus() {
        JLabel answerIsLabel = new JLabel("", JLabel.CENTER);
        mainFrame.add(answerIsLabel);
        answerIsLabel.setText("Answer is:");
    }

    /**
     * Metodi luo tekstikentän, jossa funktio näytetään.
     *
     * @param vastaus JTextField
     */
    public void vastausrivinAsetus(JTextField vastaus) {
        JPanel answerPanel = new JPanel();
        answerPanel.setLayout(new GridLayout());
        answerPanel.add(vastaus);
        mainFrame.add(answerPanel);
    }

    /**
     * Metodi luo "Back"- ja "Draw the solution" -napit.
     */
    public void piirtoYmsNapinAsetus() {
        JPanel drawPanel = new JPanel();
        mainFrame.add(drawPanel);
        JButton back = new JButton("Back");
        BackNapinKuuntelija kuulija = new BackNapinKuuntelija(mainFrame);
        back.addActionListener(kuulija);
        drawPanel.add(back);
        JButton draw = new JButton("Draw the solution");
        DrawKuuntelijaPolynomille dkuulija = new DrawKuuntelijaPolynomille(this.polynomi, this.vastaus1, this.vastaus2, this.vastaus);
        draw.addActionListener(dkuulija);
        drawPanel.add(draw);
    }
}
