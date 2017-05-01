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
        Polynomi polynomi = (Polynomi) this.funktio;

        Polynomi alkuperainen = new Polynomi(polynomi.getEksponentti(), polynomi.getKerroin());
        piirtaminen(graphics, polynomi, alkuperainen, Color.BLACK);

        Polynomi polynomi2 = new Polynomi(polynomi.getEksponentti(), polynomi.getKerroin());
        polynomi2.derivoi();
        piirtaminen(graphics, polynomi2, alkuperainen, Color.BLUE);

        Polynomi polynomi3 = new Polynomi(polynomi.getEksponentti(), polynomi.getKerroin());
        polynomi3.integroi();
        piirtaminen(graphics, polynomi3, alkuperainen, Color.RED);
    }

    public void piirtaminen(Graphics graphics, Polynomi polynomi, Polynomi alkuperainen, Color color) {
        double kerroin = alkuperainen.getKerroin();

        for (double i = 0; i < 800; i++) {
            double j = i-400;
            Double dj = new Double(polynomi.getY(j / 10)) * 100 / (kerroin);
            int y1 = dj.intValue();
            int y2 = new Double(polynomi.getY((j + 1) / 10) * 100 / (kerroin)).intValue();
            int x1 = new Double(j).intValue() * 20 + 400;
            int x2 = new Double((j + 1)).intValue() * 20 + 400;
            graphics.setColor(color);
            graphics.drawLine(x1, (400 - y1), x2, (400 - y2));

        }
    }

}
