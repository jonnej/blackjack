package blackjack.ui;

import blackjack.data.*;
import blackjack.logiikka.*;
import blackjack.logiikka.Betting;
import blackjack.logiikka.Dealer;
import java.util.*;

/**
 * Class has methods for text user interface.
 * @author joju
 */
public class UiCommands {

    private Scanner lukija;
    private Player player;
    private Dealer dealer;
    private Player casino;
    private Betting betting;
    private int position;

    public UiCommands() {
        lukija = new Scanner(System.in);
        position = 0;
    }

    private void welcomeText() {
        System.out.println("Tervetuloa pelaamaan Blackjackia!");
    }
    // welcome uin komentoja, Tällä hetkellä tosin vain pelkän GUIgamen avulla testaamista
    public void initializePlayerAndOtherObjects(String name, double rahaa) {
      player = new Player(name, rahaa);
      casino = new Player("casino", 1000);
      betting = new Betting();
      dealer = new Dealer("Jonne");
      dealer.createDeck();
    }
    
    public double getPlayerMoney() {
        return player.getMoney();
    }


    // game uin komentoja
    public void bet(int amount) {
      betting.bet(amount);
    }

    public int getBet() {
      return betting.getBet();
    }

    public void clearBet() {
      betting.setBet(0);
    }

    public void doubleBet() {
      betting.setBet(betting.getBet());
    }

    public void setPositionZero() {
      position = 0;
    }

    public void dealCard(String str) {
      if (str.equals("player")) {
        player.addCard(dealer.dealCard(position));
      } else {
        casino.addCard(dealer.dealCard(position));
      }
      position++;
    }

    public int getHandValue(String str) {
      if (str.equals("player")) {
        return player.getHandValue();
      } else {
        return casino.getHandValue();
      }
    }

    public void startDealHand() {
      setPositionZero();
      player.removeMoney(betting.getBet());
      dealer.shuffleDeckNTimes(3);
      dealCard("player");
      dealCard("casino");
      dealCard("player");
    }

    private boolean checkPlayerHasEnoughMoney() {
        if (player.getMoney() < 1) {
            System.out.println("Valitettavasti rahanne ei riitä pelaamiseen, tervetuloa uudestaan kunnes teillä on vähintään yksi euro!");
            return false;
        }
        return true;
    }

    private boolean askForNewGame() {
        System.out.println("Haluatko pelata uuden jaon? joo aloittaa, muut ei");
        String uusiJako = lukija.nextLine();
        if (uusiJako.equals("joo")) {

            return true;
        }
        return false;

    }
}
