package recipes.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import recipes.entity.Recipe;
import recipes.entity.User;
import recipes.repository.RecipeRepository;
import recipes.service.exception.NotFoundException;

import java.util.ArrayList;
import java.util.List;
import recipes.service.exception.NotOwnRecipeException;

@Service
@Data
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public Recipe createRecipe(Recipe recipe, User user) {
        recipe.setOwner(user);
        return recipeRepository.save(recipe);
    }

    public Recipe updateRecipe(long id, Recipe recipe, User user) throws NotFoundException, NotOwnRecipeException {
        Recipe currentRecipe = recipeRepository.findOne(id);
        if (currentRecipe == null) {
            throw new NotFoundException();
        }
        long userID = currentRecipe.getOwner().getId();
        if (userID != user.getId()) {
            throw new NotOwnRecipeException();
        }
        recipe.setId(id);
        recipe.setOwner(user);
        return recipeRepository.save(recipe);
    }

    public void deleteRecipe(Long id) {
        recipeRepository.delete(id);
    }

    public List<Recipe> getRecipes() {
        List<Recipe> list = new ArrayList<>();
        recipeRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    public void addToFavourites(User user, long id) {
        Recipe recipe = recipeRepository.findOne(id);
        recipe.getFavouriteUsers().add(user);
        recipeRepository.save(recipe);
    }

    public void removeFromFavourites(User user, long id) {
        Recipe recipe = recipeRepository.findOne(id);
        recipe.getFavouriteUsers().remove(user);
        recipeRepository.save(recipe);
    }

    public Recipe getRecipeById(long id) {
        return recipeRepository.findOne(id);
    }

    public List<Recipe> getMyRecipes(User loggedInUser) {
        List<Recipe> list = new ArrayList<>();
        recipeRepository.getAllByOwner(loggedInUser).iterator().forEachRemaining(list::add);
        return list;
    }
}
