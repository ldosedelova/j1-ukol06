package cz.czechitas.ukol6;


import com.formdev.flatlaf.FlatLightLaf;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Aplikace extends JFrame {
    private JLabel husyLabel;
    private JLabel kraliciLabel;
    private JLabel pocetHlavLabel;
    private JLabel pocetNohouLabel;

    private JTextField husyField;
    private JTextField kraliciField;
    private JTextField pocetHlavField;
    private JTextField pocetNohouField;

    private JButton vypocitatButton;

    public static void main(String[] args) {
        FlatLightLaf.setup();
        new Aplikace().start();
    }

    public Aplikace() throws HeadlessException {
        super("Farmářka 1.0");
        this.init();
    }

    public void start() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(Aplikace.class.getResource("czechitas-icon.png")).getImage());
        setLayout(new MigLayout("wrap 2", "[right]rel[50:120:150,grow,fill]"));
        setMinimumSize(new Dimension(250, 200));

        husyField = new JTextField();
        husyField.setHorizontalAlignment(JTextField.TRAILING);
        husyLabel = new JLabel("Husy");
        husyLabel.setDisplayedMnemonic('H');
        husyLabel.setLabelFor(husyField);
        add(husyLabel);
        add(husyField);

        kraliciField = new JTextField();
        kraliciField.setHorizontalAlignment(JTextField.TRAILING);
        kraliciLabel = new JLabel("Králíci");
        kraliciLabel.setDisplayedMnemonic('K');
        kraliciLabel.setLabelFor(kraliciField);
        add(kraliciLabel);
        add(kraliciField);

        add(createButtonBar(),"center, span");

        pocetHlavField = new JTextField();
        pocetHlavField.setHorizontalAlignment(JTextField.TRAILING);
        pocetHlavLabel = new JLabel("Počet hlav");
        pocetHlavLabel.setDisplayedMnemonic('P');
        pocetHlavLabel.setLabelFor(pocetHlavField);
        add(pocetHlavLabel);
        add(pocetHlavField);
        pocetHlavField.setEditable(false);

        pocetNohouField = new JTextField();
        pocetNohouField.setHorizontalAlignment(JTextField.TRAILING);
        pocetNohouLabel = new JLabel("Počet nohou");
        pocetNohouLabel.setDisplayedMnemonic('P');
        pocetNohouLabel.setLabelFor(pocetHlavField);
        add(pocetNohouLabel);
        add(pocetNohouField);
        pocetNohouField.setEditable(false);

        vypocitatButton.addActionListener(this::handlevypocitat);

        pack();

        getRootPane().setDefaultButton(vypocitatButton);
    }

    private JPanel createButtonBar() {
        vypocitatButton = new JButton("Vypočítat");
        vypocitatButton.setMnemonic('V');

        JPanel buttonBar = new JPanel();
        buttonBar.add(vypocitatButton);
        return buttonBar;
    }

    private void handlevypocitat(ActionEvent actionEvent) {
        String husy = husyField.getText();
        int husyPocet = Integer.parseInt(husy);

        String kralici = kraliciField.getText();
        int kraliciPocet = Integer.parseInt(kralici);

        int vypocetHlavPocet = husyPocet + kraliciPocet;
        int vypocetNohouPocet = (husyPocet * 2) + (kraliciPocet * 4);
        String vypoceHlav = Integer.toString(vypocetHlavPocet);
        String vypocetNohou = Integer.toString(vypocetNohouPocet);

        pocetHlavField.setText(vypoceHlav);
        pocetNohouField.setText(vypocetNohou);
    }

}
