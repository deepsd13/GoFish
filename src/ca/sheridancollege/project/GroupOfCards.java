package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Random;

/**
 * A class which generates cards, distrbutes cards and implements the goFish()
 * method
 *
 * @author Deep Shah, August 15,2019
 */
public class GroupOfCards {

    //The group of cards, stored in an ArrayList
    private ArrayList<Card> cards = new ArrayList<>();
    private ArrayList<Card> deck = new ArrayList<>();
    private int size;//the size of the grouping

    public GroupOfCards(int givenSize) {
        size = givenSize;
    }

    public GroupOfCards() {
    }

    public int getSize() {
        return size;
    }

    /**
     * setter for size
     *
     * @param givenSize the max size for the group of cards
     */
    public void setSize(int givenSize) {
        size = givenSize;
    }

    /**
     * getter for deck
     *
     * @return the deck
     */
    public ArrayList<Card> getDeck() {
        return deck;
    }

    /**
     * setter for deck
     *
     * @param deck
     */
    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }

    /**
     * getter for size
     *
     * @return the size of the group of cards
     */
    /**
     * getter for cards
     *
     * @return cards
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    /**
     * setter for cards
     *
     * @param cards
     */
    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    /**
     * Method for getting a specific card
     *
     * @param Index
     * @return
     */
    public Card get(int Index) {

        if (Index <= cards.size()) {
            return cards.get(Index);
        } else {
            return null;
        }
    }

    /**
     * Method for adding a card
     *
     * @param card
     */
    public void add(Card card) {

        cards.add(card);
    }

    /**
     * Method for removing a card
     *
     * @param card
     */
    public void remove(Card card) {

        cards.remove(card);

    }

    /**
     * Method for generating deck
     */
    public void generateDeck() {

        for (Card.Suit s : Card.Suit.values()) {
            for (Card.Value v : Card.Value.values()) {

                Card c = new Card(s, v);
                this.deck.add(c);
            }
        }
    }

    /**
     * Method for distributing cards amongst the players
     *
     * @param player player to which the card is to be distributed
     * @param numCards number of cards to distribute
     */
    public void distributeCards(Player player, int numCards) {

        for (int i = 0; i < numCards; i++) {
            Random rn = new Random();
            //randomly selecting a card from the deck
            int rand = rn.nextInt(deck.size() - 1) + 1;
            player.getHand().add((deck.get(rand))); // adding the card to players hand
            player.getHand().setSize(player.getHand().getSize() + 1); // increasing the size of players hand
            deck.remove(rand);//removing the card from the deck
        }
    }

    /**
     * A method which adds one card to the player hands after they go fishing.
     *
     * @param player
     *
     */
    public void goFish(Player player) {
        if (deck.size() > 0) {
            Random rn = new Random();
            //randomly selecting a card and adding it to players hand
            int rand = rn.nextInt(deck.size() - 1) + 1;
            player.getHand().add(deck.get(rand));
            player.getHand().setSize(player.getHand().getSize() + 1);
            deck.remove(rand);

        } else {
            System.out.println("Oh! There's no card left in the remaining pool!"
                    + " This is last round!\n Get ready to see who wins!!");
        }
    }

}//end class
