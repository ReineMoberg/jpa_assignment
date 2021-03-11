package se.lexicon.reinemoberg.jpa_assignment.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.reinemoberg.jpa_assignment.entity.Ingredient;

import java.util.List;
import java.util.Optional;

@DataJpaTest
public class IngredientRepositoryTest {

    @Autowired
    IngredientRepository testObject;

    @BeforeEach
    public void setup() {
        testObject.save(new Ingredient("Fresh herring"));
        testObject.save(new Ingredient("Salt"));
        testObject.save(new Ingredient("Breadcrumbs"));
        testObject.save(new Ingredient("Butter"));
        testObject.save(new Ingredient("Yeast"));
        testObject.save(new Ingredient("Water"));
        testObject.save(new Ingredient("White fine flour"));
    }

    @Test
    public void testFindByName() {
        Optional<Ingredient> foundIngredient = testObject.findByNameIgnoreCase("salt");
        Assertions.assertTrue(foundIngredient.isPresent());
        Assertions.assertEquals("Salt", foundIngredient.get().getName());
        System.out.println("Found ingredient: " + foundIngredient.get().toString());
    }

    @Test
    public void testFindByNameContains(){
        List<Ingredient> foundIngredientList = testObject.findByNameIgnoreCaseContains("herring");
        Assertions.assertEquals(1, foundIngredientList.size());
        Assertions.assertTrue(foundIngredientList.contains(new Ingredient(1, "Fresh herring")));
        System.out.println("Found ingredient list: " + foundIngredientList);
    }
}
