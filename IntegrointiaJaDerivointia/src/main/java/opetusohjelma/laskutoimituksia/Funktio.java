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
    String toString();
    void integroi();
    void derivoi();
    String getFunktio();

}
