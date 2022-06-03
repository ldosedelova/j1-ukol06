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

    private JSpinner husySpinner;
    private JSpinner kraliciSpinner;
    private JSpinner pocetHlavSpinner;
    private JSpinner pocetNohouSpinner;

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

        husySpinner = new JSpinner();
        husyLabel = new JLabel("Husy");
        husyLabel.setDisplayedMnemonic('H');
        husyLabel.setLabelFor(husySpinner);
        add(husyLabel);
        add(husySpinner);

        kraliciSpinner = new JSpinner();
        kraliciLabel = new JLabel("Králíci");
        kraliciLabel.setDisplayedMnemonic('K');
        kraliciLabel.setLabelFor(kraliciSpinner);
        add(kraliciLabel);
        add(kraliciSpinner);

        add(createButtonBar(),"center, span");

        pocetHlavSpinner = new JSpinner();
        pocetHlavLabel = new JLabel("Počet hlav");
        pocetHlavLabel.setDisplayedMnemonic('P');
        pocetHlavLabel.setLabelFor(pocetHlavSpinner );
        add(pocetHlavLabel);
        add(pocetHlavSpinner);

        pocetNohouSpinner = new JSpinner();
        pocetNohouLabel = new JLabel("Počet nohou");
        pocetNohouLabel.setDisplayedMnemonic('P');
        pocetNohouLabel.setLabelFor(pocetNohouSpinner);
        add(pocetNohouLabel);
        add(pocetNohouSpinner);

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
        int husy = (Integer) husySpinner.getValue();
        int kralici = (Integer) kraliciSpinner.getValue();

        int vypocetHlavPocet = husy + kralici;
        int vypocetNohouPocet = (husy * 2) + (kralici * 4);

        pocetHlavSpinner.setValue(vypocetHlavPocet);
        pocetNohouSpinner.setValue(vypocetNohouPocet);

    }

}
