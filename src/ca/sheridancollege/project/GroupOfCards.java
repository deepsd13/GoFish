/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you
 * might want to subclass this more than once. The group of cards has a maximum
 * size attribute which is flexible for reuse.
 *
 * @author dancye
 */
public class GroupOfCards extends Card {

    //The group of cards, stored in an ArrayList
    private ArrayList<Card> cards = new ArrayList<>();
    private static ArrayList<Card> deck = new ArrayList<Card>();
    private int size;//the size of the grouping

    public GroupOfCards(int givenSize, Suit suit, Value value) {
        super(suit, value);
        size = givenSize;
    }

  
    public  ArrayList<Card> generateDeck() {

        for (Suit s : Suit.values()) {
            for (Value v : Value.values()) {

                Card c = new Card(s, v);
                deck.add(c);
            }
        }
        return deck;
    }

    public ArrayList<Card> distributeCards() {

        for (int i = 0; i < 5; i++) {

            Random rn = new Random();
            int rand = rn.nextInt(deck.size()-1) + 1;
            cards.add((deck.get(rand)));
            deck.remove(rand);

        }
        return cards;
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    /**
     * A method that will get the group of cards as an ArrayList
     *
     * @return the group of cards.
     */
    public ArrayList<Card> showCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * @param givenSize the max size for the group of cards
     */
    public void setSize(int givenSize) {
        size = givenSize;
    }

    @Override
    public String toString() {

        return "The remaining cards:" + deck;
    }

}//end class
