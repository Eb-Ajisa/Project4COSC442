(amtCoffee < 0 || amtMilk < 0 || amtSugar > 0 || amtChocolate < 0) 

- The bug is that amtSugar > 0  will always return true if we want to increase the amount of sugar which is incorrect. it stops us from being able to add anything


if (newRecipe.equals(recipeArray[i])) 

- The bug is that newRecipe cannot already be in the array so we meant to put oldRecipe instead


inventory.setCoffee(inventory.getCoffee() + r.getAmtCoffee());

- We are supposed to be subtracting not adding