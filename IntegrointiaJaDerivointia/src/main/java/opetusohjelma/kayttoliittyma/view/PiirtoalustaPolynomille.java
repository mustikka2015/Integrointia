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
            
            int y1 = new Double(this.funktio.getY(i)).intValue();
            int y2 = new Double(this.funktio.getY(i+1)).intValue();
            int x1 = new Double(i).intValue();
            int x2 = new Double(i+1).intValue();
            graphics.drawLine(x1, y1, x2, y2);
        }
    }

}
