package ca.sheridancollege.project;

import java.util.Scanner;

/**
 * Subclass of Player class which overrides the haveturn method with its own
 * logic
 *
 * @author Deep Shah August 15,2019
 */
public class HumanPlayer extends Player {

    /**
     * One parameter constructor
     *
     * @param name name of the player
     */
    public HumanPlayer(String name) {
        super(name);
    }

    public HumanPlayer() {
    }

    /**
     * A method containing the logic for the users turn
     */
    @Override
    public void haveTurn() {
        Scanner scan = new Scanner(System.in);
        boolean changeTurn = false;

        do {

            //prompting user to select an operation
            System.out.println("\nSelect one of the following");
            System.out.println("1. Ask for a card \n2. See your Score");

            int choose = scan.nextInt();
            if (choose == 1 || choose == 2) {
                switch (choose) {

                    case 1:
                        System.out.println("Here is your current hand: ");
                        viewHand();
                        //asking user to ask for a card
                        System.out.println(" \n 1. ONE \n 2. TWO \n 3. THREE\n "
                                + "4. FOUR\n 5. FIVE\n 6. SIX\n 7. SEVEN\n "
                                + "8. EIGHT\n 9. NINE\n 10. TEN\n 11. JACK\n "
                                + "12. QUEEN\n 13. KING");
                        System.out.println("Which card do you want to ask?");

                        int select = scan.nextInt();
                        Card.Value value = Card.Value.ONE;
                        //selecting the value as per users request
                        switch (select) {
                            case 1:
                                value = Card.Value.ONE;
                                break;
                            case 2:
                                value = Card.Value.TWO;
                                break;
                            case 3:
                                value = Card.Value.THREE;
                                break;
                            case 4:
                                value = Card.Value.FOUR;
                                break;
                            case 5:
                                value = Card.Value.FIVE;
                                break;
                            case 6:
                                value = Card.Value.SIX;
                                break;
                            case 7:
                                value = Card.Value.SEVEN;
                                break;
                            case 8:
                                value = Card.Value.EIGHT;
                                break;
                            case 9:
                                value = Card.Value.NINE;
                                break;
                            case 10:
                                value = Card.Value.TEN;
                                break;
                            case 11:
                                value = Card.Value.JACK;
                                break;
                            case 12:
                                value = Card.Value.QUEEN;
                                break;
                            case 13:
                                value = Card.Value.KING;
                                break;
                        }
                        //asking for the card. if it returns true, turn will be changed to
                        //commputer
                        changeTurn = GoFish.users[0].askFor(value, GoFish.users[1], GoFish.gOfc);
                        //checking for books
                        GoFish.users[0].checkNumOfBooks();

                        break;

                    case 2:
                        System.out.println("Your Score is: " + getScore());
                        break;
                }

            } else {
                System.out.println("ERROR:Please choose a correct option!");
            }
        } while (!changeTurn);

    }

    /**
     * method showing hand of the user
     *
     * @return true if users have cards in their hand and false otherwise
     */
    public boolean viewHand() {
        //looping through every card in users hand and printing it
        if (hand.getSize() != 0) {
            for (int i = 1; i <= hand.getSize(); i++) {
                if (i == hand.getSize()) {
                    System.out.print(hand.get(i - 1) + ".");
                } else {
                    System.out.print(hand.get(i - 1) + ", ");
                }
            }
            return true;
        } else {
            System.out.println("You don't have any cards in your hand!");
        }
        return false;
    }

}
