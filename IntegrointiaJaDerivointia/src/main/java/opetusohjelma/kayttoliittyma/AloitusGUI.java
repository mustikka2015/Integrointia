package opetusohjelma.kayttoliittyma;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 * Käyttöliittymän aloitussivuston kakkosversio. Tästä todennäköisesti jatkan
 * kehitystyötä pääsiäislomalla.
 */
public class AloitusGUI {

    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;
    private JLabel msglabel;

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
     * Metodi luo CardLayout-näkymän ja sen paneelit painikkeineen sekä 
     * valintatoiminnallisuuden kahden eri paneelin välillä.
     */
    public void showCardLayout() {
        headerLabel.setText("Choose a function or draw lots to decide it");

        final JPanel panel = new JPanel();

        panel.setSize(300, 300);

        CardLayout layout = new CardLayout();
        layout.setHgap(10);
        layout.setVgap(10);
        panel.setLayout(layout);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(new JButton("Polynom"));
        buttonPanel.add(new JButton("Sine"));
        buttonPanel.add(new JButton("Cosine"));

        JPanel selectPanel = new JPanel(new FlowLayout());

        selectPanel.add(new JButton("Select"));
        
        
//      textBoxPanel.add(new JLabel("Name:"));
//      textBoxPanel.add(new JTextField(20));
        panel.add("You choose", buttonPanel);
        panel.add("Computer chooses", selectPanel);
        final DefaultComboBoxModel panelName = new DefaultComboBoxModel();

        panelName.addElement("You choose");
        panelName.addElement("Computer chooses");
        final JComboBox listCombo = new JComboBox(panelName);

        listCombo.setSelectedIndex(0);
        JScrollPane listComboScrollPane = new JScrollPane(listCombo);
        JButton showButton = new JButton("Change");

        showButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String data = "";
                if (listCombo.getSelectedIndex() != -1) {
                    CardLayout cardLayout = (CardLayout) (panel.getLayout());
                    cardLayout.show(panel,
                            (String) listCombo.getItemAt(listCombo.getSelectedIndex()));
                }
                statusLabel.setText(data);
            }
        });
        controlPanel.add(listComboScrollPane);
        controlPanel.add(showButton);
        controlPanel.add(panel);
        mainFrame.setVisible(true);
    }

}
