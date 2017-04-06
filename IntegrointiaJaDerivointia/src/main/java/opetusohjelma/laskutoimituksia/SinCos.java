package opetusohjelma.laskutoimituksia;

/**
 * Luokka tarjoaa sini- ja cosinifunktioiden integrointiin ja derivointiin
 * tarvittavia metodeja.
 */
public class SinCos {

    private double kerroin;
    private double sisaFunktionKerroin;
    /**
     * Merkkijono funktio kertoo, onko funktio sini vai kosini.
     */
    private String funktio;
    /**
     * Integroitu-muuttujan arvo on true, mikäli funktio on integroitu. Mikäli
     * funktiota ei ole integroitu, muuttujan arvo on false.
     */
    private boolean integoitu;

    /**
     * Konstruktorissa hyväksytään sinin ja kosinin kirjoittamien sekä isolla
     * että pienellä alkukirjaimella. Huomioidaan myös kirjoitusvirheen mahdollisuus,
     * jolloin funktio on tyhjä merkkijono.
     * Konstruktorissa alustetaan käyttäjän syöttämän funktion kerroin ja sisäfunktion kerroin.
     * Muuttuja "integroitu" alustetaan epätodeksi.
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

    public String getFunktio() {
        return this.funktio;
    }

    public boolean getIntergroitu() {
        return this.integoitu;
    }

    public void setKerroin(double luku) {
        this.kerroin = luku;
    }

    public void setSisafunktionKerroin(double luku) {
        this.sisaFunktionKerroin = luku;
    }
    
    /**
     * Metodin avulla funktio derivoidaan. Derivointi suoritetaan
     * muuttamalla kertoimen arvoa sekä sini kosiniksi tai kosini siniksi. 
     * Integroitu-muuttujan arvo muutetaan derivoidessa true:ksi.
     */
    public void derivoi() {
        if (this.funktio.equals("sin")) {
            this.kerroin = this.kerroin * this.sisaFunktionKerroin;
            this.funktio = "cos";
        } else if (this.funktio.equals("cos")) {
            this.kerroin = -1 * this.kerroin * this.sisaFunktionKerroin;
            this.funktio = "sin";
        }
        this.integoitu = false;

    }

    /**
     * Metodin avulla funktio integroidaan. Integrointi suoritetaan
     * muuttamalla kertoimen arvoa sekä sini kosiniksi tai kosini siniksi. 
     * Integroitu-muuttujan arvo muutetaan derivoidessa true:ksi.
     */
    public void integroi() {
        if (this.funktio.equals("sin")) {
            this.kerroin = -1 * this.kerroin / this.sisaFunktionKerroin;
            this.funktio = "cos";
        } else if (this.funktio.equals("cos")) {
            this.kerroin = this.kerroin / this.sisaFunktionKerroin;
            this.funktio = "sin";
        }
        this.integoitu = true;
    }
    
    /**
     * Metodin avulla tulostetaan funktio merkkijonona.
     * 
     * @return funktio merkkijonomuodossa.
     */
    public String toString() {

        String tulostus = Double.toString(this.kerroin) + " * " + this.funktio + "(" + Double.toString(this.sisaFunktionKerroin) + "x)";

        if (this.integoitu == true) {
            tulostus = tulostus + " + C";
        }

        return tulostus;
    }
}
