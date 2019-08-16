package ca.sheridancollege.project;

import java.util.Random;

/**
 * Subclass of Player class which overrides the haveturn method with its own
 * logic
 *
 * @author Deep Shah August 15 2019
 */
public class CompPlayer extends Player {

    /**
     *
     * @return the hand of the player
     */
    /**
     * One parameter constructor
     *
     * @param name name of the player
     */
    public CompPlayer(String name) {
        super(name);
    }

    public CompPlayer() {
    }

    /**
     * A method containing the logic for the computers turn
     */
    @Override
    public void haveTurn() {

        boolean changeTurn = false;
        do {
            //generating a random nunber and asking that number card from the 
            //human player
            Random rn = new Random();
            int random = rn.nextInt(hand.getSize() - 1) + 1;

            Card.Value value = hand.get(random).getValue();

            changeTurn = GoFish.users[1].askFor(value, GoFish.users[0], GoFish.gOfc);
            GoFish.users[1].checkNumOfBooks(); // checking number of book
        } while (!changeTurn);
    }
}
