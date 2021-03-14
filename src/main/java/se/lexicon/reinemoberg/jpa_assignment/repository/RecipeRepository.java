package se.lexicon.reinemoberg.jpa_assignment.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import se.lexicon.reinemoberg.jpa_assignment.entity.Recipe;

import java.util.Collection;
import java.util.List;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {

    List<Recipe> findByNameIgnoreCaseContains(String name);

    @Query("select r from Recipe r " +
            "inner join RecipeIngredient ri " +
            "on r.id = ri.recipe.id " +
            "where lower(ri.ingredient.name) = lower(:nameParam)")
    List<Recipe> findByIngredientName(@Param("nameParam") String ingredientName);

    //This also works. Same as above
    //List<Recipe> findByRecipeIngredientList_Ingredient_Name(String ingredientName);

    List<Recipe> findByCategoryListCategoryIgnoreCase(String category);

    List<Recipe> findByCategoryListCategoryIgnoreCaseIn(Collection<String> categories);

}
