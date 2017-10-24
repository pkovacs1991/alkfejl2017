package recipes.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import recipes.entity.Category;
import recipes.entity.Recipe;
import recipes.repository.CategoryRepository;
import recipes.service.exception.NotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category updateCategory(long id, Category category) throws NotFoundException {
        if(categoryRepository.findOne(id) == null ) {
            throw new NotFoundException();
        }
        return categoryRepository.save(category);
    }

    public void deleteCategory(Long id) {
        categoryRepository.delete(id);
    }

    public List<Category> getCategories() {
        List<Category> list = new ArrayList<>();
        categoryRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    public Category getCategoryById(long id) {
        return categoryRepository.findOne(id);
    }

    public List<Recipe> getRecipesByCategoryId(long id) {
        //System.out.println(categoryRepository.findOne(id).getRecipes());
        return categoryRepository.findOne(id).getRecipes();
    }
}
