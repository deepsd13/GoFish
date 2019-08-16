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
public class HumanPlayerTest {
    
    public HumanPlayerTest() {
    }

   

    /**
     * Test of viewHand method, of class HumanPlayer.
     */
    @Test
    public void testViewHandGood() {
        System.out.println("viewHand good");
        HumanPlayer instance = new HumanPlayer();
        GroupOfCards gOfc = new GroupOfCards();
        gOfc.generateDeck();
        gOfc.distributeCards(instance, 10);    
        boolean expResult = true;
        boolean result = instance.viewHand();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
      @Test
    public void testViewHandBad() {
        System.out.println("viewHand Bad");
        HumanPlayer instance = new HumanPlayer();
        GroupOfCards gOfc = new GroupOfCards();
        gOfc.generateDeck();
        gOfc.distributeCards(instance, 10);    
        instance.getHand().setSize(0);
        boolean expResult = false;
        boolean result = instance.viewHand();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
}
