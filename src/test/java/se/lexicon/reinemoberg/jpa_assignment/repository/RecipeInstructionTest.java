package se.lexicon.reinemoberg.jpa_assignment.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.reinemoberg.jpa_assignment.entity.RecipeInstruction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@DataJpaTest
public class RecipeInstructionTest {

    @Autowired
    RecipeInstructionRepository testObject;

    @BeforeEach
    public void setup(){
        testObject.save(new RecipeInstruction("Just bake it"));
        testObject.save(new RecipeInstruction("Just fry it"));
        testObject.save(new RecipeInstruction("Just boil it"));
    }

    @Test
    public void testFindAll(){
        Iterable<RecipeInstruction> iterable = testObject.findAll();
        List<RecipeInstruction> result = new ArrayList<>();
        iterable.forEach(result::add);
        System.out.println("Found instructions: " + result);
    }
}
