/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.ui;

import blackjack.data.Card;
import blackjack.data.Hand;
import blackjack.data.Player;
import blackjack.logiikka.Betting;
import blackjack.logiikka.Dealer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 * Class creates GameGUI frame and it's components for blackjack game.
 *
 * @author joju
 */
public class GameGUI implements Runnable {

//    private UiCommands uic;
    private UicBetting uicBet;
    private UicDealing uicDeal;
    private UicConclusion uicConc;

    private JFrame frame;
    private JPanel jt;
    private JPanel jk;
    private JPanel pt;
    private JPanel pk;

    private JButton hit;
    private JButton stay;
    private JButton dubbel;

    private JButton betOne;
    private JButton betFive;
    private JButton betToZero;
    private JButton startGame;

    private JLabel plCards;
    private JLabel plMoney;

    private JLabel gameAction;
    private JLabel betNow;
    private JLabel bets;
    private JLabel insurance;

    private JLabel dlCards;

    private JLabel newGame;
    private JButton yesBut;
    private JButton noBut;

    private Player player;
    private Player casino;
    private Dealer dealer;
    private Betting betting;

    private JButton[] betButtons;
    private JButton[] gameButtons;
    private JButton[] newGameButtons;

    /**
     * Constructor initializes needed components.
     *
     * @param name User gives name in WelcomeGUI window
     * @param money User gives money in WelcomeGUI window
     */
    public GameGUI(String name, double money) {
//        uic = new UiCommands();
        uicBet = new UicBetting();
        uicDeal = new UicDealing();
        uicConc = new UicConclusion();

        jt = new JPanel();
        jk = new JPanel();
        pt = new JPanel();
        pk = new JPanel();

        hit = new JButton("Ota");
        stay = new JButton("Jää");
        dubbel = new JButton("Tuplaa");

        newGame = new JLabel("Haluatko uuden pelin?");
        yesBut = new JButton("Kyllä");
        noBut = new JButton("Ei");

        betOne = new JButton("1");
        betFive = new JButton("5");
        betToZero = new JButton("Nollaa panos");
        startGame = new JButton("Aloita peli");

        plCards = new JLabel("Pelaajan korttien summa: 0");
        plMoney = new JLabel("Pelaajalla rahaa: ");
        betNow = new JLabel("Panos: 0");
        gameAction = new JLabel("Toiminta");
        bets = new JLabel("Aseta panos");
        insurance = new JLabel("Vakuutus: Ei");

        dlCards = new JLabel("Jakajan korttien summa: 0");

        player = new Player(name, money);
        casino = new Player("casino", 1000);
        betting = new Betting();
        dealer = new Dealer("Jonne");
        dealer.createDeck();

        betButtons = new JButton[]{betOne, betFive, betToZero};
        gameButtons = new JButton[]{hit, stay, dubbel};

    }

    /**
     * Method adds components to frame.
     *
     * @param c
     */
    public void initComponents(Container c) {
        c.setLayout(new GridLayout(4, 1));
        componentsForPlayerInfoPanel();
        componentsForDealerInfoPanel();
        componentsForPlayerCardPanel();
        componentsForDealerCardPanel();

        setAllTexts();
        uicDeal.startBetting(player, casino, dealer, betting);

        c.add(jt);
        c.add(jk);
        c.add(pk);
        c.add(pt);

    }

    /**
     * Method adds components to and makes wanted changes in PlayerCardPanel,
     * pk.
     */
    public void componentsForPlayerCardPanel() {
        pk.setLayout(new FlowLayout());
        pk.setBackground(Color.WHITE);

    }

    /**
     * Method adds components to and makes wanted changes in DealerCardPanel,
     * jk.
     */
    public void componentsForDealerCardPanel() {
        jk.setLayout(new FlowLayout());
        jk.setBackground(Color.WHITE);

    }

    /**
     * Method adds components to and makes wanted changes in DealerInfoPanel,
     * jt.
     */
    public void componentsForDealerInfoPanel() {
        jt.setLayout(null);
        jt.setBackground(Color.red);

        dlCards.setBounds(50, 80, 300, 20);

        jt.add(dlCards);
    }

    /**
     * Method adds components to and makes wanted changes in PlayerInfoPanel,
     * pt.
     */
    public void componentsForPlayerInfoPanel() {
        pt.setLayout(null);
        pt.setBackground(Color.GREEN);

        plCards.setBounds(50, 20, 300, 20);
        plMoney.setBounds(50, 60, 300, 20);
        betNow.setBounds(315, 100, 150, 20);
        insurance.setBounds(430, 100, 150, 20);
        gameAction.setBounds(365, 20, 100, 20);

        hit.setBounds(300, 50, 60, 30);
        hit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dubbel.setEnabled(false);
                uicDeal.addCardImage(player, pk, dealer);
                setAllTexts();
                pk.validate();

                if (!uicConc.checkIfHandValueUnderTwentyTwo(player)) {
                    askForNewGame("Hävisit");
                }
            }
        }
        );

        stay.setBounds(370, 50, 60, 30);
        stay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enableOrDisableButtons(gameButtons, false);
                while (uicDeal.getBiggestValidHandValue(casino) < 17) {
                    uicDeal.addCardImage(casino, jk, dealer);
                    setAllTexts();
                    jk.revalidate();

                }

                askForNewGame(uicConc.checkWinnerAndPayWins(player, casino, betting));
            }
        }
        );

        dubbel.setBounds(
                440, 50, 120, 30);
        dubbel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                uicBet.doubleBet(betting, player);
                uicDeal.addCardImage(player, pk, dealer);
                enableOrDisableButtons(gameButtons, false);
                setAllTexts();
                pk.validate();

                if (!uicConc.checkIfHandValueUnderTwentyTwo(player)) {
                    askForNewGame("Hävisit");
                } else {
                    while (uicDeal.getBiggestValidHandValue(casino) < 17) {
                        uicDeal.addCardImage(casino, jk, dealer);
                        setDealerTxt();
                        jk.validate();
                    }
                    askForNewGame(uicConc.checkWinnerAndPayWins(player, casino, betting));
                }
            }
        }
        );

        bets.setBounds(
                620, 20, 125, 20);

        betOne.setBounds(
                620, 50, 45, 30);
        betOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                uicBet.betMore(betting, 1, player);
                setAllTexts();
            }
        }
        );

        betFive.setBounds(
                670, 50, 45, 30);
        betFive.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                uicBet.betMore(betting, 5, player);
                setAllTexts();
            }
        }
        );

        betToZero.setBounds(
                730, 50, 150, 30);
        betToZero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                uicBet.clearBet(betting, player);
                setAllTexts();
            }
        }
        );

        startGame.setBounds(
                730, 20, 150, 25);
        startGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                uicDeal.addCardImage(player, pk, dealer);
                uicDeal.addCardImage(casino, jk, dealer);
                uicDeal.addCardImage(player, pk, dealer);
                pk.validate();
                jk.validate();
                startGame.setEnabled(false);
                
                if (uicDeal.getBiggestValidHandValue(casino) == 11) {
                    uicBet.askForInsurance(player, betting, frame);
                }

                if (uicConc.handIsBlackJack(player)) {
                    if (uicDeal.getBiggestValidHandValue(casino) >= 10) {
                        uicDeal.addCardImage(casino, jk, dealer);
                        jk.validate();
                    }
                    setAllTexts();
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException ex) {
//                        Logger.getLogger(GameGUI.class.getName()).log(Level.SEVERE, null, ex);
//                    }
                    askForNewGame(uicConc.checkWinnerAndPayWins(player, casino, betting));

                } else {

                    setAllTexts();
                    startGame.setEnabled(false);
                    enableOrDisableButtons(gameButtons, true);
                    enableOrDisableButtons(betButtons, false);
                    if (!uicConc.checkPlayerHasEnoughMoneyToBet(player, uicBet.getBet(betting))) {
                        dubbel.setEnabled(false);
                    }
                }
            }
        }
        );
        startGame.setEnabled(false);

        pt.add(bets);
        pt.add(betOne);
        pt.add(betFive);
        pt.add(betToZero);
        pt.add(startGame);
        pt.add(plCards);
        pt.add(plMoney);
        pt.add(betNow);
        pt.add(insurance);
        pt.add(gameAction);
        pt.add(hit);
        pt.add(stay);
        pt.add(dubbel);
        enableOrDisableButtons(gameButtons, false);
    }

    /**
     * Method sets plCards to show player's current Hand value.
     */
    public void setPlayerTxt() {
        plCards.setText("Pelaajan korttien summa: " + uicDeal.printHandValue(player));
    }

    /**
     * Method sets dlCards to show dealer's current Hand value.
     */
    public void setDealerTxt() {
        dlCards.setText("Jakajan korttien summa: " + uicDeal.printHandValue(casino));
    }

    /**
     * Method sets betNow to show player's current bet and sets button on and
     * off depending the situation.
     */
    public void setBetNowTxt() {
        betNow.setText("Panos: " + uicBet.getBet(betting));
        if (uicBet.getBet(betting) == 0) {
            startGame.setEnabled(false);
            betToZero.setEnabled(false);
        } else {
            startGame.setEnabled(true);
            betToZero.setEnabled(true);
        }
        if (!uicConc.checkPlayerHasEnoughMoneyToBet(player, 1)) {
            betOne.setEnabled(false);
        } else {
            betOne.setEnabled(true);
        }

        if (!uicConc.checkPlayerHasEnoughMoneyToBet(player, 5)) {
            betFive.setEnabled(false);
        } else {
            betFive.setEnabled(true);
        }

    }

    /**
     * Method sets plMoney to show player's current money amount.
     */
    public void setPlayersMoneyTxt() {
        plMoney.setText("Pelaajalla rahaa: " + uicConc.getPlayerMoney(player));
    }
    
    /**
     * Method sets insurance JLabel to show if player has paid insurance for hand.
     */
    public void setPlayersInsuranceTxt() {
        if (player.getInsurance()) {
            insurance.setText("Vakuutus: Kyllä");
        } else {
            insurance.setText("Vakuutus: Ei");
        }
    }

    /**
     * Method calls 4 other methods. Used to refresh situation during game.
     */
    public void setAllTexts() {
        setBetNowTxt();
        setPlayersMoneyTxt();
        setPlayerTxt();
        setDealerTxt();
        setPlayersInsuranceTxt();
    }

    /**
     * Method enables or disables all JButtons in given JButton array.
     *
     * @param jb given JButton array
     * @param b wanted status
     */
    public void enableOrDisableButtons(JButton[] jb, boolean b) {
        for (JButton jbut : jb) {
            jbut.setEnabled(b);
        }
    }

    /**
     * Method creates two different kind of dialog windows. One windows is
     * generated when player's money is 0 and other one when blackjack hand ends
     *
     * @param result depends how game ends, used in dialog window to tell what
     * happened in game
     */
    public void askForNewGame(String result) {
        if (!uicConc.checkPlayerHasEnoughMoneyToBet(player, 1)) {
            JOptionPane.showMessageDialog(frame, result + ". Rahanne loppuivat. Kiitos pelaamisesta!");
            System.exit(0);
        } else {
            JDialog.setDefaultLookAndFeelDecorated(true);
            int response = JOptionPane.showConfirmDialog(null, result + ", haluatko uuden pelin?", "Confirm",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(frame, "Kiitos pelaamisesta! Rahaa teille jäi: " + uicConc.getPlayerMoney(player));
                System.exit(0);
            } else if (response == JOptionPane.YES_OPTION) {
                pk.removeAll();
                pk.validate();
                pk.repaint();
                jk.removeAll();
                jk.validate();
                jk.repaint();
                uicBet.setBetToZero(betting);
                uicDeal.startBetting(player, casino, dealer, betting);
                setAllTexts();
                enableOrDisableButtons(betButtons, true);
                enableOrDisableButtons(gameButtons, false);
            } else if (response == JOptionPane.CLOSED_OPTION) {
                JOptionPane.showMessageDialog(frame, "Kiitos pelaamisesta! Rahaa teille jäi: " + uicConc.getPlayerMoney(player));
                System.exit(0);
            }
        }
    }

    @Override
    public void run() {
        frame = new JFrame("Blackjack");
        frame.setPreferredSize(new Dimension(900, 600));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        initComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }
}
