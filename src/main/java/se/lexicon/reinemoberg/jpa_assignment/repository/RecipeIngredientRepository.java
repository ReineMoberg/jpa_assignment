package se.lexicon.reinemoberg.jpa_assignment.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.reinemoberg.jpa_assignment.entity.RecipeIngredient;

import java.util.UUID;

public interface RecipeIngredientRepository extends CrudRepository<RecipeIngredient, UUID> {

}
