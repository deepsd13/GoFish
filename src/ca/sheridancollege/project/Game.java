package ca.sheridancollege.project;

import java.util.Scanner;

/**
 * The class that models the game.
 *
 * @author Deep Shah August 15 2019
 */
public class Game {

    private String gameName;//the title of the game

    /**
     * One parameter constructor
     *
     * @param givenName name of the game
     */
    public Game(String givenName) {
        gameName = givenName;
    }

    /**
     * getter for game name
     *
     * @return the gameName
     */
    public String getGameName() {
        return gameName;
    }

    /**
     * setter for gameName
     *
     * @param gameName
     */
    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    /**
     * The main play method which class the haveturn method of both human and
     * comp player.
     *
     * @param player1 Human Player
     * @param player2 computer player
     */
    public void play(Player player1, Player player2, GroupOfCards gOfc) {
        OUTER:
        while (gOfc.getDeck().size() > 1) {

            player1.haveTurn();
            //After the player turn has ended the program asks if the user wants to
            //exit.
            Scanner scan = new Scanner(System.in);
            boolean correct = true;

            INNER:
            while (correct) {
                System.out.println("Enter 0 to Exit and declare winner or 1 to continue.");
                int choose = scan.nextInt();
                switch (choose) {
                    case 1:
                        break INNER; // breaking from the inner loop
                    case 0:
                        break OUTER; // breaking from the outer loop
                    default:
                        System.out.println("Please select an valid option!\n");
                }
            }
            player2.haveTurn();
        }

        declareWinner(player1, player2);

    }

    /**
     * When the game is over, this method declares and display a winning player.
     */
    public void declareWinner(Player player1, Player player2) {

        if (player1.getScore() > player2.getScore()) {
            System.out.println("\nGAME OVER!!\nYour score:" + player1.getScore()
                    + "\nComputer's Score:" + player2.getScore());
            System.out.println("CONGRATS!!! YOU WON! YAYYYY :) ");
        } else if (player1.getScore() == player2.getScore()) {
            System.out.println("\nGAME OVER!!\nYour score:" + player1.getScore()
                    + "\nComputer's Score:" + player2.getScore());
            System.out.println("WOAH!! Its a tie! Better luck next time!;)");
        } else {
            System.out.println("\nGAME OVER!!\nYour score:" + player1.getScore()
                    + "\nComputer's Score:" + player2.getScore());
            System.out.println("You lose! Computer WON! :(");
        }
    }
}//end class
