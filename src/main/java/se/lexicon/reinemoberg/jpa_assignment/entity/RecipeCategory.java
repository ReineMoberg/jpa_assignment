package se.lexicon.reinemoberg.jpa_assignment.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class RecipeCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String category;

    @ManyToMany
    @JoinTable(name = "recipe_recipe_category",
            joinColumns = @JoinColumn(name = "recipe_category_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_id"))
    private List<Recipe> recipeList;

    public RecipeCategory() {
    }

    public RecipeCategory(String category, List<Recipe> recipeList) {
        this.category = category;
        this.recipeList = recipeList;
    }

    public RecipeCategory(int id, String category) {
        this.id = id;
        this.category = category;
    }

    public RecipeCategory(int id, String category, List<Recipe> recipeList) {
        this.id = id;
        this.category = category;
        this.recipeList = recipeList;
    }

    public void addRecipe(Recipe recipe) {
        if (recipe == null) {
            throw new IllegalArgumentException("recipe is null");
        }
        if (recipeList == null) {
            recipeList = new ArrayList<>();
        }
        if (!recipeList.contains(recipe)) {
            recipeList.add(recipe);
            recipe.getCategoryList().add(this);
        }
    }

    public void removeRecipe(Recipe recipe){
        if (recipe == null) {
            throw new IllegalArgumentException("recipe is null");
        }
        if (recipeList == null) {
            recipeList = new ArrayList<>();
        }
        if (recipeList.contains(recipe)) {
            recipe.getCategoryList().remove(this);
            recipeList.remove(recipe);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Recipe> getRecipeList() {
        return recipeList;
    }

    public void setRecipeList(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeCategory that = (RecipeCategory) o;
        return id == that.id && Objects.equals(category, that.category) && Objects.equals(recipeList, that.recipeList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category, recipeList);
    }

    @Override
    public String toString() {
        return "RecipeCategory{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", recipeList=" + recipeList +
                '}';
    }
}
