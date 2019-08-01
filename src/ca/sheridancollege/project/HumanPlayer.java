package ca.sheridancollege.project;

import java.util.Scanner;

/**
 *
 * @author Deep Shah
 */
public class HumanPlayer extends Player {

    public GroupOfCards hand = new GroupOfCards();

    @Override
    public GroupOfCards getHand() {
        return hand;
    }

    @Override
    public void setHand(GroupOfCards hand) {
        this.hand = hand;
    }

    public HumanPlayer(String name) {
        super(name);
    }

    public HumanPlayer() {
    }

    @Override
    public void haveTurn() {
        Scanner scan = new Scanner(System.in);
        boolean changeTurn = false;

        do {

            System.out.println("\nSelect one of the following");
            System.out.println("1. Ask for a card \n2. See your Score");

            int choose = scan.nextInt();
            switch (choose) {

                case 1:
                    System.out.println("Here is your current hand: ");
                    for (int i = 1; i <= hand.getSize(); i++) {
                        if (i == hand.getSize()) {
                            System.out.print(hand.get(i - 1) + ".");
                        } else {
                            System.out.print(hand.get(i - 1) + ", ");
                        }
                    }

                    System.out.println(" \n\t1. ONE \n\t2. TWO \n\t3. THREE\n\t"
                            + "4. FOUR\n\t5. FIVE\n\t6. SIX\n\t7. SEVEN\n\t"
                            + "8. EIGHT\n\t9. NINE\n\t10. TEN\n\t11. JACK\n\t"
                            + "12. QUEEN\n\t13. KING");
                    System.out.println("Which card do you want to ask?");

                    int select = scan.nextInt();
                    Card.Value value = Card.Value.ONE;
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
                   changeTurn = GoFish.users[0].askFor(value);
                   GoFish.users[0].checkNumOfBooks();

                    break;

                case 2:
                    System.out.println("Your Score is: " + getScore());
                    break;
            }
        } while(!changeTurn);

    }
}
