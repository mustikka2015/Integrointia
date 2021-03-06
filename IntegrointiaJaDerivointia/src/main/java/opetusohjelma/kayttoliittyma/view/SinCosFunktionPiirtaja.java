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
 * Sini- ja kosinifunktioiden piirtoalusta.
 *
 * @author Iisa
 */
public class SinCosFunktionPiirtaja extends JPanel {

    private Funktio funktio;

    /**
     * Konstruktori SinCosFunktionPiirtajalle.
     *
     * @param funktio Funktio
     */
    public SinCosFunktionPiirtaja(Funktio funktio) {
        super.setBackground(Color.WHITE);
        this.funktio = funktio;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        SinCos sincos = (SinCos) this.funktio;
        SinCos alkuperainen = new SinCos(sincos.getKerroin(), sincos.getSisafunktionKerroin(), sincos.getFunktio());
        piirtaminen(graphics, sincos, alkuperainen, Color.GREEN);

        SinCos derivaatta = new SinCos(sincos.getKerroin(), sincos.getSisafunktionKerroin(), sincos.getFunktio());
        derivaatta.derivoi();
        piirtaminen(graphics, derivaatta, alkuperainen, Color.BLUE);

        SinCos integraali = new SinCos(sincos.getKerroin(), sincos.getSisafunktionKerroin(), sincos.getFunktio());
        integraali.integroi();
        piirtaminen(graphics, integraali, alkuperainen, Color.RED);

        graphics.setColor(Color.BLACK);
        graphics.drawLine(0, 350, 800, 350);

    }

    /**
     * Funktio piirtää annetun sini- tai kosinifunktion.
     *
     * @param graphics Graphics
     * @param sincos SinCos
     * @param alkuperainen SinCos
     * @param color Color
     */
    public void piirtaminen(Graphics graphics, SinCos sincos, SinCos alkuperainen, Color color) {
        double sisafunktionKerroin = alkuperainen.getSisafunktionKerroin();
        double kerroin = alkuperainen.getKerroin();

        for (double i = 0; i < 800; i++) {
            Double dj = new Double(sincos.getY(i / (8 * sisafunktionKerroin))) * 100 / (kerroin);
            int y1 = dj.intValue();
            int y2 = new Double(sincos.getY((i + 1) / (8 * sisafunktionKerroin)) * 100 / (kerroin)).intValue();
            int x1 = new Double(i).intValue() * 8;
            int x2 = new Double((i + 1)).intValue() * 8;
            graphics.setColor(color);
            graphics.drawLine(x1, (350 - y1), x2, (350 - y2));

        }
    }
}
