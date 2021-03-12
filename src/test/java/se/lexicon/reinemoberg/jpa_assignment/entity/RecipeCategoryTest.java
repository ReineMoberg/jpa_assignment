package se.lexicon.reinemoberg.jpa_assignment.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RecipeCategoryTest {

    RecipeCategory testRecipeCategory;

    @BeforeEach
    public void setup() {
        testRecipeCategory = new RecipeCategory();
        testRecipeCategory.setId(8);
        testRecipeCategory.setCategory("Dinner foods");
        testRecipeCategory.setRecipeList(new ArrayList<>());
    }

    @Test
    @DisplayName("Create test object")
    public void testCreatTestObject() {
        Assertions.assertEquals(8, testRecipeCategory.getId());
        Assertions.assertEquals("Dinner foods", testRecipeCategory.getCategory());
        Assertions.assertNotNull(testRecipeCategory.getRecipeList());
    }

    @Test
    @DisplayName("Add recipe")
    public void testAddRecipe() {
        RecipeInstruction recipeInstruction1 = new RecipeInstruction(UUID.fromString("1"),"Grill it");
        Recipe recipe1 = new Recipe(2, "Grilled chicken", new ArrayList<>(), recipeInstruction1, new ArrayList<>());

        testRecipeCategory.addRecipe(recipe1);
        Assertions.assertTrue(testRecipeCategory.getRecipeList().contains(recipe1));
        Assertions.assertEquals(1, testRecipeCategory.getRecipeList().size());
        Assertions.assertTrue(recipe1.getCategoryList().contains(testRecipeCategory));
    }

    @Test
    @DisplayName("Remove recipe")
    public void testRemoveRecipe() {
        RecipeInstruction recipeInstruction1 = new RecipeInstruction(UUID.fromString("1"),"Grill it");
        Recipe recipe1 = new Recipe(2, "Grilled chicken", new ArrayList<>(), recipeInstruction1, new ArrayList<>());
        List<Recipe> recipeList1 = new ArrayList<>();
        recipeList1.add(recipe1);

        testRecipeCategory.setRecipeList(recipeList1);
        Assertions.assertTrue(testRecipeCategory.getRecipeList().contains(recipe1));
        Assertions.assertEquals(1, testRecipeCategory.getRecipeList().size());

        testRecipeCategory.removeRecipe(recipe1);
        Assertions.assertFalse(testRecipeCategory.getRecipeList().contains(recipe1));
        Assertions.assertEquals(0, testRecipeCategory.getRecipeList().size());
        System.out.println(recipe1);
    }
}
