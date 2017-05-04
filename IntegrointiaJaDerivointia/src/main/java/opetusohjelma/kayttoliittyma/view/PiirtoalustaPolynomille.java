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
 * Polynomifunktion, sen derivaatan ja integraalin piirtäminen.
 *
 * @author Iisa
 */
public class PiirtoalustaPolynomille extends JPanel {

    private Funktio funktio;

    /**
     * Konstruktori PiirtoalustaPolynomille.
     *
     * @param funktio Funktio
     */
    public PiirtoalustaPolynomille(Funktio funktio) {
        super.setBackground(Color.WHITE);
        this.funktio = funktio;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Polynomi polynomi = (Polynomi) this.funktio;

        Polynomi alkuperainen = new Polynomi(polynomi.getEksponentti(), polynomi.getKerroin());
        piirtaminen(graphics, polynomi, alkuperainen, Color.GREEN);

        Polynomi derivaatta = new Polynomi(polynomi.getEksponentti(), polynomi.getKerroin());
        derivaatta.derivoi();
        piirtaminen(graphics, derivaatta, alkuperainen, Color.BLUE);

        Polynomi integraali = new Polynomi(polynomi.getEksponentti(), polynomi.getKerroin());
        integraali.integroi();
        piirtaminen(graphics, integraali, alkuperainen, Color.RED);

        graphics.setColor(Color.BLACK);
        graphics.drawLine(0, 400, 800, 400);
        graphics.drawLine(400, 0, 400, 800);
    }

    /**
     * Funktio piirtää annetun polynomifunktion.
     *
     * @param graphics Graphics
     * @param polynomi Polynomi
     * @param alkuperainen Polynomi
     * @param color Color
     */
    public void piirtaminen(Graphics graphics, Polynomi polynomi, Polynomi alkuperainen, Color color) {
        double kerroin = alkuperainen.getKerroin();

        for (double i = 0; i < 800; i++) {
            double j = i - 400;
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
