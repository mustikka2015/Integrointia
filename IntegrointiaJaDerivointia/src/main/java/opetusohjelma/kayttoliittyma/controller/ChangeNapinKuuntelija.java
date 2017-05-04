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
 * Luokan avulla kuunnellaan "Change"-näppäintä.
 *
 * @author Iisa
 */
public class ChangeNapinKuuntelija implements ActionListener {

    private JComboBox valinnat;
    private JPanel pohja;
    private JLabel teksti;

    /**
     * Konstrunktori ChangeNapinKuuntelijalle.
     *
     * @param valinnat JComboBox
     * @param pohja JPanel
     * @param teksti JLabel
     */
    public ChangeNapinKuuntelija(JComboBox valinnat, JPanel pohja, JLabel teksti) {
        this.valinnat = valinnat;
        this.pohja = pohja;
        this.teksti = teksti;
    }

    /**
     * Painamalla "Change"-näppäintä näkymä vaihtuu opiskelijan valitsemana joko
     * "You choose" tai "Computer chooses"-valinnan mukaiseksi.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String data = "";
        if (valinnat.getSelectedIndex() != -1) {
            CardLayout cardLayout = (CardLayout) (pohja.getLayout());
            cardLayout.show(pohja,
                    (String) valinnat.getItemAt(valinnat.getSelectedIndex()));
        }
        teksti.setText(data);
    }

}
