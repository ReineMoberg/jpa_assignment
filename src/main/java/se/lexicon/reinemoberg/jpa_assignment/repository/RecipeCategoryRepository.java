package se.lexicon.reinemoberg.jpa_assignment.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.reinemoberg.jpa_assignment.entity.RecipeCategory;

public interface RecipeCategoryRepository extends CrudRepository<RecipeCategory, Integer> {

}
