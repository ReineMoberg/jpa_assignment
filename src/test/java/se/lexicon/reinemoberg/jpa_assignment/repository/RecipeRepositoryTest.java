package se.lexicon.reinemoberg.jpa_assignment.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.reinemoberg.jpa_assignment.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DataJpaTest
public class RecipeRepositoryTest {

    @Autowired
    RecipeRepository testObject;
    @Autowired
    IngredientRepository ingredientRepository;
    @Autowired
    RecipeCategoryRepository recipeCategoryRepository;
    @Autowired
    RecipeIngredientRepository recipeIngredientRepository;
    @Autowired
    RecipeInstructionRepository recipeInstructionRepository;

    @BeforeEach
    public void setup() {
        ingredientRepository.save(new Ingredient("Fresh herring"));
        ingredientRepository.save(new Ingredient("Salt"));
        ingredientRepository.save(new Ingredient("Breadcrumbs"));
        ingredientRepository.save(new Ingredient("Butter"));
        ingredientRepository.save(new Ingredient("Yeast"));
        ingredientRepository.save(new Ingredient("Water"));
        ingredientRepository.save(new Ingredient("White fine flour"));
        ingredientRepository.save(new Ingredient("Brown rice"));
        ingredientRepository.save(new Ingredient("Sugar"));
        ingredientRepository.save(new Ingredient("Milk"));
        ingredientRepository.save(new Ingredient("Cream"));


        Recipe recipe1 = new Recipe();
        recipe1.setName("Fried herring");
        List<RecipeIngredient> ingredientList1 = new ArrayList<>();
        ingredientList1.add(recipeIngredientRepository.save(new RecipeIngredient(ingredientRepository.findByNameIgnoreCase("Fresh herring").get(), 1, Measurement.KG, recipe1)));
        ingredientList1.add(recipeIngredientRepository.save(new RecipeIngredient(ingredientRepository.findByNameIgnoreCase("Salt").get(), 2, Measurement.TSP, recipe1)));
        ingredientList1.add(recipeIngredientRepository.save(new RecipeIngredient(ingredientRepository.findByNameIgnoreCase("Breadcrumbs").get(), 1, Measurement.DL, recipe1)));
        ingredientList1.add(recipeIngredientRepository.save(new RecipeIngredient(ingredientRepository.findByNameIgnoreCase("Butter").get(), 3, Measurement.TBSP, recipe1)));
        recipe1.setRecipeIngredientList(ingredientList1);
        recipe1.setInstruction(recipeInstructionRepository.save(new RecipeInstruction("Just fry it")));
        List<Recipe> recipeList1 = new ArrayList<>();
        List<RecipeCategory> categoryList1 = new ArrayList<>();
        recipeList1.add(recipe1);
        categoryList1.add(recipeCategoryRepository.save(new RecipeCategory("Fish", recipeList1)));
        recipe1.setCategoryList(categoryList1);
        recipe1 = testObject.save(recipe1);

        Recipe recipe2 = new Recipe();
        recipe2.setName("Finnish croissants");
        List<RecipeIngredient> ingredientList2 = new ArrayList<>();
        ingredientList2.add(recipeIngredientRepository.save(new RecipeIngredient(ingredientRepository.findByNameIgnoreCase("Yeast").get(), 50, Measurement.G, recipe2)));
        ingredientList2.add(recipeIngredientRepository.save(new RecipeIngredient(ingredientRepository.findByNameIgnoreCase("Water").get(), 4, Measurement.DL, recipe2)));
        ingredientList2.add(recipeIngredientRepository.save(new RecipeIngredient(ingredientRepository.findByNameIgnoreCase("Salt").get(), 1, Measurement.TSP, recipe2)));
        ingredientList2.add(recipeIngredientRepository.save(new RecipeIngredient(ingredientRepository.findByNameIgnoreCase("White fine flour").get(), 10, Measurement.DL, recipe2)));
        recipe2.setRecipeIngredientList(ingredientList2);
        recipe2.setInstruction(recipeInstructionRepository.save(new RecipeInstruction("Just Bake it")));
        List<RecipeCategory> categoryList2 = new ArrayList<>();
        List<Recipe> recipeList2 = new ArrayList<>();
        recipeList2.add(recipe2);
        categoryList2.add(recipeCategoryRepository.save(new RecipeCategory("Baking", recipeList2)));
        recipe2.setCategoryList(categoryList2);
        recipe2 = testObject.save(recipe2);

        Recipe recipe3 = new Recipe();
        recipe3.setName("Brown rice porridge");
        List<RecipeIngredient> ingredientList3 = new ArrayList<>();
        ingredientList3.add(recipeIngredientRepository.save(new RecipeIngredient(ingredientRepository.findByNameIgnoreCase("Brown rice").get(), 2, Measurement.DL, recipe3)));
        ingredientList3.add(recipeIngredientRepository.save(new RecipeIngredient(ingredientRepository.findByNameIgnoreCase("Water").get(), 3, Measurement.DL, recipe3)));
        ingredientList3.add(recipeIngredientRepository.save(new RecipeIngredient(ingredientRepository.findByNameIgnoreCase("Salt").get(), 0.5, Measurement.TSP, recipe3)));
        ingredientList3.add(recipeIngredientRepository.save(new RecipeIngredient(ingredientRepository.findByNameIgnoreCase("Sugar").get(), 1, Measurement.TBSP, recipe3)));
        ingredientList3.add(recipeIngredientRepository.save(new RecipeIngredient(ingredientRepository.findByNameIgnoreCase("Milk").get(), 7, Measurement.DL, recipe3)));
        ingredientList3.add(recipeIngredientRepository.save(new RecipeIngredient(ingredientRepository.findByNameIgnoreCase("Cream").get(), 1, Measurement.DL, recipe3)));
        recipe3.setRecipeIngredientList(ingredientList3);
        recipe3.setInstruction(recipeInstructionRepository.save(new RecipeInstruction("Just boil it")));
        List<RecipeCategory> categoryList3 = new ArrayList<>();
        List<Recipe> recipeList3 = new ArrayList<>();
        recipeList3.add(recipe3);
        categoryList3.add(recipeCategoryRepository.save(new RecipeCategory("Rice", recipeList3)));
        recipe3.setCategoryList(categoryList3);
        recipe3 = testObject.save(recipe3);

    }

    @Test
    public void testFindByNameContains() {
        List<Recipe> foundRecipeList = testObject.findByNameIgnoreCaseContains("rice");
        Assertions.assertEquals(1, foundRecipeList.size());
        Assertions.assertEquals(3, foundRecipeList.get(0).getId());
        Assertions.assertEquals("Brown rice porridge", foundRecipeList.get(0).getName());
        //System.out.println("Found recipe list: " + foundRecipeList);
    }

    @Test
    public void testFindByIngredientName() {
        List<Recipe> foundRecipeList = testObject.findByIngredientName("Salt");
        //List<Recipe> foundRecipeList = testObject.findByRecipeIngredientList_Ingredient_Name("Salt");
        Assertions.assertEquals(3, foundRecipeList.size());
        Assertions.assertEquals(1, foundRecipeList.get(0).getId());
        Assertions.assertEquals("Fried herring", foundRecipeList.get(0).getName());
        Assertions.assertEquals(2, foundRecipeList.get(1).getId());
        Assertions.assertEquals("Finnish croissants", foundRecipeList.get(1).getName());
        Assertions.assertEquals(3, foundRecipeList.get(2).getId());
        Assertions.assertEquals("Brown rice porridge", foundRecipeList.get(2).getName());
        //System.out.println("Found recipe list: " + foundRecipeList);
    }
}
