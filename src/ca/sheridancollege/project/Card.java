/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 *
 * @ Deep Shah June 26 2019
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * A class to be used as the base Card class for the project. Must be general
 * enough to be instantiated for any Card game. Students wishing to add to the
 * code should remember to add themselves as a modifier.
 *
 * @author dancye, 2018
 * @author Deep Shah, 21 July 2019
 */
public class Card {

    public enum Suit {
        HEARTS, CLUBS, DIAMONDS, SPADES;
    };

    public enum Value {
        ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;

    };

    //default modifier for child classes
    private Value value;
    private Suit suit;
    private int deckSize = 52;

    public Card(Suit s, Value v) {
        suit = s;
        value = v;
    }

    /*

    public void generateDeck() {

        for (Suit s : Suit.values()) {
            for (Value v : Value.values()) {

                Card c = new Card(s, v);
                deck.add(c);
            }
        }
    }
     */
    public boolean equals(Value value) {
        if (this.getValue().equals(value)) {
            return true;
        } else {
            return false;
        }

    }

    public Value getValue() {
        // TODO - implement Card.getValue
        return value;
    }

    /**
     *
     * @param value
     */
    public void setValue(Value value) {
        this.value = value;
    }

    public Suit getSuit() {
        return suit;
    }

    /**
     *
     * @param suit
     */
    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public String toString() {

        return getValue() + " of " + getSuit() + ", ";

    }

}
