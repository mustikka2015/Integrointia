package opetusohjelma.laskutoimituksia;

public class SinCos {

    private double kerroin;
    private double sisaFunktionKerroin;
    private String funktio;                 //Sini vai kosini

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

    }
    
    public void derivoi() {
        if (this.funktio.equals("sin")) {
            this.kerroin = this.kerroin * this.sisaFunktionKerroin;
            this.funktio = "cos";
        }
        
        if (this.funktio.equals("cos")) {
            this.kerroin = -1 * this.kerroin * this.sisaFunktionKerroin;
            this.funktio = "sin";
        }
        
    }
    
    public void integroi() {
        if (this.funktio.equals("sin")) {
            this.kerroin = -1 * this.kerroin / this.sisaFunktionKerroin;
            this.funktio = "cos";
        }
        
        if (this.funktio.equals("cos")) {
            this.kerroin = this.kerroin / this.sisaFunktionKerroin;
            this.funktio = "sin";
        }
    }
    
    public String toString() {
        
        String tulostus = this.kerroin + this.funktio + "(" + this.sisaFunktionKerroin + "x)";
        
        return "tulostus";
    }
}
