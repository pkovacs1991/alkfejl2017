package recipes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import recipes.entity.Category;
import recipes.entity.Recipe;
import recipes.service.CategoryService;
import recipes.service.annotation.Role;
import recipes.service.exception.NotFoundException;
import recipes.service.exception.UserNotValidException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static recipes.entity.User.Role.ADMIN;
import static recipes.entity.User.Role.USER;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    @Role({ADMIN})
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        return ResponseEntity.ok(categoryService.createCategory(category));
    }

    @PutMapping("/{id}")
    @Role({ADMIN})
    public ResponseEntity<Category> updateCategory(@PathVariable long id, @RequestBody Category category) {
        try {
            return ResponseEntity.ok(categoryService.updateCategory(id, category));
        } catch (NotFoundException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    @Role({ADMIN})
    public ResponseEntity<Map<String, String>> deleteCategory(@PathVariable long id) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Delete Success!" );
        categoryService.deleteCategory(id);
        return ResponseEntity.ok(response);
    }


    @GetMapping
    public ResponseEntity<List<Category>> getCategories() {
        return ResponseEntity.ok(categoryService.getCategories());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable long id) {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }


    @GetMapping("/recipes/{id}")
    public ResponseEntity<List<Recipe>> getRecipesByCategoryId(@PathVariable long id) {
        return ResponseEntity.ok(categoryService.getRecipesByCategoryId(id));
    }



}
