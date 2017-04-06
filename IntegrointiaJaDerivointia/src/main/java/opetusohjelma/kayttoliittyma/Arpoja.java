package opetusohjelma.kayttoliittyma;

import java.util.ArrayList;
import java.util.Random;

/**
 * Tämän luokan avulla luodaan olioita, jotka arpovat sekä itse funktion, että
 * sen kertoimet.
 */
public class Arpoja {

    private Random arpoja;

    /**
     * Luokka tarjoaa funktion, eksponentin ja kertoimen arpomiseen tarvittavia
     * metodeja.
     */
    public Arpoja() {
        this.arpoja = new Random();
    }

    /**
     * Metodi arpoo funktion, jonka opiskelijan tulee integroida tai derivoida.
     * Funktiovaihtoehdot ovat polynomi-, sini- ja kosinifunktio.
     *
     * @return arvottu funktio String-muodossa
     */
    public String arvoFunktio() {
        ArrayList<String> funktiot = new ArrayList<String>();
        funktiot.add("polynom");
        funktiot.add("sin");
        funktiot.add("cos");

        int arvottu = this.arpoja.nextInt(funktiot.size());

        String funktio = funktiot.get(arvottu);

        return funktio;
    }

    /**
     * Metodi arpoo polynomifunktion eksponentin. Eksponentti voi saada arvoja
     * -10:stä 10:een.
     *
     * @return arvottu eksponentti int-muodossa.
     */
    public int arvoPolynominEksponentti() {

        int arvottu = this.arpoja.nextInt(21);
        arvottu = arvottu - 10;

        return arvottu;
    }

    /**
     * Metodi arpoo double-tyyppisen kertoimen. Kerroin voi saada arvoja
     * -10.0:stä 10.0:een.
     *
     * @return arvottu kerroin double-muodossa.
     */
    public double arvoKerroin() {

        double arvottu = (double)(this.arpoja.nextInt(201)-100)/10;

        return arvottu;
    }
    
    /**
     * Metodi arpoo, integroidaanko vai derivoidaanko funktio.
     *
     * @return String: "Integroi" tai "Derivoi"
     */
    public String arvoToiminto() {

        ArrayList<String> vaihtoehdot = new ArrayList<String>();

        vaihtoehdot.add("Integroi");
        vaihtoehdot.add("Derivoi");
        
        int arvottu = this.arpoja.nextInt(vaihtoehdot.size());
        
        String toiminta = vaihtoehdot.get(arvottu);
        
        return toiminta;
    }
    
    
}
