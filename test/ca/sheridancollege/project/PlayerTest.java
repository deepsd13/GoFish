/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Deep Shah
 */
public class PlayerTest {

    public PlayerTest() {
    }

    /**
     * Test of askFor method, of class Player.
     */
    @Test
    public void testAskForGood() {
        GroupOfCards gOfc = new GroupOfCards();
        gOfc.generateDeck();

        System.out.println("askFor Good");
        Card.Value value = Card.Value.KING;
        Player otherPlayer = new CompPlayer();
        Player thisPlayer = new HumanPlayer();
        Card card = new Card(Card.Suit.HEARTS, Card.Value.KING);
        thisPlayer.getHand().add(card);
        otherPlayer.getHand().add(card);
        thisPlayer.getHand().setSize(1);
        otherPlayer.getHand().setSize(1);

        boolean expResult = false;
        boolean result = thisPlayer.askFor(value, otherPlayer, gOfc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void testAskForBad() {
        System.out.println("askFor Bad");

        GroupOfCards gOfc = new GroupOfCards();
        gOfc.generateDeck();

        Card.Value value = Card.Value.KING;
        Player otherPlayer = new CompPlayer();
        Player thisPlayer = new HumanPlayer();
        Card card = new Card(Card.Suit.HEARTS, Card.Value.KING);
        Card otherCard = new Card(Card.Suit.CLUBS, Card.Value.EIGHT);
        thisPlayer.getHand().add(card);
        otherPlayer.getHand().add(otherCard);
        thisPlayer.getHand().setSize(1);
        otherPlayer.getHand().setSize(1);

        boolean expResult = true;
        boolean result = thisPlayer.askFor(value, otherPlayer, gOfc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of checkNumOfBooks method, of class Player.
     */
    @Test
    public void testCheckNumOfBooksGood() {
        System.out.println("checkNumOfBooks Good");
        Player player = new HumanPlayer();
        player.getHand().add(new Card(Card.Suit.CLUBS, Card.Value.EIGHT));
        player.getHand().add(new Card(Card.Suit.DIAMONDS, Card.Value.EIGHT));
        player.getHand().add(new Card(Card.Suit.HEARTS, Card.Value.EIGHT));
        player.getHand().add(new Card(Card.Suit.SPADES, Card.Value.EIGHT));
        player.getHand().setSize(4);
        boolean expResult = true;
        boolean result = player.checkNumOfBooks();
        assertEquals(expResult, result);

        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void testCheckNumOfBooksBad() {
        System.out.println("\ncheckNumOfBooks Bad");
        Player player = new HumanPlayer();
        player.getHand().add(new Card(Card.Suit.CLUBS, Card.Value.EIGHT));
        player.getHand().add(new Card(Card.Suit.DIAMONDS, Card.Value.EIGHT));
        player.getHand().add(new Card(Card.Suit.HEARTS, Card.Value.EIGHT));
        player.getHand().add(new Card(Card.Suit.SPADES, Card.Value.NINE));
        player.getHand().setSize(4);
        boolean expResult = false;
        boolean result = player.checkNumOfBooks();
        assertEquals(expResult, result);

        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void testCheckNameGood() {
        System.out.println("checkName Good");
        String name = "Deep";
        boolean expResult = true;
        boolean result = Player.checkName(name);
        assertEquals(expResult, result);

    }

    @Test
    public void testCheckNameBad() {
        System.out.println("checkName Bad");
        String name = "DeepShah1234";
        boolean expResult = false;
        boolean result = Player.checkName(name);
        assertEquals(expResult, result);
    }

    @Test
    public void testCheckNameBoundary() {
        System.out.println("checkName Boundary");
        String name = "DeepShahSD";
        boolean expResult = true;
        boolean result = Player.checkName(name);
        assertEquals(expResult, result);
    }
}
