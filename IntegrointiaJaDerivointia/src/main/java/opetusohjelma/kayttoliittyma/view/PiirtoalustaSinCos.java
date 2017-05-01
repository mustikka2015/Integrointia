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
import opetusohjelma.laskutoimituksia.SinCos;

/**
 *
 * @author Iisa
 */
public class PiirtoalustaSinCos extends JPanel {

    private Funktio funktio;

    public PiirtoalustaSinCos(Funktio funktio) {
        super.setBackground(Color.WHITE);
        this.funktio = funktio;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        
        SinCos sincos = (SinCos)this.funktio;
        double sisafunktionKerroin = sincos.getSisafunktionKerroin();
        double kerroin = sincos.getKerroin();

        for (int i = 0; i < 500/20; i++) {
            int j = this.funktio.getY(i*20)* (int)Math.round(100/kerroin);
            int k = this.funktio.getY((i+1)*20)*(int)Math.round(100/kerroin);
            graphics.drawLine(i*20, (250 - j), (i + 1)*20, (250 - k));
        }
    }
}
