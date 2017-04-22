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
import opetusohjelma.kayttoliittyma.controller.ValinnanChangeKuuntelija;
import opetusohjelma.kayttoliittyma.controller.ValinnanCosKuuntelija;
import opetusohjelma.kayttoliittyma.controller.ValinnanPolynomKuuntelija;
import opetusohjelma.kayttoliittyma.controller.ValinnanSelectKuuntelija;
import opetusohjelma.kayttoliittyma.controller.ValinnanSinKuuntelija;

/**
 * Käyttöliittymän aloitussivusto.
 */
public class AloitusGUI {

    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;

    public AloitusGUI() {
        prepareGUI();
    }

    /**
     * Metodi luo JFrame-olion ja alustaa sen halutunlaiseksi.
     */
    public void prepareGUI() {
        mainFrame = new JFrame("Integration and derivation");
        mainFrame.setSize(400, 500);
        mainFrame.setLayout(new GridLayout(3, 1));

        headerLabel = new JLabel("", JLabel.CENTER);
        statusLabel = new JLabel("", JLabel.CENTER);
        statusLabel.setSize(350, 100);

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }

    /**
     * Metodi luo CardLayout-näkymän ja sen paneelit painikkeineen. Tämän
     * refaktorointi on vielä kesken.
     */
    public void showCardLayout() {
        headerLabel.setText("Choose a function or draw lots to decide it");

        JPanel panel = new JPanel();

        panel.setSize(300, 300);

        CardLayout layout = new CardLayout();
        layout.setHgap(10);
        layout.setVgap(10);
        panel.setLayout(layout);

        JPanel buttonPanel = new JPanel(new FlowLayout());

        lisaaNappi(buttonPanel, new JButton("Polynom"), new ValinnanPolynomKuuntelija());

        lisaaNappi(buttonPanel, new JButton("Sine"), new ValinnanSinKuuntelija());

        lisaaNappi(buttonPanel, new JButton("Cosine"), new ValinnanCosKuuntelija());

        JPanel selectPanel = new JPanel(new FlowLayout());

        lisaaNappi(selectPanel, new JButton("Select"), new ValinnanSelectKuuntelija());

        panel.add("You choose", buttonPanel);
        panel.add("Computer chooses", selectPanel);
        DefaultComboBoxModel panelName = new DefaultComboBoxModel();

        panelName.addElement("You choose");
        panelName.addElement("Computer chooses");
        JComboBox listCombo = new JComboBox(panelName);

        listCombo.setSelectedIndex(0);

        JScrollPane listComboScrollPane = new JScrollPane(listCombo);

        controlPanel.add(listComboScrollPane);

        lisaaNappi(controlPanel, new JButton("Change"), new ValinnanChangeKuuntelija(listCombo, panel, statusLabel));

        controlPanel.add(panel);

        mainFrame.setVisible(true);
    }

    /**
     * Metodi lisää painikkeen lisäten siihen tapahtumankuuntelijan..
     */
    public void lisaaNappi(JPanel panel, JButton button, ActionListener listener) {

        button.addActionListener(listener);
        panel.add(button);

    }

}
