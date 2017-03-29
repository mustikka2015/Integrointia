package opetusohjelma.kayttoliittyma;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        Kayttoliittyma1 kayttoliittyma = new Kayttoliittyma1();
        SwingUtilities.invokeLater((Runnable) kayttoliittyma);
    }
}
