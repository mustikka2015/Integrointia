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
     * Metodi arpoo polynomifunktion eksponentin.
     * Eksponentti voi saada arvoja -10:stä 10:een.
     *
     * @return arvottu eksponentti int-muodossa.
     */
    public int arvoPolynominEksponentti() {
        
        int arvottu = this.arpoja.nextInt(21);
        arvottu = arvottu - 10;
        
        return arvottu;
    }

}
