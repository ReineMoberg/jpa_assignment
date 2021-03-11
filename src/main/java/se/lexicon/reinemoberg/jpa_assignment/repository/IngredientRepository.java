package se.lexicon.reinemoberg.jpa_assignment.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.reinemoberg.jpa_assignment.entity.Ingredient;

import java.util.List;
import java.util.Optional;

public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {

    Optional<Ingredient> findByNameIgnoreCase(String name);

    List<Ingredient> findByNameIgnoreCaseContains(String name);

}
