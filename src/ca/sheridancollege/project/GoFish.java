package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Deep Shah
 */
public class GoFish {

    public static Player[] users;
    public static GroupOfCards gOfc;

    public static void main(String[] args) {

        Game goFish = new Game("GO FISH");

        System.out.println("HELLO! WELCOME TO THE GAME - " + goFish.getGameName());

        boolean keepPlaying = true;

        while (keepPlaying) {

            System.out.println("Please enter your desired name");
            Scanner scan = new Scanner(System.in);
            String name = scan.nextLine();
            
            HumanPlayer user = new HumanPlayer(name);
            CompPlayer computer = new CompPlayer();
            
            users = new Player[]{user, computer};
            
            System.out.println("Press 1 to start the game");
            int startGame = scan.nextInt();
            if (startGame == 1) {

                gOfc = new GroupOfCards();

                gOfc.generateDeck();
                users[0].getHand().setSize(0);
                users[1].getHand().setSize(0);
                gOfc.distributeCards(users[0]);
                gOfc.distributeCards(users[1]);

                goFish.play(users[0], users[1], gOfc);

                System.out.println("Do you want to play again?");
                System.out.println("1.YES\n0.NO");
                int answer = scan.nextInt();
                if (answer == 1) {
                    keepPlaying = true;
                } else {
                    keepPlaying = false;
                }

            }
        }

    }
}
