package se.lexicon.reinemoberg.jpa_assignment.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.reinemoberg.jpa_assignment.entity.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {

}
