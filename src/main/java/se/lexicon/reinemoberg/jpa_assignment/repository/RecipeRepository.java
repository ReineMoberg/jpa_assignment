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

    @Query("select r from Recipe r " +
            "inner join RecipeCategory rc " +
            "on r.id = rc.id " +
            "where lower(rc.category) = lower(:categoryParam)")
    List<Recipe> findByCategory(@Param("categoryParam") String category);
    //This might work as replacement for above. Haven't tested.
    //List<Recipe> findByCategoryList_CategoryIgnoreCase(String category);

    @Query("select r from Recipe r " +
            "inner join RecipeCategory rc " +
            "on r.id = rc.id " +
            "where rc.category in :categoriesParam")
    List<Recipe> findByCategories(@Param("categoriesParam") Collection<String> categories);
    //This might work as replacement for above. Haven't tested.
    //List<Recipe> findByCategoryList_CategoryIgnoreCaseIn(Collection<String> categories);

}
