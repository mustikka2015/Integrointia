package opetusohjelma.kayttoliittyma;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;

/**
 * Tämän luokan avulla kuunnellaan select-näppäintä.
 */
public class ValinnanSelectKuuntelija implements ActionListener {

    

    public ValinnanSelectKuuntelija() {

    }

    /**
     * Tämän metodin avulla kuunnellaan select-näppäintä. Kuuntelun
     * tuloksena tietokone näyttää uuden käyttöliittymänäkymän, johon tietokone
     * on arponut funktion ja pyytää integroimaan tai derivoimaan funktion.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        KoneValitseeGUI konevalinta = new KoneValitseeGUI();
        SwingUtilities.invokeLater((Runnable) konevalinta);

        
    }

}
