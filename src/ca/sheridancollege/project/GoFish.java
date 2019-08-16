package ca.sheridancollege.project;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Deep Shah August 15,2019
 */
public class GoFish {

    public static Player[] users;
    public static GroupOfCards gOfc;

    public static void main(String[] args) {

        Game goFish = new Game("GO FISH");

        System.out.println("\n------------------------------HELLO! WELCOME TO THE GAME - " + goFish.getGameName() + "------------------------------");

        boolean keepPlaying = true;

        while (keepPlaying) {
            try {
                System.out.println("\nPlease enter your desired name");
                Scanner scan = new Scanner(System.in);
                String name = scan.nextLine();
                if (!Player.checkName(name)) {
                    System.out.println("\nERROR: Name should only consist letters!");
                } else {

                    //creating players and storing them in the player arraylist
                    HumanPlayer user = new HumanPlayer(name);
                    CompPlayer computer = new CompPlayer();

                    users = new Player[]{user, computer};

                    System.out.println("\nPress 1 to start the game");
                    int startGame = scan.nextInt();
                    if (startGame == 1) {

                        gOfc = new GroupOfCards();

                        gOfc.generateDeck(); // generating deck
                        //setting the size to 0
                        users[0].getHand().setSize(0);
                        users[1].getHand().setSize(0);
                        // distributing 10 cards
                        gOfc.distributeCards(users[0], 10); 
                        gOfc.distributeCards(users[1], 10);

                        // tbe main play method
                        goFish.play(users[0], users[1], gOfc);

                        System.out.println("\nDo you want to play again?");
                        System.out.println("1.YES\n0.NO");
                        int answer = scan.nextInt();
                        if (answer == 1) {
                            keepPlaying = true;
                        } else {
                            keepPlaying = false;
                        }

                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("ERROR: Invalid input!");
            }
        }

    }

    public static void foo(String s) {
        System.out.println(s);
    }

}
