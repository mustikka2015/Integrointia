/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opetusohjelma.kayttoliittyma.controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Tämän luokan avulla kuunnellaan "Change"-näppäintä.
 *
 * @author Iisa
 */
public class ValinnanChangeKuuntelija implements ActionListener {

    private JComboBox listCombo;
    private JPanel panel;
    private JLabel statusLabel;

    public ValinnanChangeKuuntelija(JComboBox listCombo, JPanel panel, JLabel statusLabel) {
        this.listCombo = listCombo;
        this.panel = panel;
        this.statusLabel = statusLabel;
    }
    
     /**
     * Tämän metodin avulla kuunnellaan Change-näppäintä. Kuuntelun tuloksena
     * näkymä vaihtuu opiskelijan valitsemana joko "You choose" tai 
     * "Compute chooses"-valinnan mukaiseksi.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String data = "";
        if (listCombo.getSelectedIndex() != -1) {
            CardLayout cardLayout = (CardLayout) (panel.getLayout());
            cardLayout.show(panel,
                    (String) listCombo.getItemAt(listCombo.getSelectedIndex()));
        }
        statusLabel.setText(data);
    }

}
