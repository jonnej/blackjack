/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.guilogiikka;

import blackjack.data.Player;
import blackjack.logiikka.Betting;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Class has methods for GUI betting buttons.
 * @author joju
 */
public class UicBetting {

    public UicBetting() {

    }

    /**
     * Method increased bet by amount and takes money from player's money.
     *
     * @param b used betting object
     * @param amount wanted bet amount
     * @param p player(user) betting
     * @see blackjack.data.Player#removeMoney(double)
     * @see blackjack.logiikka.Betting#bet(int)
     */
    public void betMore(Betting b, int amount, Player p) {
        b.bet(amount);
        p.removeMoney(amount);
    }

    /**
     * Method returns current bet.
     *
     * @param b used betting object
     * @see blackjack.logiikka.Betting#getBet()
     * @return current bet
     */
    public int getBet(Betting b) {
        return b.getBet();
    }

    /**
     * Method sets bet to zero and adds money to player's total money. Used when
     * player is betting.
     *
     * @param b used betting object
     * @param p given player (usually user)
     * @see blackjack.data.Player#addMoney(double)
     * @see blackjack.logiikka.Betting#setBet(int)
     */
    public void clearBet(Betting b, Player p) {
        p.addMoney(b.getBet());
        b.setBet(0);
    }

    /**
     * Method only sets bet to zero. Used after player wants to play again.
     *
     * @param b used betting object
     * @see blackjack.logiikka.Betting#setBet(int i)
     */
    public void setBetToZero(Betting b) {
        b.setBet(0);
    }
    
    /**
     * Method removes money from player and doubles bet after that.
     *
     * @param b used betting object
     * @param p player playing
     */
    public void doubleBet(Betting b, Player p) {
        p.removeMoney(b.getBet());
        b.doubleBet();
    }
    
        public void askForInsurance(Player p, Betting b, JFrame frame) {
        int response = JOptionPane.showConfirmDialog(null, "Haluatko vakuutuksen?", "Confirm",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.NO_OPTION) {

        } else if (response == JOptionPane.YES_OPTION) {
            b.setInsurance();
            p.removeMoney(b.getInsurance());
            p.setInsurance(true);
        } else if (response == JOptionPane.CLOSED_OPTION) {

        }
    }
    
}
