/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

import ca.sheridancollege.project.Card.Value;

/**
 * A class that models each Player in the game. Players have an identifier,
 * which should be unique.
 *
 * @author dancye, 2018
 */
public abstract class Player {

    protected GroupOfCards hand = new GroupOfCards(0);
    private String playerID; //the unique ID for this player
    private int score;

    /**
     * A constructor that allows you to set the player's unique ID
     *
     * @param name the unique ID to assign to this player.
     */
    public Player(String name) {
        playerID = name;
    }

    public Player() {
    }

    public abstract GroupOfCards getHand();

    public abstract void setHand(GroupOfCards cards);

    /**
     * @return the playerID
     */
    public String getPlayerID() {
        return playerID;
    }

//    public boolean hasCard(Card c) {
//
//        if (hand.contains(c)) {
//            return true;
//        }
//        return false;
//
//    }
    protected boolean askFor(Value value) {
        Player otherPlayer;
        if (this instanceof HumanPlayer) {
            otherPlayer = GoFish.users[1];
        } else {
            otherPlayer = GoFish.users[0];
        }
        boolean CompContains = false;
        boolean userContains = false;
        boolean changeTurn  =  false;
        for (int i = 0; i < this.getHand().getSize(); i++) {

            if (this.getHand().get(i).getValue().equals(value)) {
                userContains = true;
            }
        }

        if (userContains) {
            int enteredLoop = 0;

            for (int j = 0; j < otherPlayer.getHand().getSize(); j++) {
                if (otherPlayer.getHand().get(j).getValue().equals(value)) {
                    enteredLoop++;
                    if (enteredLoop == 1) {
                        if (this instanceof HumanPlayer) {
                            System.out.println("Computer has the requested card!\nYour hand is updated!!\n");
                        } else {
                            System.out.println("Computer asks for " + value);
                            System.out.println("You contain the requested card!\nYou lose all the cards matching requested card!:(\n");
                        }
                    }
                    this.getHand().add(otherPlayer.getHand().get(j));
                    otherPlayer.getHand().remove(otherPlayer.getHand().get(j));
                    otherPlayer.getHand().setSize(otherPlayer.getHand().getSize() - 1);
                    this.getHand().setSize(this.getHand().getSize() + 1);

                    changeTurn =  true;
                }
            }
            if (!CompContains) {
                if (this instanceof HumanPlayer) {

                    System.out.println("Computer says: GO FISH!!");
                    System.out.println("-----------------------------------------------------");
                    System.out.println("You lose yout turn! It's computer turn!:(\n");
                } else {
                    System.out.println("Computer asks for " + value);
                    System.out.println("Computer goes FISHING! ;)");
                    System.out.println("-----------------------------------------------------");
                    System.out.println("Your turn! YAYYY!\n");
                }
                GoFish.gOfc.fish(this);
                changeTurn =  true;
            }

        }

        if (!userContains) {
            System.out.println(
                    "You don't have the requested card in your"
                    + " hand.Please ask card that you have in your hand");
            this.haveTurn();
        }
        return changeTurn;
    }

    public void checkNumOfBooks() {
        for (int i = 0; i < this.getHand().getSize(); i++) {

            int sameCard = 0;
            for (int j = 0; j < this.getHand().getSize() - 1; j++) {
                if (this.getHand().get(i).getValue().equals(this.getHand().get(j).getValue())) {
                    Card sameValue[] = new Card[4];
                    sameValue[sameCard] = this.getHand().get(j);
                    sameCard++;
                    if (sameCard == 4) {
                        for (int k = 0; k < 4; k++) {
                            this.getHand().remove(sameValue[k]);
                            this.getHand().setSize(this.getHand().getSize() - 1);
                        }
                        addScore();

                    }
                }

            }
        }
    }

    public void addCard(Card card) {

        hand.add(card);
    }

    /**
     * Ensure that the playerID is unique
     *
     */
    public abstract void haveTurn();

    public void setPlayerID(String givenID) {
        playerID = givenID;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void addScore() {
        score++;
    }

}
