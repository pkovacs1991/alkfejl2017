package recipes.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import recipes.entity.Recipe;
import recipes.service.RecipeService;
import recipes.service.UserService;
import recipes.service.annotation.Role;
import recipes.service.exception.NotFoundException;

import java.util.List;

import static recipes.entity.User.Role.ADMIN;
import static recipes.entity.User.Role.USER;
import recipes.service.exception.NotOwnRecipeException;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private UserService userService;

    @PostMapping
    @Role({ADMIN,USER})
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {
        return ResponseEntity.ok(recipeService.createRecipe(recipe,userService.getLoggedInUser()));
    }

    @PutMapping("/{id}")
    @Role({ADMIN,USER})
    public ResponseEntity<Recipe> updateRecipe(@PathVariable long id, @RequestBody Recipe recipe) {
        try {
            return ResponseEntity.ok(recipeService.updateRecipe(id, recipe,userService.getLoggedInUser()));
        } catch (NotFoundException | NotOwnRecipeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    @Role({ADMIN,USER})
    public ResponseEntity<String> deleteRecipe(@PathVariable long id) {
        recipeService.deleteRecipe(id);
        return ResponseEntity.ok("Delete Success!");
    }


    @GetMapping
    public ResponseEntity<List<Recipe>> getRecipes() {
        return ResponseEntity.ok(recipeService.getRecipes());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable long id) {
        return ResponseEntity.ok(recipeService.getRecipeById(id));
    }

    @GetMapping("/my")
    @Role({ADMIN,USER})
    public ResponseEntity<List<Recipe>> getMyRecipe() {
        return ResponseEntity.ok(recipeService.getMyRecipes(userService.getLoggedInUser()));
    }

    @PostMapping("/favourites/{id}")
    @Role({ADMIN,USER})
    public ResponseEntity<String> addToFavourites(@PathVariable long id) {
        recipeService.addToFavourites(userService.getLoggedInUser(),id);
        return ResponseEntity.ok("Successfully added to favorites");
    }

    @DeleteMapping("/favourites/{id}")
    @Role({ADMIN,USER})
    public ResponseEntity<String> deleteFromFavourites(@PathVariable long id) {
        recipeService.removeFromFavourites(userService.getLoggedInUser(),id);
        return ResponseEntity.ok("Successfully deleted from favorites");
    }
}
