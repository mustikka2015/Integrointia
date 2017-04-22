package opetusohjelma.laskutoimituksia;

import java.text.DecimalFormat;

/**
 * Luokka tarjoaa polynomien integrointiin ja derivointiin tarvittavia metodeja.
 */
public class Polynomi implements Funktio {

    private int eksponentti;
    private double kerroin;
    private boolean luonnollinenLogaritmi;
    private int integroitu;
    private String funktio;

    /**
     * Konstruktori luokalle Polynomi. Muuttujat "eksponentti" ja "kerroin" alustetaan
     * parametrien avulla. Polynomi ei ole aluksi luonnollinen logaritmi, eikä sitä ole 
     * vielä integroitu, joten "integroitu"-muuttujan arvo on  aluksi 0.
     * 
     * @param eksponentti int-muodossa
     * @param kerroin double-muodossa
     */
    public Polynomi(int eksponentti, double kerroin) {
        this.eksponentti = eksponentti;
        this.kerroin = kerroin;
        this.luonnollinenLogaritmi = false;
        this.integroitu = 0;
        this.funktio = "polynom";

    }

    public int getEksponentti() {
        return this.eksponentti;
    }

    public double getKerroin() {
        return this.kerroin;
    }

    /**
     * Metodi palauttaa tiedon siitä, onko funktio integroitu tai derivoitu. Jos
     * funktio on viimeksi integroitu, se palauttaa 1. Jos funktio on viimeksi
     * derivoitu, se palauttaa 0. Jos funktiota ei ole vielä integroitu, se
     * palauttaa 0.
     *
     * @return kokonaislukuna, onko funktio viimeksi integroitu vai derivoitu.
     */
    public int getIntegroitu() {
        return this.integroitu;
    }

    /**
     * Metodi palauttaa, onko funktio luonnollinen logaritmi x:stä. Mikäli x:n
     * eksponentti on aluksi -1, funktiota integroitaessa saadaan luonnollinen
     * logaritmi.
     *
     * @return true, jos funktio on luonnollinen logaritmi.
     */
    public boolean getLuonnollinenLogaritmi() {
        return this.luonnollinenLogaritmi;
    }
    @Override
    public String getFunktio(){
        return this.funktio;
    }

    /**
     * Metodin avulla asetetaan polynomifunktion eksponentti.
     * 
     * @param eksponentti int-muodossa.
     */
    public void setEksponentti(int eksponentti) {
        this.eksponentti = eksponentti;
    }

    /**
     * Metodin avulla asetetaan polynomifunktion kerroin.
     * 
     * @param kerroin double-muodossa.
     */
    public void setKerroin(double kerroin) {
        this.kerroin = kerroin;
    }

    /**
     * Metodin avulla polynomifunktio derivoidaan. Derivointi suoritetaan
     * muuttamalla kertoimen ja eksponentin arvoja. Integroitu-muuttujan arvo
     * muutetaan derivoidessa 0:ksi.
     */
    @Override
    public void derivoi() {
        this.kerroin = this.kerroin * this.eksponentti;           
        this.eksponentti = this.eksponentti - 1;
        this.integroitu = 0;
    }

    /**
     * Metodin avulla polynomifunktio integroidaan. Integrointi suoritetaan
     * muuttamalla kertoimen ja eksponentin arvoja. Integroitu-muuttujan arvo
     * muutetaan integroidessa 1:ksi. Mikäli eksponentin arvo ennen integrointia
     * on -1, integroidessa asetetaan todeksi se, että funktio on luonnollinen
     * logaritmi.
     */
    @Override
    public void integroi() {
        if (this.eksponentti != -1) {
            this.eksponentti = this.eksponentti + 1;
            this.kerroin = this.kerroin / this.eksponentti;
 
            this.integroitu = 1;
        } else {
            this.luonnollinenLogaritmi = true;
            this.integroitu = 1;
        }

    }

    /**
     * Metodin avulla tulostetaan polynomifunktio merkkijonona.
     *
     * @return funktio merkkijonomuodossa.
     */
    @Override
    public String toString() {
        String tulostus = "";
        if (this.luonnollinenLogaritmi == false && this.integroitu == 0) {
            tulostus = this.kerroin + " * x^(" + this.eksponentti + ")";

        } else if (this.luonnollinenLogaritmi == false && this.integroitu == 1) {  //En ole vielä päätänyt, voiko integroida monta kertaa peräkkäin.
            // Mikäli voi, täytyy tulostukset muokata sen mukaiseksi.
            tulostus = this.kerroin + " * x^(" + this.eksponentti + ") + C";

        } else {
            tulostus = this.kerroin + " * ln|x| + C";
        }

        return tulostus;
    }

   

}
