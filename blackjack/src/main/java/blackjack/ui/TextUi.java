/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.ui;

import java.util.*;
import blackjack.data.*;
import blackjack.logiikka.*;

/**
 *
 * @author joju
 */
public class TextUi {

    private Scanner lukija;

    public TextUi() {
        this.lukija = new Scanner(System.in);
    }

    // Tekstikäyttöliittymä toimii oikein tällä hetkellä vain yhdellä pelaajan kädellä kerrallaan ja metodia ei ole optimoitu
    public void start() {
        System.out.println("Tervetuloa pelaamaan Blackjackia!");
        System.out.println("Antakaa nimenne: ");
        String name = lukija.nextLine();
        System.out.println("Antakaa aloitusmerkkimäärä: ");
        int rahaa = Integer.parseInt(lukija.nextLine());
        Player player = new Player(name, rahaa);
        Casino casino = new Casino();
        Betting betting = new Betting();
        Dealer dealer = new Dealer("Jonne");
        System.out.println("Tervetuloa peliin " + player.getName() + "!");
        System.out.println("Jakajana toimii " + dealer.getName());
        while (true) {
            System.out.println("Antakaa panoksenne: ");
            int bet = Integer.parseInt(lukija.nextLine());
            while (bet > player.getMoney()) {
                System.out.println("Panos liian suuri! Nykyinen saldonne: " + player.getMoney() + ". Antakaa uusi panos: ");
                bet = Integer.parseInt(lukija.nextLine());
            }

            betting.setBet(bet);
            int i = 0;
            System.out.println("Jako alkaa!");
            player.removeMoney(bet);
            dealer.shuffleDeck();
            dealer.shuffleDeck();
            dealer.shuffleDeck();

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
                System.out.println("Haluatko pelata uuden jaon? joo aloittaa uuden jaon, muut ei");
                String uusiJako = lukija.nextLine();
                if (uusiJako.equals("joo")) {

                    continue;
                } else {
                    break;
                }
                
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
                player.addMoney(bet * 2);
            } else if (player.getHandValue() == casino.getHandValue()) {
                System.out.println("Tasapeli!");
                player.addMoney(bet);
            } else {
                System.out.println("Hävisit!");
            }
            player.clearDealtCardsAndHandValueToZero();
            casino.clearDealtCardsAndHandValueToZero();

            System.out.println("Haluatko pelata uuden jaon? joo aloittaa uuden jaon, muut ei");
            String uusiJako = lukija.nextLine();
            if (uusiJako.equals("joo")) {

                continue;
            } else {
                break;
            }

        }

        System.out.println("Peli päättyi! Tuloksenne on: " + player);

    }
}
