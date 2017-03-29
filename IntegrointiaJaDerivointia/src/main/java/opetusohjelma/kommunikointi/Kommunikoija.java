
package opetusohjelma.kommunikointi;

import java.util.Scanner;

public class Kommunikoija {
    private Scanner lukija;
    
    public Kommunikoija() {
        this.lukija = new Scanner(System.in);
    }
    
    public int eksponentinAlustus() {
        System.out.println("Anna eksponentti:");
        
        int eksponentti = Integer.parseInt(lukija.nextLine());
        
        return eksponentti;
    }
    
    public double funktionKertoimenAlustus() {
        System.out.println("Anna funktion kerroin:");
        
        double kerroin = Double.parseDouble(lukija.nextLine());
        
        return kerroin;
    }
    
    public double sisafunktionKertoimenAlustus() {
        System.out.println("Anna sisäfunktion kerroin:");
        
        double kerroin = Double.parseDouble(lukija.nextLine());
        
        return kerroin;
    }
}
