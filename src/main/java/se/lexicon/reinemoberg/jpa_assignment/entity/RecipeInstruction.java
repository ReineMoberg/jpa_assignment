package se.lexicon.reinemoberg.jpa_assignment.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;
import java.util.UUID;

@Entity
public class RecipeInstruction {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "uuid-char")
    private UUID id;

    @Column(length = 1500)
    private String instructions;

    public RecipeInstruction() {
    }

    public RecipeInstruction(String instructions) {
        this.instructions = instructions;
    }

    public RecipeInstruction(UUID id, String instructions) {
        this.id = id;
        this.instructions = instructions;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeInstruction that = (RecipeInstruction) o;
        return Objects.equals(id, that.id) && Objects.equals(instructions, that.instructions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, instructions);
    }

    @Override
    public String toString() {
        return "RecipeInstruction{" +
                "id=" + id +
                ", instructions='" + instructions + '\'' +
                '}';
    }
}
