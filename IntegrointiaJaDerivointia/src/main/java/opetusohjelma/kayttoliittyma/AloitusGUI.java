package opetusohjelma.kayttoliittyma;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.awt.CardLayout;

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
        mainFrame.setSize(400, 400);
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
     * Metodi luo CardLayout-näkymän ja sen paneelit painikkeineen.
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
        JButton polynom = new JButton("Polynom");
        ValinnanPolynomKuuntelija polynomKuulija = new ValinnanPolynomKuuntelija();
        polynom.addActionListener(polynomKuulija);
        buttonPanel.add(polynom);
        
        buttonPanel.add(new JButton("Sine"));
        buttonPanel.add(new JButton("Cosine"));

        JPanel selectPanel = new JPanel(new FlowLayout());
        
        JButton nappi = new JButton("Select");

        nappi.addActionListener(new ValinnanSelectKuuntelija());
        selectPanel.add(nappi);
      
        panel.add("You choose", buttonPanel);
        panel.add("Computer chooses", selectPanel);
        DefaultComboBoxModel panelName = new DefaultComboBoxModel();

        panelName.addElement("You choose");
        panelName.addElement("Computer chooses");
        JComboBox listCombo = new JComboBox(panelName);

        listCombo.setSelectedIndex(0);
        JScrollPane listComboScrollPane = new JScrollPane(listCombo);
        JButton showButton = new JButton("Change");
        
        ValinnanChangeKuuntelija changeKuulija = new ValinnanChangeKuuntelija(listCombo, panel,statusLabel);
        showButton.addActionListener(changeKuulija);

        controlPanel.add(listComboScrollPane);
        controlPanel.add(showButton);
        controlPanel.add(panel);
        
        mainFrame.setVisible(true);
    }

}
