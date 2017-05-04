/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opetusohjelma.kayttoliittyma.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import opetusohjelma.kayttoliittyma.controller.Arpoja;
import opetusohjelma.kayttoliittyma.controller.BackNapinKuuntelija;
import opetusohjelma.kayttoliittyma.controller.NewAssignmentNapinKuuntelija;
import opetusohjelma.kayttoliittyma.controller.ShowSolutionNapinKuuntelija;

/**
 * Tämä luokka toteuttaa toiminnallisuuden, kun käyttäjä valitsee, että kone
 * arpoo hänelle tehtävänannon.
 *
 * @author Iisa
 */
public class KoneValitseeGUI implements Runnable {

    private JFrame mainFrame;
    private JLabel tehtavarivi;
    private ArrayList<String> funktioJaVastaus;
    private ShowSolutionNapinKuuntelija vastauskuulija;

    /**
     * Konstruktori KoneValitseeGUI:lle.
     */
    public KoneValitseeGUI() {
        prepareGUI();
    }

    /**
     * Pääkehys alustetaan.
     */
    public void prepareGUI() {
        mainFrame = new JFrame("Integration and differentiation");
        mainFrame.setSize(500, 500);
        mainFrame.setLayout(new GridLayout(5, 1));

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        mainFrame.setVisible(true);
    }

    /**
     * Luodaan näkymän napit ja tekstikentät ja lisätään ne pääkehykseen.
     */
    @Override
    public void run() {

        Arpoja arpoja = new Arpoja();

        String toiminto = arpoja.arvoToiminta();

        this.funktioJaVastaus = arpoja.arvoFunktioJaVastaukset(arpoja.arvoFunktio());

        tehtavanantorivinAsetus(toiminto, arpoja);

        JTextField vastaus = new JTextField();

        vastaus.setHorizontalAlignment(JTextField.CENTER);

        showSolutionNapinAsetus(vastaus, toiminto);

        answerIsRivinAsetus();

        vastausrivinAsetus(vastaus);

        newAssignmentRivinAsetus();

    }

    public ArrayList<String> getFunktioJaVastaus() {
        return this.funktioJaVastaus;
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
     * Metodi luo tehtävänantorivin näkymään.
     *
     * @param toiminto String
     * @param arpoja Arpoja
     */
    public void tehtavanantorivinAsetus(String toiminto, Arpoja arpoja) {
        tehtavarivi = new JLabel("", JLabel.CENTER);
        mainFrame.add(tehtavarivi);
        String funktio = funktioJaVastaus.get(0);
        String tehtava = arpoja.tulostaTehtava(toiminto, funktio);
        tehtavarivi.setText(tehtava);
    }

    /**
     * Metodi luo "Show the solution" -napin.
     *
     * @param vastaus JTextField
     * @param komento String
     */
    public void showSolutionNapinAsetus(JTextField vastaus, String komento) {
        JPanel naytaRatkaisuRivi = new JPanel();
        naytaRatkaisuRivi.setLayout(new FlowLayout());
        mainFrame.add(naytaRatkaisuRivi);
        JButton vastausnappi = new JButton("Show the solution");
        this.vastauskuulija = new ShowSolutionNapinKuuntelija(vastaus, funktioJaVastaus, komento);
        lisaaNappi(naytaRatkaisuRivi, vastausnappi, vastauskuulija);
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
     * Metodi luo vastausrivin.
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
     * Metodi luo "Back" ja "New assignment"-napit.
     */
    public void newAssignmentRivinAsetus() {
        JPanel uusiTehtavaRivi = new JPanel();
        mainFrame.add(uusiTehtavaRivi);
        JButton takaisin = new JButton("Back");
        BackNapinKuuntelija kuulija = new BackNapinKuuntelija(mainFrame);
        lisaaNappi(uusiTehtavaRivi, takaisin, kuulija);

        JButton uusiTehtavaNappi = new JButton();
        GridLayout layout = new GridLayout(2, 1);
        uusiTehtavaNappi.setLayout(layout);
        uusiTehtavaNappi.setBackground(Color.CYAN);
        uusiTehtavaNappi.add(new JLabel("New", JLabel.CENTER));
        uusiTehtavaNappi.add(new JLabel("assignment", JLabel.CENTER));
        NewAssignmentNapinKuuntelija kuuntelija = new NewAssignmentNapinKuuntelija(this.tehtavarivi, this.funktioJaVastaus, this.vastauskuulija);
        lisaaNappi(uusiTehtavaRivi, uusiTehtavaNappi, kuuntelija);
    }
}
