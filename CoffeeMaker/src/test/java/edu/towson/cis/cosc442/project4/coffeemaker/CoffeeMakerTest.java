package edu.towson.cis.cosc442.project4.coffeemaker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CoffeeMakerTest {

    CoffeeMaker cm = new CoffeeMaker();
    Recipe r1 = new Recipe();
    Recipe r2 = new Recipe();
    Recipe r3 = new Recipe();
    Recipe dr4 = new Recipe();
    Recipe r5 = new Recipe();
    Recipe r6 = new Recipe();
    Recipe r7 = new Recipe();

    @BeforeEach 
    void setUp() {
        cm = new CoffeeMaker();
        r1 = new Recipe();
        r1.setName("Coffee");
        r1.setPrice(50);
        r1.setAmtCoffee(3);
        r1.setAmtMilk(1);
        r1.setAmtSugar(1);
        r1.setAmtChocolate(0);

        r2 = new Recipe();
        r2.setName("Mocha");
        r2.setPrice(75);
        r2.setAmtCoffee(3);
        r2.setAmtMilk(1);
        r2.setAmtSugar(1);
        r2.setAmtChocolate(20);

        r3 = new Recipe();
        r3.setName("Latte");
        r3.setPrice(60);
        r3.setAmtCoffee(3);
        r3.setAmtMilk(1);
        r3.setAmtSugar(1);
        r3.setAmtChocolate(0);

       dr4 = new Recipe();
       dr4.setName("Coffee");
       dr4.setPrice(50);
       dr4.setAmtCoffee(3);
       dr4.setAmtMilk(1);
       dr4.setAmtSugar(1);
       dr4.setAmtChocolate(0);

        r5 = new Recipe();
        r5.setName("Vanilla Latte");
        r5.setPrice(70);
        r5.setAmtCoffee(3);
        r5.setAmtMilk(1);
        r5.setAmtSugar(1);
        r5.setAmtChocolate(10);

        r6 = new Recipe();
        r6.setName("Caramel Macchiato");
        r6.setPrice(80);
        r6.setAmtCoffee(3);
        r6.setAmtMilk(1);
        r6.setAmtSugar(1);
        r6.setAmtChocolate(15);

        r7 = new Recipe();
    }

    @AfterEach 
    void tearDown() {
        cm = null;
        r1 = null;
        r2 = null;
        r3 = null;
        dr4 = null;
        r5 = null;
        r6 = null;
        r7 = null;

    }

    @ParameterizedTest
    @CsvSource({
        "1, 1, 1, 1",
        "0, 0, 0, 0",
        "1, 0 ,0 ,0 ",
        "0, 1, 0, 0",
        "0, 0, 1, 0",
        "0, 0, 0, 1",
    })
    void testAddInventory(int amtCoffee, int amtMilk, int amtSugar, int amtChocolate) {

    cm.addInventory(amtCoffee, amtMilk, amtSugar, amtChocolate);



    assertEquals(15 + amtCoffee, cm.checkInventory().getCoffee());
    assertEquals(15 + amtMilk, cm.checkInventory().getMilk());
    assertEquals(15 + amtSugar, cm.checkInventory().getSugar());
    assertEquals(15 + amtChocolate, cm.checkInventory().getChocolate());
    
    }

    @Test
    void testInvalidAddInventory() {

        assertEquals(false, cm.addInventory(-1, 0, 0, 0));
        assertEquals(15, cm.checkInventory().getCoffee());

        assertEquals(false, cm.addInventory(0, -1, 0, 0));
        assertEquals(15, cm.checkInventory().getMilk());

        assertEquals(false, cm.addInventory(0, 0, -1, 0));
        assertEquals(15, cm.checkInventory().getSugar());

        assertEquals(false, cm.addInventory(0, 0, 0, -1));
        assertEquals(15, cm.checkInventory().getChocolate());

    }

    @Test
    void testAddRecipe() {

        cm.addRecipe(r1);
        cm.addRecipe(r2);
        cm.addRecipe(r3);

        assertEquals(r1, cm.getRecipeForName("Coffee"));
        assertEquals(r2, cm.getRecipeForName("Mocha"));
        assertEquals(r3, cm.getRecipeForName("Latte"));

    }

    @Test 
    void testAddRecipeWhenFull() {

    assertTrue(cm.addRecipe(r1));
    assertTrue(cm.addRecipe(r2));
    assertTrue(cm.addRecipe(r3));
    assertTrue(cm.addRecipe(r5));
 //    This needs to return false
    assertFalse(cm.addRecipe(r7));

    }

    @Test 
    @Disabled("For step2")
    void testAddRecipeWhenDuplicate() {
    
    assertTrue(cm.addRecipe(r1));
        assertTrue(cm.addRecipe(r2));
        assertTrue(cm.addRecipe(r3));
        assertTrue(cm.addRecipe(r5));
        // This needs to return false
        assertFalse(cm.addRecipe(dr4));
    }

    @Test
    void testCheckInventory() {

        assertEquals(15, cm.checkInventory().getCoffee());
    }

    @Test
    void testDeleteRecipe() {
        cm.addRecipe(r1);

        assertTrue(cm.deleteRecipe(dr4));

    }

    @Test
    void testDeleteRecipeNotFound() {
        cm.addRecipe(r1);

        assertFalse(cm.deleteRecipe(r2));
    }

    @Test
    void testEditRecipe() {
        cm.addRecipe(r1);

        boolean result = cm.editRecipe(r1, r5);

        assertTrue(result);
    }

    @Test 
    @Disabled("For step2")
    void testEditRecipeNotFound() {
        cm.addRecipe(r1);

        boolean result = cm.editRecipe(r2, r5);
        boolean result2 = cm.editRecipe(r3, r5);

        assertFalse(result);
        assertFalse(result2);
    }

    @Test
    void testGetRecipeForName() {
        cm.addRecipe(r1);

        assertEquals(r1, cm.getRecipeForName("Coffee"));

    }

    @Test
    void testGetRecipes() {
        assertTrue(cm.addRecipe(r1));

        Recipe[] recipes = cm.getRecipes();

        assertEquals(4, recipes.length);
        assertTrue(Arrays.asList(recipes).contains(r1));

    }

    @Test
    @Disabled("For step2")
    void testMakeCoffee() {

        cm.addRecipe(r1);

        int change = cm.makeCoffee(r1, 75);

        assertEquals(25, change);
    assertEquals(12, cm.checkInventory().getCoffee());
    assertEquals(14, cm.checkInventory().getMilk());
    assertEquals(14, cm.checkInventory().getSugar());
    assertEquals(15, cm.checkInventory().getChocolate());

    }

    @Test 
    void testMakeCoffeeNotEnoughPaid() {
        cm.addRecipe(r1);

        int change = cm.makeCoffee(r1, 25);

        assertEquals(25, change);
    }

    @Test 
    @Disabled("For step2")
    void testMakeCoffeeNotEnoughIngredients() {
        cm.addRecipe(r1);

        cm.checkInventory().setCoffee(0);
        cm.checkInventory().setMilk(0);
        cm.checkInventory().setSugar(0);
        cm.checkInventory().setChocolate(0);


        System.out.println(cm.checkInventory().getCoffee());

        int change = cm.makeCoffee(r1, 75);

        assertEquals(75, change);
    }
}
