package opetusohjelma.laskutoimituksia;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Luokka tarjoaa sini- ja cosinifunktioiden integrointiin ja derivointiin
 * tarvittavia metodeja.
 */
public class SinCos implements Funktio {

    private double kerroin;
    private double sisaFunktionKerroin;
    private String funktio;
    private boolean integoitu;

    /**
     * Konstruktorissa hyväksytään sinin ja kosinin kirjoittamien sekä isolla
     * että pienellä alkukirjaimella. Huomioidaan myös kirjoitusvirheen
     * mahdollisuus, jolloin funktio on tyhjä merkkijono. Konstruktorissa
     * alustetaan käyttäjän syöttämän funktion kerroin ja sisäfunktion kerroin.
     * Muuttuja "integroitu" alustetaan epätodeksi.
     *
     * @param kerroin double-muodossa
     * @param sisaFunktionKerroin double-muodossa
     * @param funktio String-muodossa
     */
    public SinCos(double kerroin, double sisaFunktionKerroin, String funktio) {
        this.kerroin = kerroin;
        this.sisaFunktionKerroin = sisaFunktionKerroin;
        if (funktio.equals("sin") || funktio.equals("Sin")) {
            this.funktio = "sin";
        } else if (funktio.equals("cos") || funktio.equals("Cos")) {
            this.funktio = "cos";
        } else {
            this.funktio = "";
        }
        this.integoitu = false;
    }

    public double getKerroin() {
        return this.kerroin;
    }

    public double getSisafunktionKerroin() {
        return this.sisaFunktionKerroin;
    }

    @Override
    public String getFunktio() {
        return this.funktio;
    }

    public boolean getIntergroitu() {
        return this.integoitu;
    }

    /**
     * Metodin avulla asetetaan funktion kerroin.
     *
     * @param kerroin double-muodossa
     */
    public void setKerroin(double kerroin) {
        this.kerroin = kerroin;
    }

    /**
     * Metodin avulla asetetaan sisäfunktion kerroin.
     *
     * @param sisafunktionKerroin double-muodossa
     */
    public void setSisafunktionKerroin(double sisafunktionKerroin) {
        this.sisaFunktionKerroin = sisafunktionKerroin;
    }

    /**
     * Metodin avulla pyöristetään double-tyyppinen luku.
     *
     * @param mitta double-muodossa. Pyöristyksen mitta.
     * @param tuloste double-muodossa
     * @return desimaaliluku sopivasti pyöristettynä.
     */
    public double kertoimenPyoristys(double mitta, double tuloste) {
        Double mitta1 = (Double) mitta;
        String[] jakaja1 = mitta1.toString().split("\\.");
        int syotteenPituus = jakaja1[0].length() + jakaja1[1].length();
        if (jakaja1[0].equals("0")) {
            syotteenPituus = jakaja1[1].length();
        }
        Double mitta2 = (Double) tuloste;
        String[] jakaja2 = mitta2.toString().split("\\.");
        int tulosteenDesimaalit = Math.max(syotteenPituus - jakaja2[0].length(), 1);
        if (jakaja2[0].equals("0")) {
            tulosteenDesimaalit = syotteenPituus;
        }
        return new BigDecimal(tuloste).setScale(tulosteenDesimaalit, RoundingMode.HALF_UP).doubleValue();
    }

    /**
     * Metodin avulla lasketaan double-tyyppinen sopivasti pyöristetty kerroin
     * derivoituun sini- tai kosinifunktioon.
     *
     * @param kerroin double
     * @param sisaFunktionKerroin double
     * @return desimaaliluku sopivasti pyöristettynä.
     */
    public double pyoristetynKertoimenLaskeminenDerivaattaan(double kerroin, double sisaFunktionKerroin) {
        double pyoristettyKerroin = kerroin * sisaFunktionKerroin;
        if (onkoLyhyempi(kerroin, sisaFunktionKerroin)) {
            pyoristettyKerroin = kertoimenPyoristys(kerroin, pyoristettyKerroin);
        } else {
            pyoristettyKerroin = kertoimenPyoristys(sisaFunktionKerroin, pyoristettyKerroin);
        }
        return pyoristettyKerroin;
    }

    @Override
    public void derivoi() {

        if (this.funktio.equals("sin")) {
            this.kerroin = pyoristetynKertoimenLaskeminenDerivaattaan(this.kerroin, this.sisaFunktionKerroin);
            this.funktio = "cos";
        } else if (this.funktio.equals("cos")) {
            this.kerroin = -1 * pyoristetynKertoimenLaskeminenDerivaattaan(this.kerroin, this.sisaFunktionKerroin);
            this.funktio = "sin";
        }
        this.integoitu = false;

    }

    /**
     * Metodin avulla lasketaan double-tyyppinen sopivasti pyöristetty kerroin
     * integroituun sini- tai kosinifunktioon.
     *
     * @param kerroin double
     * @param sisaFunktionKerroin double
     * @return desimaaliluku sopivasti pyöristettynä.
     */
    public double pyoristetynKertoimenLaskeminenIntegraaliin(double kerroin, double sisaFunktionKerroin) {
        double pyoristettyKerroin = kerroin / sisaFunktionKerroin;
        if (onkoLyhyempi(kerroin, sisaFunktionKerroin)) {
            pyoristettyKerroin = kertoimenPyoristys(kerroin, pyoristettyKerroin);
        } else {
            pyoristettyKerroin = kertoimenPyoristys(sisaFunktionKerroin, pyoristettyKerroin);
        }
        return pyoristettyKerroin;
    }

    /**
     * Metodin avulla verrataan kertoimen ja sisäfunktion kertoimen pituuksia.
     *
     * @param kerroin double
     * @param sisaFunktionKerroin double
     * @return boolean-arvo true, jos kerroin on lyhyempi. Muuten false.
     */
    public boolean onkoLyhyempi(double kerroin, double sisaFunktionKerroin) {
        int kertoimenPituus = Double.toString(kerroin).length();
        int sisakertoimenPituus = Double.toString(sisaFunktionKerroin).length();
        if (kertoimenPituus <= sisakertoimenPituus) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void integroi() {
        if (this.funktio.equals("sin")) {
            this.kerroin = -1 * pyoristetynKertoimenLaskeminenIntegraaliin(this.kerroin, this.sisaFunktionKerroin);
            this.funktio = "cos";
        } else if (this.funktio.equals("cos")) {
            this.kerroin = pyoristetynKertoimenLaskeminenIntegraaliin(this.kerroin, this.sisaFunktionKerroin);
            this.funktio = "sin";
        }
        this.integoitu = true;
    }

    @Override
    public String toString() {
        String tulostus = Double.toString(this.kerroin) + " * " + this.funktio + "(" + Double.toString(this.sisaFunktionKerroin) + "x)";
        if (this.integoitu == true) {
            tulostus = tulostus + " + C";
        }
        return tulostus;
    }

    @Override
    public double getY(double x) {
        double vastaus = 1;
        if (this.funktio.equals("sin")) {
            vastaus = vastaus * this.kerroin * Math.sin(this.sisaFunktionKerroin * x);
        } else if (this.funktio.equals("cos")) {
            vastaus = vastaus * this.kerroin * Math.cos(this.sisaFunktionKerroin * x);
        }
        return vastaus;
    }
}
