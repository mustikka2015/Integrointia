/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opetusohjelma.kayttoliittyma.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import opetusohjelma.kayttoliittyma.controller.BackNapinKuuntelija;
import opetusohjelma.kayttoliittyma.controller.DifferentiateNapinKuuntelijaSinCos;
import opetusohjelma.kayttoliittyma.controller.DrawNapinKuuntelijaSinCos;
import opetusohjelma.kayttoliittyma.controller.IntegrateNapinKuuntelijaSinCos;
import opetusohjelma.kayttoliittyma.controller.ShowTheFunctionNapinKuuntelijaSinCosilla;
import opetusohjelma.laskutoimituksia.SinCos;

/**
 * Tämä luokka toteuttaa näkymän, kun opiskelija valitsee "Cosine".
 *
 * @author Iisa
 */
public class CosGUI implements Runnable {

    private JFrame mainFrame;
    private JPanel tekstialusta;
    private JTextField funktio;
    private JTextField vastaus;
    private JTextField kerroin;
    private JTextField sisafunktionKerroin;
    private SinCos cos;

    /**
     * Konstruntori CosGUI:lle.
     */
    public CosGUI() {
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
        this.cos = new SinCos(1.0, 1.0, "cos");
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
     * Metodi luo "Valitse kerroin" -rivin.
     */
    public void valitseKerroin() {
        JPanel kerroinrivi = new JPanel();
        tekstialusta = new JPanel();
        BoxLayout layout = new BoxLayout(tekstialusta, BoxLayout.Y_AXIS);
        tekstialusta.add(new JLabel("Choose the coefficient of Cos"));
        tekstialusta.add(new JLabel("(decimal number):"));
        kerroinrivi.setLayout(new GridLayout(1, 2));
        kerroin = new JTextField();
        kerroinrivi.add(tekstialusta);
        kerroinrivi.add(kerroin);
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
        sisafunktionKerroin = new JTextField();
        sisafunktionKerroinRivi.add(tekstialusta);
        sisafunktionKerroinRivi.add(sisafunktionKerroin);
        mainFrame.add(sisafunktionKerroinRivi);
    }

    /**
     * Metodi luo "Show the function" -napin.
     */
    public void lisaaNaytaFunktioNappi() {
        JPanel naytaFunktioRivi = new JPanel();
        mainFrame.add(naytaFunktioRivi);
        JButton naytaFunktio = new JButton("Show the function");
        ShowTheFunctionNapinKuuntelijaSinCosilla kuulija = new ShowTheFunctionNapinKuuntelijaSinCosilla(funktio, kerroin, sisafunktionKerroin, cos);
        lisaaNappi(naytaFunktioRivi, naytaFunktio, kuulija);
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
     * Metodi luo "Integrate"- ja "Differentiate"-näppäinrivin.
     */
    public void integrateDerivateButtons() {
        JPanel intDerRivi = new JPanel();
        JButton integroi = new JButton("Integrate");
        integroi.setBackground(Color.cyan);
        IntegrateNapinKuuntelijaSinCos intKuulija = new IntegrateNapinKuuntelijaSinCos(cos, vastaus, kerroin, sisafunktionKerroin);
        lisaaNappi(intDerRivi, integroi, intKuulija);
        JButton derivoi = new JButton("Differentiate");
        derivoi.setBackground(Color.cyan);
        DifferentiateNapinKuuntelijaSinCos derivKuulija = new DifferentiateNapinKuuntelijaSinCos(cos, vastaus, kerroin, sisafunktionKerroin);
        lisaaNappi(intDerRivi, derivoi, derivKuulija);
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
        DrawNapinKuuntelijaSinCos piirto = new DrawNapinKuuntelijaSinCos(this.cos, this.vastaus, this.kerroin, this.sisafunktionKerroin);
        lisaaNappi(piirtorivi, piirra, piirto);
    }

}
