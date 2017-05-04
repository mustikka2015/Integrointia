/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opetusohjelma.laskutoimituksia;

/**
 * Rajapinta Funktio toimii rajapintana erilaisille funktio-olioille, kuten
 * Polynom ja SinCos.
 *
 * @author Iisa
 */
public interface Funktio {

    /**
     * Metodi tulostaa funktion merkkijonona.
     *
     * @return String
     */
    @Override
    String toString();

    /**
     * Metodi integroi funktion.
     */
    void integroi();

    /**
     * Metodi derivoi funktion.
     */
    void derivoi();

    /**
     * Metodi palauttaa funktion.
     *
     * @return String funktio
     */
    String getFunktio();

    /**
     * Metodi palauttaa x-koordinaattia vastaavan y-koordinaatin.
     *
     * @param x double
     * @return double y
     */
    double getY(double x);

}
