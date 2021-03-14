package se.lexicon.reinemoberg.jpa_assignment.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.reinemoberg.jpa_assignment.entity.RecipeInstruction;

import java.util.UUID;

public interface RecipeInstructionRepository extends CrudRepository<RecipeInstruction, UUID> {

}
