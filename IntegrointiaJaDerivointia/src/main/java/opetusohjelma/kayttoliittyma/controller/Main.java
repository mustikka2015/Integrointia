/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opetusohjelma.kayttoliittyma.controller;

import javax.swing.SwingUtilities;
import opetusohjelma.kayttoliittyma.view.AloitusGUI;
import opetusohjelma.laskutoimituksia.SinCos;

public class Main {

    public static void main(String[] args) {

        AloitusGUI testi = new AloitusGUI();
        testi.showCardLayout();

//        SinCos sin = new SinCos(7.896, 1.234567, "sin");
//        double ker = sin.pyoristetynKertoimenLaskeminenIntegraaliin(7.896,1.234567);
//        String kerroin = Double.toString(ker);
//        System.out.println(kerroin);

    }
}
