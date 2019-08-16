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
public class CardTest {
    
    public CardTest() {
    }

    /**
     * Test of equals method, of class Card.
     */
      @Test
    public void testEqualsGood() {
        System.out.println("equals Good");
        Card card = new Card(Card.Suit.DIAMONDS,Card.Value.FOUR);
        Card otherCard =  new Card(Card.Suit.DIAMONDS,Card.Value.FOUR);
        boolean expResult = true;
        boolean result = card.equals(otherCard);
        assertEquals(expResult, result);
    }
    @Test
    public void testEqualsBad() {
        System.out.println("equals Bad");
        Card card = new Card(Card.Suit.DIAMONDS,Card.Value.FOUR);
        Card otherCard =  new Card(Card.Suit.DIAMONDS,Card.Value.FIVE);
        boolean expResult = false;
        boolean result = card.equals(otherCard);
        assertEquals(expResult, result);
    }
  
}
