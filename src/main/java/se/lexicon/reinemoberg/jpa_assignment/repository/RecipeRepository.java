package se.lexicon.reinemoberg.jpa_assignment.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.reinemoberg.jpa_assignment.entity.Recipe;

import java.util.Collection;
import java.util.List;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {

    List<Recipe> findByNameIgnoreCaseContains(String name);

    List<Recipe> findByRecipeIngredientListIngredientNameIgnoreCase(String ingredientName);

    List<Recipe> findByCategoryListCategoryIgnoreCase(String category);

    List<Recipe> findByCategoryListCategoryIgnoreCaseIn(Collection<String> categories);

}
