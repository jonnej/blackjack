package blackjack.data;

public class Player {

    private String name;
    private double money;
    private int handValue;

    public Player(String name, double money) {
        this.name = name;
        this.money = money;
        this.handValue = 0;
    }

    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }

    public void addMoney(int winAmount) {
        if (winAmount < 0) {
            return;
        }
        money += winAmount;
    }

    public void removeMoney(int betAmount) {
        if (betAmount < 0 || money < betAmount) {
            return;
        }
        money -= betAmount;
    }

    public int getHandValue() {
        return handValue;
    }
    
    public void setHandValueZero() {
        handValue = 0;
    }

    public void addToHandValue(Card card) {
        handValue += card.getValue();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return this.name + ", rahaa " + this.money;
    }

}
