package edu.towson.cis.cosc442.project4.coffeemaker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RecipeTest {

        Recipe r1 = new Recipe();
        Recipe r2 = new Recipe();
        Recipe r3 = new Recipe();
        Recipe dup4 = new Recipe();
        Recipe null5 = new Recipe();

    @BeforeEach 
    void setUp() {

        r1.setName("Coffee");
        r1.setPrice(50);
        r1.setAmtCoffee(3);
        r1.setAmtMilk(1);
        r1.setAmtSugar(1);
        r1.setAmtChocolate(0);

        r2.setName("Mocha");
        r2.setPrice(75);
        r2.setAmtCoffee(3);
        r2.setAmtMilk(1);
        r2.setAmtSugar(1);
        r2.setAmtChocolate(20);

        r3.setName("Latte");
        r3.setPrice(60);
        r3.setAmtCoffee(3);
        r3.setAmtMilk(1);
        r3.setAmtSugar(1);
        r3.setAmtChocolate(0);

       dup4.setName("Coffee");
       dup4.setPrice(50);
       dup4.setAmtCoffee(3);
       dup4.setAmtMilk(1);
       dup4.setAmtSugar(1);
       dup4.setAmtChocolate(0);

    }

    @AfterEach 
    void tearDown() {
        r1 = null;
        r2 = null;
        r3 = null;
        dup4 = null;
        null5 = null;


    }

    @Test
    void testEquals() {

        assertTrue(r1.equals(dup4));
    }

    @Test 
    void notEquals() {
        assertFalse(r1.equals(r2));
    }

    @Test 
    void nullEquals() {
        assertThrows(NullPointerException.class, ()
         -> { null5.equals(null); });
    }

    @Test
    void testGetAmtChocolate() {
        assertEquals(0, r1.getAmtChocolate());
        assertEquals(20, r2.getAmtChocolate());
        assertEquals(0, r3.getAmtChocolate());
        assertEquals(0, dup4.getAmtChocolate());
    }

    @Test
    void testGetAmtCoffee() {
        assertEquals(3, r1.getAmtCoffee());
        assertEquals(3, r2.getAmtCoffee());
        assertEquals(3, r3.getAmtCoffee());
        assertEquals(3, dup4.getAmtCoffee());

    }

    @Test
    void testGetAmtMilk() {
        assertEquals(1, r1.getAmtMilk());
        assertEquals(1, r2.getAmtMilk());
        assertEquals(1, r3.getAmtMilk());
        assertEquals(1, dup4.getAmtMilk());

    }

    @Test
    void testGetAmtSugar() {
        assertEquals(1, r1.getAmtSugar());
        assertEquals(1, r2.getAmtSugar());
        assertEquals(1, r3.getAmtSugar());
        assertEquals(1, dup4.getAmtSugar());

    }

    @Test
    void testGetName() {
        assertEquals("Coffee", r1.getName());

    }

    @Test
    void testGetPrice() {
        assertEquals(50, r1.getPrice());
    }

    @Test
    void testSetAmtChocolate() {
        r1.setAmtChocolate(5);
        assertEquals(5, r1.getAmtChocolate());

    }

    @Test 
    void testInvalidSetAmtChocolate() {
        r1.setAmtChocolate(-5);
        assertEquals(0, r1.getAmtChocolate());
    }

    @Test
    void testSetAmtCoffee() {
        r1.setAmtCoffee(5);
        assertEquals(5, r1.getAmtCoffee());
    }

    @Test 
    void testInvalidSetAmtCoffee() {
        r1.setAmtCoffee(-5);
        assertEquals(0, r1.getAmtCoffee());
    }

    @Test
    void testSetAmtMilk() {
        r1.setAmtMilk(5);
        assertEquals(5, r1.getAmtMilk());
    }

    @Test 
    void testInvalidSetAmtMilk() {
        r1.setAmtMilk(-5);
        assertEquals(0, r1.getAmtMilk());
    }

    @Test
    void testSetAmtSugar() {
        r1.setAmtSugar(5);
        assertEquals(5, r1.getAmtSugar());
    }

    @Test 
    void testInvalidSetAmtSugar() {
        r1.setAmtSugar(-5);
        assertEquals(0, r1.getAmtSugar());
    }

    @Test
    void testSetName() {
        r1.setName("Tea");
        assertEquals("Tea", r1.getName());
    }

    @Test
    void testSetPrice() {
        r1.setPrice(100);
        assertEquals(100, r1.getPrice());

    }

    @Test 
    void testInvalidSetPrice() {
        r1.setPrice(-100);
        assertEquals(0, r1.getPrice());
    }

    @Test
    void testToString() {
        assertEquals("Coffee", r1.toString());
    }
}
