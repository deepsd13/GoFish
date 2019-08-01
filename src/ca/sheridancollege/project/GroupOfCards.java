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
public class GroupOfCards {

    //The group of cards, stored in an ArrayList
    private ArrayList<Card> cards = new ArrayList<>();
    private ArrayList<Card> deck = new ArrayList<Card>();
    private int size;//the size of the grouping

    public GroupOfCards(int givenSize) {
        size = givenSize;
    }

    public GroupOfCards() {
    }

    public boolean equals(Card card) {
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).equals(card.getValue())) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Card> generateDeck() {

        for (Card.Suit s : Card.Suit.values()) {
            for (Card.Value v : Card.Value.values()) {

                Card c = new Card(s, v);
                deck.add(c);
            }
        }
        return deck;
    }

    public GroupOfCards distributeCards(Player player) {

        for (int i = 0; i < 10; i++) {
            Random rn = new Random();
            int rand = rn.nextInt(deck.size() - 1) + 1;
            player.getHand().add((deck.get(rand)));
            player.getHand().setSize(player.getHand().getSize()+1);
            deck.remove(rand);
        }
        return player.getHand();
    }

    public ArrayList<Card> fish(Player player) {
        if(deck.size()>0){
        Random rn = new Random();
        int rand = rn.nextInt(deck.size() - 1) + 1;
        player.getHand().add(deck.get(rand));
        player.getHand().setSize(player.getHand().getSize() + 1);
        deck.remove(rand);
        
        }else{
            System.out.println("Oh! There's no card left in the remaining pool!"
                    + " This is last round!\n Get ready to see who wins!!");
        }
        return deck;
    }

    public Card get(int Index) {

        if (Index <= cards.size()) {
            return cards.get(Index);
        } else {
            return null;
        }
    }

    public boolean contains(Card c) {
        if (cards.contains(c)) {
            return true;
        }
        return false;

    }

    public void add(Card card) {

        cards.add(card);
    }

    public void remove(Card card) {

        cards.remove(card);

    }

    public ArrayList<Card> getDeck() {
        return deck;
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

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }

    @Override
    public String toString() {

        return "The remaining cards:" + deck;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

}//end class
