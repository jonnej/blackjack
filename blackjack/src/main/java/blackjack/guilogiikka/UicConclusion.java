/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.guilogiikka;

import blackjack.data.Player;
import blackjack.logiikka.Betting;

/**
 * Class had methods for GUI to check conclusion of game and do stuff depending
 * on who wins.
 *
 * @author joju
 */
public class UicConclusion {

    public void UicConclusion() {

    }

    /**
     * Method checks if player has at least given amount of money.
     *
     * @param p user player
     * @param limit needed amount of money
     * @return boolean
     */
    public boolean checkPlayerHasEnoughMoneyToBet(Player p, int limit) {
        return p.getMoney() >= limit;
    }

    /**
     * Method checks if player's hand value lower than 22.
     *
     * @param p both user or casino can be used.
     * @return boolean
     */
    public boolean checkIfHandValueUnderTwentyTwo(Player p) {
        return p.getHand().getHandValue() < 22;
    }

    /**
     * Method checks if p's hand is blackjack.
     *
     * @param p given player
     * @return boolean
     */
    public boolean handIsBlackJack(Player p) {
        return p.getHand().getHandValueWithAce() == 21 && p.getHand().getDealtCards().size() == 2;
    }

    /**
     * Method checks who wins.
     *
     * @param p user player
     * @param c casino player
     * @return boolean
     */
    public boolean playerWins(Player p, Player c) {
        return p.getHand().getHighestValidHand() > c.getHand().getHighestValidHand();
    }

    /**
     * Method checks if game is draw.
     *
     * @param p user player
     * @param c casino player
     * @return boolean
     */
    public boolean gameIsDraw(Player p, Player c) {
        return p.getHand().getHighestValidHand() == c.getHand().getHighestValidHand();
    }

    /**
     * Method checks for winner, makes pays and return result of game.
     *
     * @param p user player
     * @param c casino player
     * @param b used betting object
     * @return result of game
     */
    public String checkWinnerAndPayWins(Player p, Player c, Betting b) {
        if (handIsBlackJack(c)) {
            if (handIsBlackJack(p)) {
                payWins(p, c, b);
                return "Kummallakin blackjack. Tasapeli";
            } else {
                if (p.getInsurance()) {
                    payWins(p, c, b);
                }
                return "Jakajalla on Blackjack. Hävisit";
            }
        }

        if (!checkIfHandValueUnderTwentyTwo(c)) {
            payWins(p, c, b);
            return "Voitit";
        }
        if (playerWins(p, c)) {
            payWins(p, c, b);
            if (handIsBlackJack(p)) {
                return "BlackJack! Voitit";
            }
            return "Voitit";
        }

        if (gameIsDraw(p, c)) {
            payWins(p, c, b);
            return "Tasapeli";
        }

        return "Hävisit";

    }

    /**
     * Method adds wins to player depending of result of the game.
     *
     * @param p user player
     * @param c casino player
     * @param b used betting object
     */
    public void payWins(Player p, Player c, Betting b) {
        if (p.getInsurance() && gameIsDraw(p, c) && handIsBlackJack(c)) {
            p.addMoney(b.getBet() * 2);
        } else if (p.getInsurance() && !playerWins(p, c) && handIsBlackJack(c)) {
            p.addMoney(b.getInsurance() * 3);
        } else if (gameIsDraw(p, c)) {
            p.addMoney(b.getBet());
        } else if (handIsBlackJack(p) && !handIsBlackJack(c)) {
            p.addMoney(b.getBet() * 2.5);
        } else if (gameIsDraw(p, c)) {
            p.addMoney(b.getBet());
        } else {
            p.addMoney(b.getBet() * 2);
        }

    }

    /**
     * Method return given player's money amount.
     *
     * @param p
     * @see blackjack.data.Player#getMoney()
     * @return player's money total
     */
    public double getPlayerMoney(Player p) {
        return p.getMoney();
    }

}
