/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opetusohjelma.kayttoliittyma.view;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import opetusohjelma.laskutoimituksia.Funktio;
import opetusohjelma.laskutoimituksia.Polynomi;

/**
 *
 * @author Iisa
 */
public class PiirtoalustaPolynomille extends JPanel {

    private Funktio funktio;

    public PiirtoalustaPolynomille(Funktio funktio) {
        super.setBackground(Color.WHITE);
        this.funktio = funktio;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);


        for (int i = 0; i < 25; i++) {
            int j = this.funktio.getY(i);
            int k = this.funktio.getY(i + 1);
            graphics.drawLine(i*20, (450 - j), (i + 1)*20, (450 - k));
        }
    }

}
