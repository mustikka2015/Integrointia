/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opetusohjelma.kayttoliittyma.view;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import opetusohjelma.kayttoliittyma.controller.BackNapinKuuntelija;
import opetusohjelma.kayttoliittyma.controller.DifferentiateNapinKuuntelijaPolynomilla;
import opetusohjelma.kayttoliittyma.controller.DrawNapinKuuntelijaPolynomilla;
import opetusohjelma.kayttoliittyma.controller.IntegrateNapinKuuntelijaPolynomilla;
import opetusohjelma.kayttoliittyma.controller.ShowTheFunctionNapinKuuntelijaPolynomilla;
import opetusohjelma.laskutoimituksia.Polynomi;

/**
 * Tämä luokka toteuttaa näkymän, kun opiskelija valitsee "Polynom".
 *
 * @author Iisa
 */
public class PolynomGUI implements Runnable {
    
    private JFrame mainFrame;
    private JTextField funktio;
    private JTextField eksponentti;
    private JTextField kerroin;
    private JTextField vastaus;
    private Polynomi polynomi;

    /**
     * Konstruktori PolynomGUI:lle.
     */
    public PolynomGUI() {
        prepareGUI();
    }

    /**
     * Pääkehys alustetaan.
     */
    public void prepareGUI() {
        mainFrame = new JFrame("Integration and differentiation");
        mainFrame.setSize(500, 500);
        mainFrame.setLayout(new GridLayout(8, 1));
        
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        
        mainFrame.setVisible(true);
    }
    
    @Override
    public void run() {
        this.polynomi = new Polynomi(1, 1);
        valitseEksponentti();
        valitseKerroin();
        this.funktio = new JTextField();
        funktio.setHorizontalAlignment(JTextField.CENTER);
        funktiorivinAsetus(funktio);
        this.vastaus = new JTextField();
        vastaus.setHorizontalAlignment(JTextField.CENTER);
        lisaaNaytaFunktioNappi();
        answerIsRivinAsetus();
        vastausrivinAsetus(vastaus);
        integrateDerivateButtons();
        piirtoYmsNapinAsetus();
        
        mainFrame.setVisible(true);
    }
    
    /**
     * Metodi lisää painikkeen lisäten siihen tapahtumankuuntelijan.
     *
     * @param panel JPanel
     * @param button JButton
     * @param listener ActionListener
     */
    public void lisaaNappi(JPanel panel, JButton button, ActionListener listener) {

        button.addActionListener(listener);
        panel.add(button);
    }

    /**
     * Metodi luo "Valitse eksponentti" -rivin.
     */
    public void valitseEksponentti() {
        JPanel eksponenttirivi = new JPanel();
        eksponenttirivi.setLayout(new GridLayout(1, 2));
        JLabel teksti = new JLabel("", JLabel.CENTER);
        teksti.setText("Choose the exponent (integer):");
        this.eksponentti = new JTextField("", JLabel.CENTER);
        eksponenttirivi.add(teksti);
        eksponenttirivi.add(eksponentti);
        mainFrame.add(eksponenttirivi);
    }

    /**
     * Metodi luo "Valitse kerroin" -rivin.
     */
    public void valitseKerroin() {
        JPanel kerroinrivi = new JPanel();
        JPanel tekstit = new JPanel();
        BoxLayout layout = new BoxLayout(tekstit, BoxLayout.Y_AXIS);
        tekstit.add(new JLabel("Choose the coefficient"));
        tekstit.add(new JLabel("(decimal number):"));
        kerroinrivi.setLayout(new GridLayout(1, 2));
        this.kerroin = new JTextField();
        kerroinrivi.add(tekstit);
        kerroinrivi.add(kerroin);
        mainFrame.add(kerroinrivi);
    }

    /**
     * Metodi luo "Show the function" -napin.
     */
    public void lisaaNaytaFunktioNappi() {
        JPanel naytaFunktioRivi = new JPanel();
        mainFrame.add(naytaFunktioRivi);
        JButton nappi = new JButton("Show the function");
        ShowTheFunctionNapinKuuntelijaPolynomilla kuulija = new ShowTheFunctionNapinKuuntelijaPolynomilla(funktio, eksponentti, kerroin, polynomi);
        lisaaNappi(naytaFunktioRivi, nappi, kuulija);
    }

    /**
     * Metodi luo tekstikentän, jossa funktio näytetään.
     *
     * @param funktio JTextField
     */
    public void funktiorivinAsetus(JTextField funktio) {
        JPanel funktiorivi = new JPanel();
        funktiorivi.setLayout(new GridLayout());
        funktiorivi.add(funktio);
        mainFrame.add(funktiorivi);
    }

    /**
     * Metodi luo "Integrate"- ja "Differenriate"-näppäinrivin.
     */
    public void integrateDerivateButtons() {
        JPanel intDerRivi = new JPanel();
        JButton integroi = new JButton("Integrate");
        integroi.setBackground(Color.cyan);
        IntegrateNapinKuuntelijaPolynomilla intKuulija = new IntegrateNapinKuuntelijaPolynomilla(polynomi, vastaus, eksponentti, kerroin);
        lisaaNappi(intDerRivi, integroi, intKuulija);
        JButton derivoi = new JButton("Differentiate");
        derivoi.setBackground(Color.cyan);
        DifferentiateNapinKuuntelijaPolynomilla derivKuulija = new DifferentiateNapinKuuntelijaPolynomilla(polynomi, vastaus, eksponentti, kerroin);
        lisaaNappi(intDerRivi, derivoi, derivKuulija);
        derivoi.addActionListener(derivKuulija);
        mainFrame.add(intDerRivi);
    }

    /**
     * Metodi luo "Answer is:" rivin.
     */
    public void answerIsRivinAsetus() {
        JLabel vastausOnRivi = new JLabel("", JLabel.CENTER);
        mainFrame.add(vastausOnRivi);
        vastausOnRivi.setText("Answer is:");
    }

    /**
     * Metodi luo tekstikentän, jossa funktio näytetään.
     *
     * @param vastaus JTextField
     */
    public void vastausrivinAsetus(JTextField vastaus) {
        JPanel vastausrivi = new JPanel();
        vastausrivi.setLayout(new GridLayout());
        vastausrivi.add(vastaus);
        mainFrame.add(vastausrivi);
    }

    /**
     * Metodi luo "Back"- ja "Draw the solutions" -napit.
     */
    public void piirtoYmsNapinAsetus() {
        JPanel piirtorivi = new JPanel();
        mainFrame.add(piirtorivi);
        JButton takaisin = new JButton("Back");
        BackNapinKuuntelija kuulija = new BackNapinKuuntelija(mainFrame);
        lisaaNappi(piirtorivi, takaisin, kuulija);
        JButton piirra = new JButton("Draw the solutions");
        DrawNapinKuuntelijaPolynomilla dkuulija = new DrawNapinKuuntelijaPolynomilla(this.polynomi, this.eksponentti, this.kerroin, this.vastaus);
        lisaaNappi(piirtorivi, piirra, dkuulija);
    }
}
