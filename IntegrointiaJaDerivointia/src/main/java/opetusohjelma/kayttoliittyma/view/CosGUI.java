/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opetusohjelma.kayttoliittyma.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import opetusohjelma.kayttoliittyma.controller.BackNapinKuuntelija;
import opetusohjelma.kayttoliittyma.controller.DifferentiateKuuntelijaSinCos;
import opetusohjelma.kayttoliittyma.controller.DrawKuuntelijaSinCos;
import opetusohjelma.kayttoliittyma.controller.IntegrateKuuntelijaSinCos;
import opetusohjelma.kayttoliittyma.controller.SinCosShowTheFunctionKuuntelija;
import opetusohjelma.laskutoimituksia.Polynomi;
import opetusohjelma.laskutoimituksia.SinCos;

/**
 * Tämä luokka toteuttaa näkymän, kun opiskelija valitsee "Cosine".
 *
 * @author Iisa
 */
public class CosGUI implements Runnable {

    private JFrame mainFrame;
    private JPanel textPanel;
    private JTextField funktio;
    private JTextField vastaus;
    private JTextField vastaus1;
    private JTextField vastaus2;
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
     * Metodi luo "Valitse kerroin" -rivin.
     */
    public void valitseKerroin() {
        JPanel coeffPanel = new JPanel();
        textPanel = new JPanel();
        BoxLayout layout = new BoxLayout(textPanel, BoxLayout.Y_AXIS);
        textPanel.add(new JLabel("Choose the coefficient of Cos"));
        textPanel.add(new JLabel("(decimal number):"));
        coeffPanel.setLayout(new GridLayout(1, 2));
        vastaus1 = new JTextField();
        coeffPanel.add(textPanel);
        coeffPanel.add(vastaus1);
        mainFrame.add(coeffPanel);
    }

    /**
     * Metodi luo "Valitse sisäfunktion kerroin" -rivin.
     */
    public void valitseSisafunktionKerroin() {
        JPanel incePanel = new JPanel();
        textPanel = new JPanel();
        BoxLayout layout = new BoxLayout(textPanel, BoxLayout.Y_AXIS);
        textPanel.add(new JLabel("Choose the coefficient of x"));
        textPanel.add(new JLabel("(decimal number):"));
        incePanel.setLayout(new GridLayout(1, 2));
        vastaus2 = new JTextField();
        incePanel.add(textPanel);
        incePanel.add(vastaus2);
        mainFrame.add(incePanel);
    }

    /**
     * Metodi luo "Show the function" -napin.
     */
    public void lisaaNaytaFunktioNappi() {
        JPanel showPanel = new JPanel();
        mainFrame.add(showPanel);
        JButton nappi1 = new JButton("Show the function");
        SinCosShowTheFunctionKuuntelija kuulija = new SinCosShowTheFunctionKuuntelija(funktio, vastaus1, vastaus2, cos);
        nappi1.addActionListener(kuulija);
        showPanel.add(nappi1);
    }

    /**
     * Metodi luo tekstikentän, jossa funktio näytetään.
     *
     * @param funktio JTextField
     */
    public void funktiorivinAsetus(JTextField funktio) {
        JPanel functionPanel = new JPanel();
        functionPanel.setLayout(new GridLayout());
        functionPanel.add(funktio);
        mainFrame.add(functionPanel);
    }

    /**
     * Metodi luo "Integrate"- ja "Differentiate"-näppäinrivin.
     */
    public void integrateDerivateButtons() {
        JPanel intderPanel = new JPanel();
        JButton integButton = new JButton("Integrate");
        integButton.setBackground(Color.cyan);
        IntegrateKuuntelijaSinCos intKuulija = new IntegrateKuuntelijaSinCos(cos, vastaus, vastaus1, vastaus2);
        integButton.addActionListener(intKuulija);
        intderPanel.add(integButton);
        JButton diffButton = new JButton("Differentiate");
        diffButton.setBackground(Color.cyan);
        DifferentiateKuuntelijaSinCos diffKuulija = new DifferentiateKuuntelijaSinCos(cos, vastaus, vastaus1, vastaus2);
        diffButton.addActionListener(diffKuulija);
        intderPanel.add(diffButton);
        mainFrame.add(intderPanel);
    }

    /**
     * Metodi luo vastausrivin.
     */
    public void answerIsRivinAsetus() {
        JLabel answerIsLabel = new JLabel("", JLabel.CENTER);
        mainFrame.add(answerIsLabel);
        answerIsLabel.setText("Answer is:");
    }

    /**
     * Metodi luo tekstikentän, jossa funktio näytetään.
     *
     * @param vastaus JTextField
     */
    public void vastausrivinAsetus(JTextField vastaus) {
        JPanel answerPanel = new JPanel();
        answerPanel.setLayout(new GridLayout());
        answerPanel.add(vastaus);
        mainFrame.add(answerPanel);
    }

    /**
     * Metodi luo "Back"- ja "Draw the solution" -napit.
     */
    public void piirtoYmsNapinAsetus() {
        JPanel drawPanel = new JPanel();
        mainFrame.add(drawPanel);
        JButton back = new JButton("Back");
        BackNapinKuuntelija kuulija = new BackNapinKuuntelija(mainFrame);
        back.addActionListener(kuulija);
        drawPanel.add(back);
        JButton draw = new JButton("Draw the solution");
        DrawKuuntelijaSinCos piirto = new DrawKuuntelijaSinCos(this.cos, this.vastaus, this.vastaus1, this.vastaus2);
        draw.addActionListener(piirto);
        drawPanel.add(draw);
    }

}
