package se.lexicon.reinemoberg.jpa_assignment.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
            mappedBy = "recipe")
    private List<RecipeIngredient> recipeIngredientList;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "recipe_instruction_id")
    private RecipeInstruction instruction;

    @ManyToMany
    @JoinTable(name = "recipe_recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_category_id"))
    private List<RecipeCategory> categoryList;

    public Recipe() {
    }

    public Recipe(String name, List<RecipeIngredient> recipeIngredientList, RecipeInstruction instruction, List<RecipeCategory> categoryList) {
        this.name = name;
        this.recipeIngredientList = recipeIngredientList;
        this.instruction = instruction;
        this.categoryList = categoryList;
    }

    public Recipe(int id, String name, RecipeInstruction instruction) {
        this.id = id;
        this.name = name;
        this.instruction = instruction;
    }

    public Recipe(int id, String name, List<RecipeIngredient> recipeIngredientList, RecipeInstruction instruction, List<RecipeCategory> categoryList) {
        this.id = id;
        this.name = name;
        this.recipeIngredientList = recipeIngredientList;
        this.instruction = instruction;
        this.categoryList = categoryList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RecipeIngredient> getRecipeIngredientList() {
        return recipeIngredientList;
    }

    public void setRecipeIngredientList(List<RecipeIngredient> recipeIngredientList) {
        this.recipeIngredientList = recipeIngredientList;
    }

    public RecipeInstruction getInstruction() {
        return instruction;
    }

    public void setInstruction(RecipeInstruction instruction) {
        this.instruction = instruction;
    }

    public List<RecipeCategory> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<RecipeCategory> categoryList) {
        this.categoryList = categoryList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return id == recipe.id && Objects.equals(name, recipe.name) && Objects.equals(recipeIngredientList, recipe.recipeIngredientList) && Objects.equals(instruction, recipe.instruction) && Objects.equals(categoryList, recipe.categoryList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, recipeIngredientList, instruction, categoryList);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", recipeIngredientList=" + recipeIngredientList +
                ", instruction=" + instruction +
                ", categoryList=" + categoryList +
                '}';
    }
}
