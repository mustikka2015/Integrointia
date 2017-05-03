/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opetusohjelma.kayttoliittyma.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.awt.CardLayout;
import java.util.ArrayList;
import opetusohjelma.kayttoliittyma.controller.Arpoja;
import opetusohjelma.kayttoliittyma.controller.BackNapinKuuntelija;
import opetusohjelma.kayttoliittyma.controller.NewAssignmentKuuntelija;
import opetusohjelma.kayttoliittyma.controller.ShowSolutionKuuntelija;
import opetusohjelma.laskutoimituksia.Polynomi;
import opetusohjelma.laskutoimituksia.SinCos;

/**
 * Tämä luokka toteuttaa toiminnallisuuden, kun käyttäjä valitsee, että kone
 * arpoo hänelle tehtävänannon.
 *
 * @author Iisa
 */
public class KoneValitseeGUI implements Runnable {

    private JFrame mainFrame;
    private JLabel headerLabel;
    private ArrayList<String> funktioJaVastaus;
    private ShowSolutionKuuntelija vastauskuulija;

    /**
     * Konstruktori KoneValitseeGUI:lle.
     */
    public KoneValitseeGUI() {
        prepareGUI();
    }

    /**
     * Pääkehys alustetaan.
     */
    public void prepareGUI() {
        mainFrame = new JFrame("Integration and differentiation");
        mainFrame.setSize(500, 500);
        mainFrame.setLayout(new GridLayout(5, 1));

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        mainFrame.setVisible(true);
    }

    /**
     * Luodaan näkymän napit ja tekstikentät ja lisätään ne pääkehykseen.
     */
    @Override
    public void run() {

        Arpoja arpoja = new Arpoja();

        String toiminto = arpoja.arvoToiminto();

        this.funktioJaVastaus = arpoja.arvoFunktioJaVastaukset(arpoja.arvoFunktio());

        tehtavanantorivinAsetus(toiminto, arpoja);

        JTextField vastaus = new JTextField();

        vastaus.setHorizontalAlignment(JTextField.CENTER);

        showSolutionNapinAsetus(vastaus, toiminto);

        answerIsRivinAsetus();

        vastausrivinAsetus(vastaus);

        piirtoYmsNapinAsetus();

    }

    public ArrayList<String> getFunktioJaVastaus() {
        return this.funktioJaVastaus;
    }

    /**
     * Metodi luo tehtävänantorivin näkymään.
     *
     * @param toiminto String
     * @param arpoja Arpoja
     */
    public void tehtavanantorivinAsetus(String toiminto, Arpoja arpoja) {
        headerLabel = new JLabel("", JLabel.CENTER);
        mainFrame.add(headerLabel);
        String funktio = funktioJaVastaus.get(0);
        String tehtava = arpoja.arvoTehtava(toiminto, funktio);
        headerLabel.setText(tehtava);
    }

    /**
     * Metodi luo "Show the solution" -napin.
     *
     * @param vastaus JTextField
     * @param komento String
     */
    public void showSolutionNapinAsetus(JTextField vastaus, String komento) {
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        mainFrame.add(controlPanel);
        JButton vastausnappi = new JButton("Show the solution");
        this.vastauskuulija = new ShowSolutionKuuntelija(vastaus, funktioJaVastaus, komento);
        vastausnappi.addActionListener(vastauskuulija);
        controlPanel.add(vastausnappi);
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
     * Metodi luo vastausrivin.
     *
     * @param vastaus JTextField
     */
    public void vastausrivinAsetus(JTextField vastaus) {
        JPanel checkPanel = new JPanel();
        GridLayout layout1 = new GridLayout();
        checkPanel.setLayout(layout1);
        checkPanel.add(vastaus);
        mainFrame.add(checkPanel);
    }

    /**
     * Metodi luo "Back" ja "New assignment"-napit.
     */
    public void piirtoYmsNapinAsetus() {
        JPanel drawPanel = new JPanel();
        mainFrame.add(drawPanel);
        JButton back = new JButton("Back");
        BackNapinKuuntelija kuulija = new BackNapinKuuntelija(mainFrame);
        back.addActionListener(kuulija);
        drawPanel.add(back);

//        JButton drawbutton = new JButton();
//        GridLayout layout = new GridLayout(2, 1);
//        drawbutton.setLayout(layout);
//        drawbutton.add(new JLabel("Draw", JLabel.CENTER));
//        drawbutton.add(new JLabel("the solution", JLabel.CENTER));
//        drawPanel.add(drawbutton);
        JButton newbutton = new JButton();
        GridLayout layout = new GridLayout(2, 1);
        newbutton.setLayout(layout);
        newbutton.setBackground(Color.CYAN);
        newbutton.add(new JLabel("New", JLabel.CENTER));
        newbutton.add(new JLabel("assignment", JLabel.CENTER));
        NewAssignmentKuuntelija kuuntelija = new NewAssignmentKuuntelija(this.headerLabel, this.funktioJaVastaus, this.vastauskuulija);
        newbutton.addActionListener(kuuntelija);
        drawPanel.add(newbutton);
    }

}
