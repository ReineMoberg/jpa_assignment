package se.lexicon.reinemoberg.jpa_assignment.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RecipeTest {

    Recipe testRecipe;

    @BeforeEach
    public void setup(){
        RecipeInstruction recipeInstruction1 = new RecipeInstruction("1","Bake it");
        testRecipe = new Recipe();
        testRecipe.setId(1);
        testRecipe.setName("Apple Pie");
        testRecipe.setInstruction(recipeInstruction1);
    }

    @Test
    @DisplayName("Create test object")
    public void testCreatTestObject() {
        Assertions.assertEquals(1, testRecipe.getId());
        Assertions.assertEquals("Apple Pie", testRecipe.getName());
        Assertions.assertEquals("Bake it", testRecipe.getInstruction().getInstructions());
    }

    @Test
    @DisplayName("Add recipe ingredient")
    public void testAddRecipeIngredient() {
        Ingredient ingredient1 = new Ingredient(1, "Sugar");
        RecipeIngredient recipeIngredient1 = new RecipeIngredient("1", ingredient1, 2, Measurement.DL, testRecipe);

        testRecipe.addRecipeIngredient(recipeIngredient1);
        Assertions.assertTrue(testRecipe.getRecipeIngredientList().contains(recipeIngredient1));
    }

    @Test
    @DisplayName("Remove recipe ingredient")
    public void testRemoveRecipeIngredient(){
        Ingredient ingredient1 = new Ingredient(1, "Sugar");
        RecipeIngredient recipeIngredient1 = new RecipeIngredient("1", ingredient1, 2, Measurement.DL, testRecipe);
        List<RecipeIngredient> recipeIngredientList1 = new ArrayList<>();
        recipeIngredientList1.add(recipeIngredient1);

        testRecipe.setRecipeIngredientList(recipeIngredientList1);
        Assertions.assertTrue(testRecipe.getRecipeIngredientList().contains(recipeIngredient1));
        Assertions.assertEquals(1, testRecipe.getRecipeIngredientList().size());

        testRecipe.removeRecipeIngredient(recipeIngredient1);
        Assertions.assertFalse(testRecipe.getRecipeIngredientList().contains(recipeIngredient1));
        Assertions.assertEquals(0, testRecipe.getRecipeIngredientList().size());
        System.out.println(recipeIngredient1);
    }
}
