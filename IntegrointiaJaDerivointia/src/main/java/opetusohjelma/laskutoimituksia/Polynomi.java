package opetusohjelma.laskutoimituksia;

public class Polynomi {

    private int eksponentti;
    private double kerroin;
    private boolean luonnollinenLogaritmi;
    private int integroitu;

    public Polynomi(int eksponentti, double kerroin) {
        this.eksponentti = eksponentti;
        this.kerroin = kerroin;
        this.luonnollinenLogaritmi = false;
        this.integroitu = 0;
        
    }
    
    public int getEksponentti() {
        return this.eksponentti;
    }
    
    public double getKerroin() {
        return this.kerroin;
    }
    
    public int getIntegroitu() {
        return this.integroitu;
    }
    
    public boolean getLuonnollinenLogaritmi() {
        return this.luonnollinenLogaritmi;
    }

    public void setEksponentti(int eksponentti) {
        this.eksponentti = eksponentti;
    }

    public void setKerroin(double kerroin) {
        this.kerroin = kerroin;
    }

    public void derivoi() {
        this.kerroin = this.kerroin * this.eksponentti;
        this.eksponentti = this.eksponentti - 1;
        this.integroitu = 0;
    }

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
