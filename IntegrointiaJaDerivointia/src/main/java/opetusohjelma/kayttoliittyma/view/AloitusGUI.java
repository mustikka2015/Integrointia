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
import opetusohjelma.kayttoliittyma.controller.ChangeNapinKuuntelija;
import opetusohjelma.kayttoliittyma.controller.CosNapinKuuntelija;
import opetusohjelma.kayttoliittyma.controller.PolynomNapinKuuntelija;
import opetusohjelma.kayttoliittyma.controller.StartNapinKuuntelija;
import opetusohjelma.kayttoliittyma.controller.SinNapinKuuntelija;

/**
 * Käyttöliittymän aloitussivusto.
 */
public class AloitusGUI {

    private JFrame mainFrame;
    private JLabel ohjerivi;
    private JLabel statusLabel;
    private JPanel valintarivi;

    /**
     * Konstruktori AloitusGUI:lle.
     */
    public AloitusGUI() {
        prepareGUI();
    }

    /**
     * Metodi luo JFrame-olion ja alustaa sen halutunlaiseksi.
     */
    public void prepareGUI() {
        mainFrame = new JFrame("Integration and differentiation");
        mainFrame.setSize(400, 500);
        mainFrame.setLayout(new GridLayout(3, 1));

        ohjerivi = new JLabel("", JLabel.CENTER);
        statusLabel = new JLabel("", JLabel.CENTER);
        statusLabel.setSize(350, 100);

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        valintarivi = new JPanel();
        valintarivi.setLayout(new FlowLayout());

        mainFrame.add(ohjerivi);
        mainFrame.add(valintarivi);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }

    /**
     * Metodi kaksi vaihdeltavaa näkymää painikkeineen. 
     */
    public void showCardLayout() {
        ohjerivi.setText("Choose a function or draw lots to decide it");

        JPanel pohja = new JPanel();

        pohja.setSize(300, 300);

        CardLayout layout = new CardLayout();
        layout.setHgap(10);
        layout.setVgap(10);
        pohja.setLayout(layout);

        JPanel omaValinta = new JPanel(new FlowLayout());

        lisaaNappi(omaValinta, new JButton("Polynom"), new PolynomNapinKuuntelija());

        lisaaNappi(omaValinta, new JButton("Sine"), new SinNapinKuuntelija());

        lisaaNappi(omaValinta, new JButton("Cosine"), new CosNapinKuuntelija());

        JPanel koneenArvonta = new JPanel(new FlowLayout());

        JButton aloita = new JButton("Start!");
        aloita.setBackground(Color.GREEN);

        lisaaNappi(koneenArvonta, aloita, new StartNapinKuuntelija());

        pohja.add("You choose", omaValinta);
        pohja.add("Computer chooses", koneenArvonta);
        DefaultComboBoxModel panelName = new DefaultComboBoxModel();

        panelName.addElement("You choose");
        panelName.addElement("Computer chooses");
        JComboBox lista = new JComboBox(panelName);

        lista.setSelectedIndex(0);

        JScrollPane listComboScrollPane = new JScrollPane(lista);

        valintarivi.add(listComboScrollPane);

        JButton vaihda = new JButton("Change");

        lisaaNappi(valintarivi, vaihda, new ChangeNapinKuuntelija(lista, pohja, statusLabel));

        valintarivi.add(pohja);

        mainFrame.setVisible(true);
    }

    /**
     * Metodi lisää painikkeen lisäten siihen tapahtumankuuntelijan.
     *
     * @param panel JPanel
     * @param button JButton
     * @param listener ActionListener
     */
    public void lisaaNappi(JPanel panel, JButton button, ActionListener listener) {

        button.addActionListener(listener);
        panel.add(button);

    }

}
