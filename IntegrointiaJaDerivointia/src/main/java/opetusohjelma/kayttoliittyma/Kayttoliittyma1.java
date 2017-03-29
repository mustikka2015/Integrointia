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

public class Kayttoliittyma1 implements Runnable {

    private JFrame frame;

    public Kayttoliittyma1() {
    }

    @Override
    public void run() {
        frame = new JFrame("Integrointia ja derivointia");
        frame.setPreferredSize(new Dimension(400, 100));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(1, 3);
        container.setLayout(layout);

        JTextArea textArea = new JTextArea("\n Valitse funktion \n tai pyydä konetta \n arpomaan sen");
        JButton arvoNappi = new JButton("Arvo");
        JButton valitseNappi = new JButton("Valitse");

        container.add(arvoNappi);
        container.add(textArea);
        container.add(valitseNappi);

    }

    public JFrame getFrame() {
        return frame;
    }

}
