package opetusohjelma.laskutoimituksia;

public class SinCos {

    private double kerroin;
    private double sisaFunktionKerroin;
    private String funktio;                 //Sini vai kosini
    private boolean integoitu;

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

    public String toString() {

        String tulostus = Double.toString(this.kerroin) + " * " + this.funktio + "(" + Double.toString(this.sisaFunktionKerroin) + "x)";

        if (this.integoitu == true) {
            tulostus = tulostus + " + C";
        }

        return tulostus;
    }
}
