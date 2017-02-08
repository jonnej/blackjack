package blackjack.logiikka;

import blackjack.data.*;
import blackjack.logiikka.*;
import java.util.*;


public class UiCommands {

    private Scanner lukija;
    private Player player;
    private Dealer dealer;
    private Player casino;
    private Betting betting;

    public UiCommands() {
        lukija = new Scanner(System.in);
    }

    private void welcomeText() {
        System.out.println("Tervetuloa pelaamaan Blackjackia!");
    }

    private void askNameAndChipsInitializePlayerAndOtherObjects() {
        System.out.println("Antakaa nimenne: ");
        String name = lukija.nextLine();
        System.out.println("Antakaa aloitusmerkkimäärä (kokonaisluku): ");
        int rahaa = Integer.parseInt(lukija.nextLine());
        player = new Player(name, rahaa);
        casino = new Player("casino", 10000);
        betting = new Betting();
        dealer = new Dealer("Jonne");

    }

    public void startGame() {
        welcomeText();
        askNameAndChipsInitializePlayerAndOtherObjects();
        while (true) {
            if (!checkPlayerHasEnoughMoney()) {
                break;
            }
            placeBets();
            dealingHand();
            if (!askForNewGame()) {
                break;
            }

        }
        System.out.println("Peli päättyi! Tuloksenne on: " + player);
    }

    private boolean checkPlayerHasEnoughMoney() {
        if (player.getMoney() < 1) {
            System.out.println("Valitettavasti rahanne ei riitä pelaamiseen, tervetuloa uudestaan kunnes teillä on vähintään yksi euro!");
            return false;
        }
        return true;
    }

    private void placeBets() {
        System.out.println("Antakaa panoksenne: ");
        int bet = Integer.parseInt(lukija.nextLine());
        while (bet > player.getMoney()) {
            System.out.println("Panos liian suuri! Nykyinen saldonne: " + player.getMoney() + ". Antakaa uusi panos: ");
            bet = Integer.parseInt(lukija.nextLine());
        }

        betting.setBet(bet);
    }

    private void dealingHand() {
        System.out.println("Jako alkaa!");
        int i = 0;
        player.removeMoney(betting.getBet());
        dealer.shuffleDeckNTimes(3);

        player.addCard(dealer.dealCard(i));
        i++;
        casino.addCard(dealer.dealCard(i));
        i++;
        player.addCard(dealer.dealCard(i));
        i++;
        System.out.println(player.getName() + ":n käsi ja käden summa: ");
        player.printDealtCards();
        System.out.println("Summa: " + player.getHandValue());
        System.out.println("Jakajan käsi ja käden summa: ");
        casino.printDealtCards();
        System.out.println("Summa: " + casino.getHandValue());

        while (true) {
            Card card = dealer.dealCard(i);
            System.out.println("Kätenne nyt: ");
            player.printDealtCards();
            System.out.println("Summa: " + player.getHandValue());
            System.out.println("Ota kortti, kirjoittamalla ota, muulla syötteellä jäät tähän");
            String command = lukija.nextLine();
            if (command.equals("ota")) {
                player.addCard(card);
                if (player.getHandValue() > 21) {
                    System.out.println("Summa nyt: " + player.getHandValue() + " menitte yli 21, hävisitte");

                    i++;
                    break;
                }
                System.out.println("Summa nyt: " + player.getHandValue());
            } else {
                System.out.println("Summa nyt: " + player.getHandValue());
                break;
            }

            i++;
        }

        if (player.getHandValue() > 21) {
            player.clearDealtCardsAndHandValueToZero();
            casino.clearDealtCardsAndHandValueToZero();
            return;
        } else {
            while (true) {
                Card card = dealer.dealCard(i);
                casino.addCard(card);
                System.out.println("Jakajan kortit ja summa: ");
                casino.printDealtCards();
                System.out.println("Summa: " + casino.getHandValue());
                if (casino.getHandValue() >= 17) {
                    break;
                }
                i++;
            }
        }

        if (player.getHandValue() > casino.getHandValue() || casino.getHandValue() > 21) {
            System.out.println("Voitit jakajan!");
            player.addMoney(betting.getBet() * 2);
        } else if (player.getHandValue() == casino.getHandValue()) {
            System.out.println("Tasapeli!");
            player.addMoney(betting.getBet());
        } else {
            System.out.println("Hävisit!");
        }
        player.clearDealtCardsAndHandValueToZero();
        casino.clearDealtCardsAndHandValueToZero();
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
