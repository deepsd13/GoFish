package ca.sheridancollege.project;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Deep Shah
 */
public class GoFish {

    static Scanner scan = new Scanner(System.in);
    static ArrayList<Card> tablePool = new ArrayList<>();
    static ArrayList<Card> player1Cards;
    static ArrayList<Card> player2Cards;
    static ArrayList<Card> player3Cards;
    static ArrayList<Card> player4Cards;

    public static void main(String[] args) {
        /*
        GroupOfCards player1Hand = new GroupOfCards();
        GroupOfCards player2Hand = new GroupOfCards();
        GroupOfCards player3Hand = new GroupOfCards();
        GroupOfCards player4Hand = new GroupOfCards();

        System.out.println("Welcome! Lets get Started!!");
        ArrayList<Player> players = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            System.out.print("Player" + i + " :\n    Name:");
            String name = scan.nextLine();
            players.add(new Player(name));

        }

        GroupOfCards hands = new GroupOfCards();
        hands.generateDeck();
        player1Cards = player1Hand.distributeCards();
        player2Cards = player2Hand.distributeCards();
        player3Cards = player3Hand.distributeCards();
        player4Cards = player4Hand.distributeCards();

        for (int i = 0; i < player1Cards.size(); i++) {
            System.out.print(player1Cards.get(i).toString());
        }
        System.out.println();
        for (int i = 0; i < player2Cards.size(); i++) {
            System.out.print(player2Cards.get(i).toString());
        }
        System.out.println();
        for (int i = 0; i < player3Cards.size(); i++) {
            System.out.print(player3Cards.get(i).toString());
        }
        System.out.println();
        for (int i = 0; i < player4Cards.size(); i++) {
            System.out.print(player4Cards.get(i).toString());
        }

        for (int i = 0; i < (hands.getDeck().size()); i++) {
            tablePool.add(hands.getDeck().get(0));

        }

        play(player1Cards);
    }

    public static void askCard(ArrayList<Card> userCards, ArrayList<Card> opponentCards, Suit suit) {
        boolean hasAskedCard = false;
        for (int j = 0; j < userCards.size(); j++) {
            if (userCards.get(j).equals(suit)) {
                for (int i = 0; i < opponentCards.size(); i++) {
                    if (opponentCards.get(i).equals(suit)) {
                        opponentCards.remove(i);
                        userCards.add(opponentCards.get(i));
                        hasAskedCard = true;
                    }
                }
                if (hasAskedCard == false) {
                    System.out.println("GoFish");
                    System.out.println("The turn has tranfered to opponent player");
                    play(opponentCards);
                }
                
                play(userCards);

                break;
            }

        }
    }

    public static void play(ArrayList<Card> playerCards) {
        if (tablePool.size() >= 0) {
            System.out.println("\nWhich player do you want to ask?");
            int ask = scan.nextInt();
            System.out.println("Which Card do you want to ask?");
            int askCard = scan.nextInt();
            switch (ask) {

                case 1:
                    switch (askCard) {
                        case 1:
                            askCard(playerCards, player1Cards, Suit.HEARTS);
                            break;
                        case 2:
                            askCard(playerCards, player1Cards, Suit.CLUBS);
                            break;
                        case 3:
                            askCard(playerCards, player1Cards, Suit.DIAMONDS);
                            break;
                        case 4:
                            askCard(playerCards, player1Cards, Suit.SPADES);
                            break;
                    }
                    break;

                case 2:

                    switch (askCard) {
                        case 1:
                            askCard(playerCards, player2Cards, Suit.HEARTS);
                            break;
                        case 2:
                            askCard(playerCards, player2Cards, Suit.CLUBS);
                            break;
                        case 3:
                            askCard(playerCards, player2Cards, Suit.DIAMONDS);
                            break;
                        case 4:
                            askCard(playerCards, player2Cards, Suit.SPADES);
                            break;
                    }
                    break;
                case 3:
                    switch (askCard) {
                        case 1:
                            askCard(playerCards, player3Cards, Suit.HEARTS);
                            break;
                        case 2:
                            askCard(playerCards, player3Cards, Suit.CLUBS);
                            break;
                        case 3:
                            askCard(playerCards, player3Cards, Suit.DIAMONDS);
                            break;
                        case 4:
                            askCard(playerCards, player3Cards, Suit.SPADES);
                            break;
                    }
                    break;
                case 4:
                    switch (askCard) {
                        case 1:
                            askCard(playerCards, player4Cards, Suit.HEARTS);
                            break;
                        case 2:
                            askCard(playerCards, player4Cards, Suit.CLUBS);
                            break;
                        case 3:
                            askCard(playerCards, player4Cards, Suit.DIAMONDS);
                            break;
                        case 4:
                            askCard(playerCards, player4Cards, Suit.SPADES);
                            break;
                    }
                    break;

            }
        }
    }
*/
}
