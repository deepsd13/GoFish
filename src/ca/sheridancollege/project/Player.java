package ca.sheridancollege.project;

import ca.sheridancollege.project.Card.Value;
import java.util.regex.Pattern;

/**
 * A class that models each Player in the game. Players have an identifier,
 * which should be unique.
 *
 * @author Deep Shah August 15, 2019
 */
public abstract class Player {

    protected GroupOfCards hand = new GroupOfCards();
    private String name; //the unique ID for this player
    private int score;

    /**
     * A constructor that allows to set the player's unique ID
     *
     * @param name the unique ID to assign to this player.
     */
    public Player(String name) {
        this.name = name;
    }

    public Player() {
    }

    public GroupOfCards getHand() {
        return hand;
    }

    /**
     * Sets the hand of the player
     *
     * @param hand
     */
    public void setHand(GroupOfCards hand) {
        this.hand = hand;
    }

    /**
     * @return the playerID
     */
    public String getName() {
        return name;
    }

    /**
     * setter for name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter for score
     *
     * @return score of the player
     */
    public int getScore() {
        return score;
    }

    /**
     * setter for score
     *
     * @param score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * method to add score
     */
    public void addScore() {
        score++;
    }

    /**
     * *
     * a method which checks the name of the player
     *
     * @param name
     * @return true if name is okay and false otherwise
     */
    public static boolean checkName(String name) {
        if (Pattern.matches("[a-zA-Z]+", name) && name.length() <= 10) {
            return true;
        }

        return false;
    }

    /**
     * A method which asks opponent player for a card
     *
     * @param value
     * @param otherPlayer
     * @param gOfc
     * @return true if user contains the card false otherwise
     */
    protected boolean askFor(Value value, Player otherPlayer, GroupOfCards gOfc) {

        boolean compContains = false;
        boolean userContains = false;
        boolean changeTurn = false;
        for (int i = 0; i < this.getHand().getSize(); i++) {

            //checking if user had the card that they requested if not
            //printing an message to select a correct card
            if (this.getHand().get(i).getValue().equals(value)) {
                userContains = true;
            }
        }

        //only if user has the card then the program checks if opponent player has the card
        if (userContains) {
            // for printing the message of whats happening, it will only print 
            // when the first time the program enters into loop
            int enteredLoop = 0;

            for (int j = 0; j < otherPlayer.getHand().getSize(); j++) {
                //checking if opponent has requested card
                if (otherPlayer.getHand().get(j).getValue().equals(value)) {
                    enteredLoop++;
                    if (enteredLoop == 1) {
                        // if this is humanPlayer then if prints following message
                        if (this instanceof HumanPlayer) {
                            System.out.println("Computer has the requested card!\nYour hand is updated!!\n");
                        } else {
                            //if its computer player it prints the following
                            System.out.println("Computer asks for " + value);
                            System.out.println("You contain the requested card!\nYou lose all the cards matching requested card!:(\n");
                        }
                    }
                    //upating the players hand and hand size
                    this.getHand().add(otherPlayer.getHand().get(j));
                    otherPlayer.getHand().remove(otherPlayer.getHand().get(j));
                    otherPlayer.getHand().setSize(otherPlayer.getHand().getSize() - 1);
                    this.getHand().setSize(this.getHand().getSize() + 1);

                    compContains = true;
                }
            }
            //if opponent player does not have the card then the this player goes fishing
            if (!compContains) {
                if (this instanceof HumanPlayer) {

                    System.out.println("Computer says: GO FISH!!");
                    System.out.println("-----------------------------------------------------");
                    System.out.println("You lose your turn! It's computer turn!:(\n");
                } else {
                    System.out.println("Computer asks for " + value);
                    System.out.println("Computer goes FISHING! ;)");
                    System.out.println("-----------------------------------------------------");
                    System.out.println("Your turn! YAYYY!\n");
                }
                gOfc.goFish(this);
                changeTurn = true; // changing turn
            }

        }

        if (!userContains) {
            System.out.println(
                    "You don't have the requested card in your"
                    + " hand.Please ask card that you have in your hand");
        }
        return changeTurn;
    }

    /**
     * method which check number of Books and updates score accordingly
     *
     * @return true if user contains a book false otherwise
     */
    public boolean checkNumOfBooks() {
        boolean hasBook = false;
        //selecting one card and checking if that card is same as any other card
        //in the hand
        for (int i = 0; i < this.getHand().getSize(); i++) {

            int sameCard = 0;
            Card sameValue[] = new Card[4]; //arraylist which will contain all the same cards
            for (int j = 0; j < this.getHand().getSize(); j++) {
                //checking if cards are same
                if (this.getHand().get(i).getValue().equals(this.getHand().get(j).getValue())) {
                    sameValue[sameCard] = this.getHand().get(j);
                    sameCard++;
                    //only if the there are four same card that means a book then the score is updated and 
                    // all other cards are removed from the players hand
                    if (sameCard == 4) {

                        addScore(); // adding the score
                        hasBook = true;
                        //printing the message which book the user contains
                        if (this instanceof HumanPlayer) {
                            System.out.println("\nYou got a book of:" + this.getHand().get(i).getValue()
                                    + "\nYour score is updated.");
                        } else {
                            System.out.println("\nComputer got a book of:" + this.getHand().get(i).getValue()
                                    + "\nComputer's score is updated");
                        }
                        //removing the same cards which are stored in the sameCard[] arraylist
                        for (int k = 0; k < 4; k++) {
                            this.getHand().remove(sameValue[k]);
                            this.getHand().setSize(this.getHand().getSize() - 1);
                        }
                    }
                }

            }
        }
        return hasBook;
    }

    // an abstract method which is overriden by the subclasses
    public abstract void haveTurn();

}
