package blackjack.data;

import java.util.*;

/**
 * Class makes Player objects for blackjack program. Class is used to create
 * both player playing game and "dealer", which players are playing against.
 *
 * @author joju
 */
public class Player {

    private String name;
    private double money;
    private Hand hand;
//    private int handValue;
//    private int handValueWithAce;
//    private List<Card> dealtCards;

    /**
     * Constructor initializes Player object and it's attributes.
     *
     * @param name user gives name
     * @param money user gives starting money
     */
    public Player(String name, double money, Hand hand) {
        this.name = name;
        this.money = money;
        this.hand = hand;
//        this.handValue = 0;
//        this.handValueWithAce = 0;

//        this.dealtCards = new ArrayList();
    }

    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }
    
    public Hand getHand() {
        return hand;
    }

//    public List getDealtCards() {
//        return dealtCards;
//    }

    /**
     * Method adds money to players money balance.
     *
     * @param winAmount depends on result of game
     */
    public void addMoney(double winAmount) {
        if (winAmount >= 0) {
            money += winAmount;
        }
    }

    /**
     * Method removes money from players money balance.
     *
     * @param betAmount user input
     */
    public void removeMoney(double betAmount) {
        if (money >= betAmount && betAmount > 0) {
            money -= betAmount;
        }
    }

//    public int getHandValue() {
//        return handValue;
//    }
//
//    public int getHandValueWithAce() {
//        return handValueWithAce;
//    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    /**
     * Method adds card to players dealtCards list and sums cards value to
     * handValue and handValueWithAce.
     *
     * @param c card dealt to player in game
     */
//    public void addCard(Card c) {
//        dealtCards.add(c);
//        handValue += c.getValue();
//        if (handValueWithAce + c.getValue() > 21) {
//            handValueWithAce = handValue;
//        } else if (c.getName().equals("A") && handValueWithAce < 11) {
//            handValueWithAce += 11;
//        } else {
//            handValueWithAce += c.getValue();
//        }
//    }

//    /**
//     * Method returns biggest valid hand value using Math.max method.
//     *
//     * @return highest hand value of two choices
//     */
//    public int getHighestValidHand() {
//        int h1 = handValue;
//        int h2 = handValueWithAce;
//
//        return Math.max(h1, h2);
//    }

//    /**
//     * Method clears player's dealtCards list and sets handValue to zero.
//     */
//    public void clearDealtCardsAndHandValueToZero() {
////        dealtCards.clear();
//        handValue = 0;
//        handValueWithAce = 0;
//    }

    @Override
    public String toString() {
        return this.name + ", rahaa " + this.money;
    }

}
