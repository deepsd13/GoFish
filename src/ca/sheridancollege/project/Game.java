/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * The class that models your game. You should create a more specific child of
 * this class and instantiate the methods given.
 *
 * @author dancye, 2018
 */
public class Game {

    private final String gameName;//the title of the game
    private ArrayList<Player> players;// the players of the game

    public Game(String givenName) {
        gameName = givenName;
        players = new ArrayList();
    }

    /**
     *
     * @return the gameName
     */
    public String getGameName() {
        return gameName;
    }

    /**
     * @return the players of this game
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * @param players the players of this game
     */
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    /**
     * Play the game. This might be one method or many method calls depending on
     * your game.
     *
     * @param player1
     * @param player2
     */
    public void play(Player player1, Player player2, GroupOfCards gOfc) {

        while (gOfc.getDeck().size() > 1) {

            player1.haveTurn();
            player2.haveTurn();

        }
        declareWinner(player1, player2);

    }

    /**
     * When the game is over, use this method to declare and display a winning
     * player.
     */
    public void declareWinner(Player player1, Player player2) {

        if (player1.getScore() > player2.getScore()) {
            System.out.println("GAME OVER!!\nYour score:" + player1.getScore()
                    + "\nComputer's Score:" + player2.getScore());
            System.out.println("CONGRATS!!! YOU WON! YAYYYY :) ");
        } else if (player1.getScore() == player2.getScore()) {
            System.out.println("GAME OVER!!\nYour score:" + player1.getScore()
                    + "\nComputer's Score:" + player2.getScore());
            System.out.println("WOAH!! Its a tie! Better luck next time!;)");
        } else {
            System.out.println("GAME OVER!!\nYour score:" + player1.getScore()
                    + "\nComputer's Score:" + player2.getScore());
            System.out.println("You lose! Computer WON! :(");
        }
    }
}//end class
