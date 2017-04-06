package opetusohjelma.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

/**
 * Tämän luokka sisältää ensimmäisen käyttöliittymäversion aloitussivusta.
 * Ensimmäisellä sivulla valitaan, arpooko tietokone integroitavan tai
 * derivoitavan funktion, vai valitseeko opiskelija itse funktion. Vaikka olen
 * päättänyt valita toisen version, säilytän tätä vielä varmuuden vuoksi.
 */
public class HylattyVersioGUI implements Runnable {

    private JFrame frame;

    public HylattyVersioGUI() {
    }

    /**
     * Metodi luo JFrame-olion ja alustaa sen halutunlaiseksi.
     */
    @Override
    public void run() {
        frame = new JFrame("Integration and derivation");
        frame.setPreferredSize(new Dimension(600, 150));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Metodissa alustetaan JFrame-olion layout ja luodaan komponentit, jotka lisätään layoutiin.
     */
    private void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(1, 3);
        container.setLayout(layout);

        JTextArea textArea = new JTextArea("\n Choose a function \n or ask the computer \n to draw lots to decide it");
        JButton arvoNappi = new JButton("Computer \n chooses");
        JButton valitseNappi = new JButton("You choose");
        ValinnanSelectKuuntelija valitsija = new ValinnanSelectKuuntelija();

        arvoNappi.addActionListener(valitsija);
        valitseNappi.addActionListener(valitsija);

        container.add(arvoNappi);
        container.add(textArea);
        container.add(valitseNappi);

    }

    public JFrame getFrame() {
        return frame;
    }

}
