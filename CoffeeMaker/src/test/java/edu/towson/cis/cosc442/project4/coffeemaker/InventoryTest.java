package edu.towson.cis.cosc442.project4.coffeemaker;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.Disabled;

public class InventoryTest {
    Inventory inventory = new Inventory();
    @BeforeEach 
    void setUp() {


        inventory.setCoffee(15);
        inventory.setMilk(15);
        inventory.setSugar(15);
        inventory.setChocolate(15);


    }

    @AfterEach 
    void tearDown() {
       inventory = null;


    }
    @ParameterizedTest
    @CsvSource ({
        "5, 5, 5, 5, 50",
        "15, 15, 15, 15, 50",
    })
    @Disabled("For step2")
    void testEnoughIngredients(int amtCoffee, 
        int amtMilk, int amtSugar, int amtChocolate, 
        int price) {
        Recipe r = new Recipe();
        r.setAmtCoffee(amtCoffee);
        r.setAmtMilk(amtMilk);
        r.setAmtSugar(amtSugar);
        r.setAmtChocolate(amtChocolate);
        r.setPrice(price);

        assertEquals(true, inventory.enoughIngredients(r));

    }

    @ParameterizedTest
    @CsvSource ({
        "20, 20, 20, 20, 20",
        "5, 20, 20, 20, 20",
        "20, 5, 20, 20, 20",
        "20, 20, 5, 20, 20",
        "20, 20, 20, 5, 20",
        "16, 16, 16, 16, 20",
    })
    @Disabled("For step2")
    void testNotEnoughIngredients( int amtCoffee, 
        int amtMilk, int amtSugar, int 
        amtChocolate, int price) {
            Recipe recipe = new Recipe();
            recipe.setAmtCoffee(amtCoffee);
            recipe.setAmtMilk(amtMilk);
            recipe.setAmtSugar(amtSugar);
            recipe.setAmtChocolate(amtChocolate);
            recipe.setPrice(price);

        assertEquals(false, inventory.enoughIngredients(recipe));
    }

    @Test
    void testGetChocolate() {

        assertEquals(15, inventory.getChocolate());

    }

    @Test
    void testGetCoffee() {
        assertEquals(15, inventory.getCoffee());
    }

    @Test
    void testGetMilk() {
        assertEquals(15, inventory.getMilk());

    }

    @Test
    void testGetSugar() {
        assertEquals(15, inventory.getSugar());

    }

    @ParameterizedTest
    @CsvSource({
        "10, 10",
        "5, 5",
        "0, 0"
    })
    void testSetChocolate(int amount, int expected) {

        inventory.setChocolate(amount);

        assertEquals(expected, inventory.getChocolate());

    }
    
    @Test 
    void testSetChocolateNegative() {
        inventory.setChocolate(-5);
        assertEquals(0, inventory.getChocolate());
    }

    @Test
    void testSetCoffee() {
        inventory.setCoffee(10);

        assertEquals(10, inventory.getCoffee());

    }

    @Test 
    void testSetCoffeeNegative() {
        inventory.setCoffee(-5);
        assertEquals(0, inventory.getCoffee());
    }

    @Test
    void testSetMilk() {
        inventory.setMilk(10);

        assertEquals(10, inventory.getMilk());

    }

    @Test 
    void testSetMilkNegative() {
        inventory.setMilk(-5);
        assertEquals(0, inventory.getMilk());
    }

    @Test
    void testSetSugar() {
        inventory.setSugar(10);

        assertEquals(10, inventory.getSugar());
    }

    @Test 
    void testSetSugarNegative() {
        inventory.setSugar(-5);
        assertEquals(0, inventory.getSugar());
    }

    @Test
    void testToString() {
        String expected = "Coffee: 15\nMilk: 15\nSugar: 15\nChocolate: 15\n";
        assertEquals(expected, inventory.toString());

    }
}
