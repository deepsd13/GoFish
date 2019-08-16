package ca.sheridancollege.project;

/**
 * A class for possessing the data fields that an actual card could have
 *
 *
 * @author Deep Shah, 15 August 2019
 */
public class Card {

    /**
     * Enum class for suits of card
     */
    public enum Suit {
        HEARTS, CLUBS, DIAMONDS, SPADES;
    };

    /**
     * Enum class for values of card.
     */
    public enum Value {
        ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;
    };

    private Value value;
    private Suit suit;
    private final int deckSize = 52;

    /**
     * Two parameter constructor
     *
     * @param s suit of the class
     * @param v value of the class
     */
    public Card(Suit s, Value v) {
        suit = s;
        value = v;
    }

    /**
     * A method which checks if passed in card is equal to this.card
     *
     * @param card the card for comparing to this.card
     * @return boolean
     */
    public boolean equals(Card card) {
        return this.getValue().equals(card.getValue());
    }

    /**
     * Getter for value data field
     *
     * @return Value
     */
    public Value getValue() {
        return value;
    }

    /**
     * setter for value
     *
     * @param value
     */
    public void setValue(Value value) {
        this.value = value;
    }

    /**
     * getter for suit
     *
     * @return suit
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * setter for suit
     *
     * @param suit
     */
    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    /**
     * A formatted string of the card class
     *
     * @return String
     */
    @Override
    public String toString() {

        return getValue() + " Of " + getSuit();

    }

}
