/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opetusohjelma.kayttoliittyma.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import opetusohjelma.kayttoliittyma.controller.BackNapinKuuntelija;
import opetusohjelma.kayttoliittyma.controller.DifferentiateNapinKuuntelijaSinCos;
import opetusohjelma.kayttoliittyma.controller.DrawNapinKuuntelijaSinCos;
import opetusohjelma.kayttoliittyma.controller.IntegrateNapinKuuntelijaSinCos;
import opetusohjelma.kayttoliittyma.controller.ShowTheFunctionNapinKuuntelijaSinCosilla;
import opetusohjelma.laskutoimituksia.SinCos;

/**
 * Tämä luokka toteuttaa näkymän, kun opiskelija valitsee "Sine".
 *
 * @author Iisa
 */
public class SinGUI implements Runnable {

    private JFrame mainFrame;
    private JPanel tekstialusta;
    private JTextField funktio;
    private JTextField vastaus;
    private JTextField kerroinvalinta;
    private JTextField sisafunktionKerroinvalinta;
    private SinCos sin;

    /**
     * Konstruktori SinGUI:lle.
     */
    public SinGUI() {
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

        this.sin = new SinCos(1.0, 1.0, "sin");
        valitseKerroin();
        valitseSisafunktionKerroin();
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
     * Metodi luo "Valitse funktion kerroin" -rivin.
     */
    public void valitseKerroin() {
        JPanel kerroinrivi = new JPanel();
        tekstialusta = new JPanel();
        BoxLayout layout = new BoxLayout(tekstialusta, BoxLayout.Y_AXIS);
        tekstialusta.add(new JLabel("Choose the coefficient of Sin"));
        tekstialusta.add(new JLabel("(decimal number):"));
        kerroinrivi.setLayout(new GridLayout(1, 2));
        kerroinvalinta = new JTextField();
        kerroinrivi.add(tekstialusta);
        kerroinrivi.add(kerroinvalinta);
        mainFrame.add(kerroinrivi);
    }

    /**
     * Metodi luo "Valitse sisäfunktion kerroin" -rivin.
     */
    public void valitseSisafunktionKerroin() {
        JPanel sisafunktionKerroinRivi = new JPanel();
        tekstialusta = new JPanel();
        BoxLayout layout = new BoxLayout(tekstialusta, BoxLayout.Y_AXIS);
        tekstialusta.add(new JLabel("Choose the coefficient of x"));
        tekstialusta.add(new JLabel("(decimal number):"));
        sisafunktionKerroinRivi.setLayout(new GridLayout(1, 2));
        sisafunktionKerroinvalinta = new JTextField();
        sisafunktionKerroinRivi.add(tekstialusta);
        sisafunktionKerroinRivi.add(sisafunktionKerroinvalinta);
        mainFrame.add(sisafunktionKerroinRivi);
    }

    /**
     * Metodi luo "Show the function" -napin.
     */
    public void lisaaNaytaFunktioNappi() {
        JPanel naytaFunktioRivi = new JPanel();
        mainFrame.add(naytaFunktioRivi);
        JButton nappi = new JButton("Show the function");
        ShowTheFunctionNapinKuuntelijaSinCosilla kuulija = new ShowTheFunctionNapinKuuntelijaSinCosilla(funktio, kerroinvalinta, sisafunktionKerroinvalinta, sin);
        lisaaNappi(naytaFunktioRivi, nappi, kuulija);
    }

    /**
     * Metodi luo tekstikentän, jossa funktio näytetään.
     *
     * @param funktio JTextField
     */
    public void funktiorivinAsetus(JTextField funktio) {
        JPanel funktiokentta = new JPanel();
        funktiokentta.setLayout(new GridLayout());
        funktiokentta.add(funktio);
        mainFrame.add(funktiokentta);
    }

    /**
     * Metodi luo "Integrate"- ja "Differentiate"-näppäinrivin.
     */
    public void integrateDerivateButtons() {
        JPanel intDerRivi = new JPanel();
        JButton integroi = new JButton("Integrate");
        integroi.setBackground(Color.cyan);
        IntegrateNapinKuuntelijaSinCos intKuulija = new IntegrateNapinKuuntelijaSinCos(sin, vastaus, kerroinvalinta, sisafunktionKerroinvalinta);
        lisaaNappi(intDerRivi, integroi, intKuulija);
        JButton derivoi = new JButton("Differentiate");
        derivoi.setBackground(Color.cyan);
        DifferentiateNapinKuuntelijaSinCos diffKuulija = new DifferentiateNapinKuuntelijaSinCos(sin, vastaus, kerroinvalinta, sisafunktionKerroinvalinta);
        lisaaNappi(intDerRivi, derivoi, diffKuulija);
        mainFrame.add(intDerRivi);
    }

    /**
     * Metodi luo "Answer is:" -rivin.
     */
    public void answerIsRivinAsetus() {
        JLabel vastausOnRivi = new JLabel("", JLabel.CENTER);
        mainFrame.add(vastausOnRivi);
        vastausOnRivi.setText("Answer is:");
    }

    /**
     * Metodi luo tekstikentän, jossa vastaus näytetään.
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
        JButton sulje = new JButton("Back");
        BackNapinKuuntelija kuulija = new BackNapinKuuntelija(mainFrame);
        lisaaNappi(piirtorivi, sulje, kuulija);
        JButton piirra = new JButton("Draw the solutions");
        DrawNapinKuuntelijaSinCos piirto = new DrawNapinKuuntelijaSinCos(this.sin, this.vastaus, this.kerroinvalinta, this.sisafunktionKerroinvalinta);
        lisaaNappi(piirtorivi, piirra, piirto);

    }
}
