/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opetusohjelma.kayttoliittyma;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.awt.CardLayout;
import java.util.ArrayList;
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
    private JPanel checkPanel;
    private JPanel controlPanel;
    private JPanel drawPanel;

    public KoneValitseeGUI() {
        prepareGUI();
    }

    /**
     * Pääkehys alustetaan.
     */
    public void prepareGUI() {
        mainFrame = new JFrame("Integration and derivation");
        mainFrame.setSize(400, 400);
        mainFrame.setLayout(new GridLayout(4, 1));

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

        String toiminto = arvoToiminto();
        
        ArrayList<String> funktioJaVastaus = arvoFunktio();
    
        tehtavanantorivinAsetus(toiminto, funktioJaVastaus);
        
        JTextField vastaus = new JTextField();

        showSolutionNapinAsetus(vastaus, funktioJaVastaus, toiminto);
        
        vastausrivinAsetus(vastaus);
        
        piirtonapinAsetus();

    }

    /**
     * Metodi arpoo funktion. Se palauttaa ArrayList-olion, joka sisältää itse
     * funktion String-muodossa, funktion derivoituna String-muodossa sekä
     * funktion integroituna String-muodossa.
     *
     * @return ArrayList<String>, joka sisältää sekä funktion että sen
     * derivaatan ja integraalin.
     */
    public ArrayList<String> arvoFunktio() {
        Arpoja arpoja = new Arpoja();
        ArrayList<String> funktioJaVast = new ArrayList<String>();
        String funktio = arpoja.arvoFunktio();
        if (funktio.equals("sin") || funktio.equals("cos")) {
            SinCos sincos = new SinCos(arpoja.arvoKerroin(), arpoja.arvoKerroin(), funktio);
            funktio = sincos.toString();
            funktioJaVast.add(funktio);
            SinCos derivoitu = new SinCos(sincos.getKerroin(), sincos.getSisafunktionKerroin(), sincos.getFunktio());
            SinCos integroitu = new SinCos(sincos.getKerroin(), sincos.getSisafunktionKerroin(), sincos.getFunktio());
            derivoitu.derivoi();
            integroitu.integroi();
            funktioJaVast.add(derivoitu.toString());
            funktioJaVast.add(integroitu.toString());

        } else {
            Polynomi polynomi = new Polynomi(arpoja.arvoPolynominEksponentti(), arpoja.arvoKerroin());
            funktio = polynomi.toString();
            funktioJaVast.add(funktio);
            Polynomi derivoitu = new Polynomi(polynomi.getEksponentti(), polynomi.getKerroin());
            Polynomi integroitu = new Polynomi(polynomi.getEksponentti(), polynomi.getKerroin());
            derivoitu.derivoi();
            integroitu.integroi();
            funktioJaVast.add(derivoitu.toString());
            funktioJaVast.add(integroitu.toString());

        }

        return funktioJaVast;
    }

    /**
     * Metodi arpoo, integroidaanko vai derivoidaanko funktio.
     *
     * @return String: "Integroi" tai "Derivoi"
     */
    public String arvoToiminto() {
        Arpoja arpoja = new Arpoja();
        String toiminto = arpoja.arvoToiminto();
        return toiminto;
    }

    /**
     * Metodi kertoo tehtävänannon String-muodossa, kun sille on syötetty jo
     * aikaisemmin arvotut toiminto ja funktio.
     *
     * @return String: tehtävänanto
     */
    public String arvoTehtava(String toiminto, String funktio) {

        String tehtava = toiminto;
        tehtava = tehtava + " function y = " + funktio;
        tehtava = tehtava + ". Click to check.";
        return tehtava;
    }

    /**
     * Metodi luo tehtävänantorivin näkymään.
     */
    public void tehtavanantorivinAsetus(String toiminto, ArrayList<String> funktioJaVastaus) {
        headerLabel = new JLabel("", JLabel.CENTER);
        mainFrame.add(headerLabel);
        String funktio = funktioJaVastaus.get(0);
        String tehtava = arvoTehtava(toiminto, funktio);
        headerLabel.setText(tehtava);
    }

    /**
     * Metodi luo "Show the solution" -napin.
     */
    public void showSolutionNapinAsetus(JTextField vastaus, ArrayList<String> funktioJaVastaus, String komento) {
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        mainFrame.add(controlPanel);
        JPanel taskPanel = new JPanel(new FlowLayout());
        JButton vastausnappi = new JButton("Show the solution");
        ValinnanShowSolutionKuuntelija vastauskuulija = new ValinnanShowSolutionKuuntelija(vastaus, funktioJaVastaus, komento);
        vastausnappi.addActionListener(vastauskuulija);
        taskPanel.add(vastausnappi);

        controlPanel.add(taskPanel);
    }
    
    /**
     * Metodi luo vastausrivin.
     */
    public void vastausrivinAsetus(JTextField vastaus) {
        checkPanel = new JPanel();
        GridLayout layout1 = new GridLayout(1, 2);
        checkPanel.setLayout(layout1);
        JLabel teksti = new JLabel("", JLabel.CENTER);
        teksti.setText("Answer is:");
        checkPanel.add(teksti);
        checkPanel.add(vastaus);
        mainFrame.add(checkPanel);
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
