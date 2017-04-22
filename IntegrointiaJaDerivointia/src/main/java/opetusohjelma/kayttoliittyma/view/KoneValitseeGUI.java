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
import opetusohjelma.kayttoliittyma.controller.TehtavanArpoja;
import opetusohjelma.kayttoliittyma.controller.ValinnanNewAssignmentKuuntelija;
import opetusohjelma.kayttoliittyma.controller.ValinnanShowSolutionKuuntelija;
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
    private JLabel answerIsLabel;
    private JPanel checkPanel;
    private JPanel controlPanel;
    private JPanel drawPanel;

    private ArrayList<String> funktioJaVastaus;
    private ValinnanShowSolutionKuuntelija vastauskuulija;

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

        TehtavanArpoja tehtArpoja = new TehtavanArpoja();

        String toiminto = tehtArpoja.arvoToiminto();

        this.funktioJaVastaus = tehtArpoja.arvoFunktio();

        tehtavanantorivinAsetus(toiminto, tehtArpoja);

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
     */
    public void tehtavanantorivinAsetus(String toiminto, TehtavanArpoja tehtArpoja) {
        headerLabel = new JLabel("", JLabel.CENTER);
        mainFrame.add(headerLabel);
        String funktio = funktioJaVastaus.get(0);
        String tehtava = tehtArpoja.arvoTehtava(toiminto, funktio);
        headerLabel.setText(tehtava);
    }

    /**
     * Metodi luo "Show the solution" -napin.
     */
    public void showSolutionNapinAsetus(JTextField vastaus, String komento) {
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        mainFrame.add(controlPanel);
        JPanel taskPanel = new JPanel(new FlowLayout());
        JButton vastausnappi = new JButton("Show the solution");
        this.vastauskuulija = new ValinnanShowSolutionKuuntelija(vastaus, funktioJaVastaus, komento);
        vastausnappi.addActionListener(vastauskuulija);
        taskPanel.add(vastausnappi);

        controlPanel.add(taskPanel);
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
     * Metodi luo vastausrivin.
     */
    public void vastausrivinAsetus(JTextField vastaus) {
        checkPanel = new JPanel();
        GridLayout layout1 = new GridLayout();
        checkPanel.setLayout(layout1);
        checkPanel.add(vastaus);
        mainFrame.add(checkPanel);
    }

    /**
     * Metodi luo "Back", "Draw the solution" ja "New assignment"-napit.
     */
    public void piirtoYmsNapinAsetus() {
        drawPanel = new JPanel(new GridLayout(1, 3));
        mainFrame.add(drawPanel);
        drawPanel.add(new JButton("Back"));

        JButton drawbutton = new JButton();
        GridLayout layout = new GridLayout(2, 1);
        drawbutton.setLayout(layout);
        drawbutton.add(new JLabel("Draw", JLabel.CENTER));
        drawbutton.add(new JLabel("the solution", JLabel.CENTER));
        drawPanel.add(drawbutton);

        JButton newbutton = new JButton();
        newbutton.setLayout(layout);
        newbutton.add(new JLabel("New", JLabel.CENTER));
        newbutton.add(new JLabel("assignment", JLabel.CENTER));
        ValinnanNewAssignmentKuuntelija kuuntelija = new ValinnanNewAssignmentKuuntelija(this.headerLabel, this.funktioJaVastaus, this.vastauskuulija);
        newbutton.addActionListener(kuuntelija);
        drawPanel.add(newbutton);
    }

}
