package ca.sheridancollege.project;

import java.util.Random;

/**
 *
 * @author Deep Shah
 */
public class CompPlayer extends Player {

    public GroupOfCards hand = new GroupOfCards();

    @Override
    public GroupOfCards getHand() {
        return hand;
    }

    @Override
    public void setHand(GroupOfCards hand) {
        this.hand = hand;
    }

    public CompPlayer(String name) {
        super(name);
    }

    public CompPlayer() {
    }

    @Override
    public void haveTurn() {

        boolean changeTurn = false;
        do {
            Random rn = new Random();
            int random = rn.nextInt(hand.getSize() - 1) + 1;

            Card.Value value = hand.get(random).getValue();
            
            changeTurn = GoFish.users[1].askFor(value);
            GoFish.users[1].checkNumOfBooks();
        } while (!changeTurn);
    }
}
