//package blackjack.ui;
//
//import blackjack.data.*;
//import blackjack.logiikka.*;
//import blackjack.logiikka.Betting;
//import blackjack.logiikka.Dealer;
//import java.awt.Image;
//import java.util.*;
//import javax.swing.ImageIcon;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//
///**
// * Class has methods for GameGUI.
// *
// * @author joju
// */
public class UiCommands {

    private int position;

    public UiCommands() {
        position = 0;
    }}
//
//    /**
//     * Method return given player's money amount.
//     *
//     * @param p
//     * @see blackjack.data.Player#getMoney()
//     * @return player's money total
//     */
//    public double getPlayerMoney(Player p) {
//        return p.getMoney();
//    }
//
//    /**
//     * Method increased bet by amount and takes money from player's money.
//     *
//     * @param b used betting object
//     * @param amount wanted bet amount
//     * @param p player(user) betting
//     * @see blackjack.data.Player#removeMoney(double)
//     * @see blackjack.logiikka.Betting#bet(int)
//     */
//    public void betMore(Betting b, int amount, Player p) {
//        b.bet(amount);
//        p.removeMoney(amount);
//    }
//
//    /**
//     * Method returns current bet.
//     *
//     * @param b used betting object
//     * @see blackjack.logiikka.Betting#getBet()
//     * @return current bet
//     */
//    public int getBet(Betting b) {
//        return b.getBet();
//    }
//
//    /**
//     * Method sets bet to zero and adds money to player's total money. Used when
//     * player is betting.
//     *
//     * @param b used betting object
//     * @param p given player (usually user)
//     * @see blackjack.data.Player#addMoney(double)
//     * @see blackjack.logiikka.Betting#setBet(int)
//     */
//    public void clearBet(Betting b, Player p) {
//        p.addMoney(b.getBet());
//        b.setBet(0);
//    }
//
//    /**
//     * Method only sets bet to zero. Used after player wants to play again.
//     *
//     * @param b used betting object
//     * @see blackjack.logiikka.Betting#setBet(int)
//     */
//    public void setBetToZero(Betting b) {
//        b.setBet(0);
//    }
//
//    /**
//     * Method removes money from player and doubles bet after that.
//     *
//     * @param b used betting object
//     * @param p player playing
//     */
//    public void doubleBet(Betting b, Player p) {
//        p.removeMoney(b.getBet());
//        b.doubleBet();
//    }
//
//    public void askForInsurance(Player p, Betting b, JFrame frame) {
//        int response = JOptionPane.showConfirmDialog(null, "Haluatko vakuutuksen?", "Confirm",
//                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
//        if (response == JOptionPane.NO_OPTION) {
//
//        } else if (response == JOptionPane.YES_OPTION) {
//            b.setInsurance();
//            p.removeMoney(b.getInsurance());
//            p.setInsurance(true);
//        } else if (response == JOptionPane.CLOSED_OPTION) {
//
//        }
//    }
//
//    public void setPositionZero() {
//        position = 0;
//    }
//
//    /**
//     * Method adds card to given player object. Both player and dealer. Returns
//     * dealt card image icon used to show what has been dealt.
//     *
//     * @param p player dealt card
//     * @param d dealer object dealing cards
//     * @see blackjack.data.Player#addCard(blackjack.data.Card)
//     * @see blackjack.logiikka.Dealer#dealCard(int)
//     * @see blackjack.data.Card#getImageIcon()
//     * @return dealt card's image icon
//     */
//    public ImageIcon dealCard(Player p, Dealer d) {
//        p.getHand().addCard(d.dealCard(position));
//        position++;
//        return getImageIcon(d.dealCard(position - 1));
//    }
//
//    /**
//     * Method returns given player's smallest hand value. Used by both user and
//     * casino player objects.
//     *
//     * @param p given player
//     * @see blackjack.data.Player#handValue
//     * @return player's hand value
//     */
//    public int getHandValue(Player p) {
//        return p.getHand().getHandValue();
//    }
//
//    /**
//     * Method returns hand value with biggest value. Needed because Ace has
//     * value of 1 and 11.
//     *
//     * @param p given player
//     * @see blackjack.data.Player#getHighestValidHand()
//     * @return player's biggest hand value
//     */
//    public int getBiggestValidHandValue(Player p) {
//        return p.getHand().getHighestValidHand();
//    }
//
//    /**
//     * Method used to show current hand values to player. Showing both values
//     * when ace in hand and bigger value less than 22
//     *
//     * @param p given player
//     * @see blackjack.data.Player#handValue#handValueWithAce#
//     * @return hand value using string
//     */
//    public String printHandValue(Player p) {
//        if (p.getHand().getHandValue() != p.getHand().getHandValueWithAce() && p.getHand().getHandValueWithAce() < 22) {
//            return p.getHand().getHandValue() + "/" + p.getHand().getHandValueWithAce();
//        }
//        return "" + p.getHand().getHandValue();
//    }
//
//    /**
//     * Method scales given card's image icon to better size.
//     *
//     * @param c dealt card
//     * @see blackjack.data.Card#getImageIcon()
//     * @return card's image icon resized
//     */
//    public ImageIcon getImageIcon(Card c) {
//        ImageIcon ic = c.getImageIcon(); // load the image to a imageIcon
//        Image image = ic.getImage(); // transform it 
//        Image newimg = image.getScaledInstance(70, 102, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
//        ic = new ImageIcon(newimg);  // transform it back
//        return ic;
//    }
//
//    /**
//     * Method clears hands, sets position counter to zero and shuffles deck 3
//     * times. Used before hand starts
//     *
//     * @param p1 user player
//     * @param p2 casino player
//     * @param d used dealer object
//     * @param b used betting object
//     */
//    public void startBetting(Player p1, Player p2, Dealer d, Betting b) {
//        p1.setInsurance(false);
//        setPositionZero();
//        p1.getHand().clearDealtCardsAndHandValueToZero();
//        p2.getHand().clearDealtCardsAndHandValueToZero();
//        d.shuffleDeckNTimes(3);
//    }
//
//    /**
//     * Method checks if player has at least given amount of money.
//     *
//     * @param p user player
//     * @param limit needed amount of money
//     * @return boolean
//     */
//    public boolean checkPlayerHasEnoughMoneyToBet(Player p, int limit) {
//        return p.getMoney() >= limit;
//    }
//
//    /**
//     * Method checks if player's hand value lower than 22.
//     *
//     * @param p both user or casino can be used.
//     * @return boolean
//     */
//    public boolean checkIfHandValueUnderTwentyTwo(Player p) {
//        return p.getHand().getHandValue() < 22;
//    }
//
//    /**
//     * Method checks if p's hand is blackjack.
//     *
//     * @param p given player
//     * @return boolean
//     */
//    public boolean handIsBlackJack(Player p) {
//        return p.getHand().getHandValueWithAce() == 21 && p.getHand().getDealtCards().size() == 2;
//    }
//
//    /**
//     * Method checks who wins.
//     *
//     * @param p user player
//     * @param c casino player
//     * @return boolean
//     */
//    public boolean playerWins(Player p, Player c) {
//        return p.getHand().getHighestValidHand() > c.getHand().getHighestValidHand();
//    }
//
//    /**
//     * Method checks if game is draw.
//     *
//     * @param p user player
//     * @param c casino player
//     * @return boolean
//     */
//    public boolean gameIsDraw(Player p, Player c) {
//        return p.getHand().getHighestValidHand() == c.getHand().getHighestValidHand();
//    }
//
//    /**
//     * Method checks for winner, makes pays and return result of game.
//     *
//     * @param p user player
//     * @param c casino player
//     * @param b used betting object
//     * @return result of game
//     */
//    public String checkWinnerAndPayWins(Player p, Player c, Betting b) {
//        if (handIsBlackJack(c)) {
//            if (handIsBlackJack(p)) {
//                payWins(p, c, b);
//                return "Tasapeli";
//            } else {
//                payWins(p, c, b);
//                return "Jakajalla on Blackjack";
//            }
//        }
//
//        if (!checkIfHandValueUnderTwentyTwo(c)) {
//            payWins(p, c, b);
//            return "Voitit";
//        }
//        if (playerWins(p, c)) {
//            payWins(p, c, b);
//            if (handIsBlackJack(p)) {
//                return "BlackJack! Voitit";
//            }
//            return "Voitit";
//        }
//
//        if (gameIsDraw(p, c)) {
//            payWins(p, c, b);
//            return "Tasapeli";
//        }
//
//        return "Hävisit";
//
//    }
//
//    /**
//     * Method adds wins to player depending of result of the game.
//     *
//     * @param p user player
//     * @param c casino player
//     * @param b used betting object
//     */
//    public void payWins(Player p, Player c, Betting b) {
//        if (p.getInsurance() && gameIsDraw(p, c) && handIsBlackJack(c)) {
//            p.addMoney(b.getBet() * 2);
//        } else if (p.getInsurance() && !playerWins(p, c) && handIsBlackJack(c)) {
//            p.addMoney(b.getInsurance() * 3);
//        } else if (gameIsDraw(p, c)) {
//            p.addMoney(b.getBet());
//        } else if (handIsBlackJack(p) && !handIsBlackJack(c)) {
//            p.addMoney(b.getBet() * 2.5);
//
//        } else if (gameIsDraw(p, c)) {
//            p.addMoney(b.getBet());
//        } else {
//            p.addMoney(b.getBet() * 2);
//        }
//
//    }
//
//    /**
//     * Method adds card image to given JPanel
//     *
//     * @param p given player
//     * @param jp given player's JPanel
//     * @param d used dealer object
//     */
//    public void addCardImage(Player p, JPanel jp, Dealer d) {
//        JLabel jlabel = new JLabel();
//        ImageIcon ic = dealCard(p, d);
//        jlabel.setIcon(ic);
//        jlabel.setVisible(true);
//        jp.add(jlabel);
//    }
//
//}
