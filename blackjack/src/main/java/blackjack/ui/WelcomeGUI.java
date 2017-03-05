/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import javax.swing.*;
import javax.swing.text.NumberFormatter;

/**
 * Class creates WelcomeGUI object, which is used to ask player's name and
 * money.
 *
 * @author joju
 */
public class WelcomeGUI implements Runnable {

    private JFrame frame;

    private JTextArea wlcText;
    private JTextField addName;
    private JFormattedTextField addMoney;

    private JLabel name;
    private JLabel money;

    private JButton ok;
    private JButton clearFields;
    private JButton exit;
    private GameGUI gameGui;

    /**
     * Initializes all needed components.
     */
    public WelcomeGUI() {
        wlcText = new JTextArea();
        addName = new JTextField();

        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setMaximum(999);
        formatter.setAllowsInvalid(false);
        formatter.setCommitsOnValidEdit(true);
        addMoney = new JFormattedTextField(formatter);

        name = new JLabel("Nimimerkki:");
        money = new JLabel("Rahaa:");

        ok = new JButton("OK");
        clearFields = new JButton("Nollaa");
        exit = new JButton("Exit");

    }

    /**
     * Method adds components to frame.
     *
     * @param c given frame
     */
    public void initComponents(Container c) {
        c.setLayout(null);
        c.setBackground(Color.white);

        wlcText.setFont(new Font("default", Font.BOLD, 16));
        wlcText.setText("Tervetuloa pelaamaan blackjackia! \n Syöttäkää nimenne ja rahamäärä (Max 999). \n Tämän jälkeen painakaa OK");
        wlcText.setBounds(135, 50, 350, 125);
        wlcText.setEnabled(false);
        c.add(wlcText);

        addName.setBounds(150, 190, 200, 30);
        addMoney.setBounds(150, 230, 200, 30);
        addMoney.setText("0");

        name.setBounds(65, 188, 90, 30);
        money.setBounds(65, 228, 70, 30);

        ok.setBounds(150, 270, 80, 30);
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double moneyFieldValue = Double.parseDouble(addMoney.getText().trim());
                String nameFieldText = addName.getText();
                if (moneyFieldValue == 0 || nameFieldText.equals("")) {
                    JOptionPane.showMessageDialog(frame, "Nimi ei voi olla tyhjä ja rahamäärä pitää olla enemmän kuin 0!");
                    addName.setText("");
                    addMoney.setText("0");
                } else {
                    gameGui = new GameGUI(nameFieldText, moneyFieldValue);
                    gameGui.run();
                    frame.setVisible(false);
                }
            }
        }
        );
        clearFields.setBounds(235, 270, 80, 30);
        clearFields.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addName.setText("");
                addMoney.setText("0");
            }
        });

        exit.setBounds(500, 310, 80, 30);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        }
        );

        c.add(addName);
        c.add(addMoney);
        c.add(name);
        c.add(money);
        c.add(ok);
        c.add(clearFields);
        c.add(exit);

    }

    @Override
    public void run() {
        frame = new JFrame("Tervetuloa pelaamaan Blackjackia");
        frame.setPreferredSize(new Dimension(600, 400));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        initComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

}
