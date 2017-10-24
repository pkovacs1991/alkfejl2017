package recipes.repository;

import org.springframework.data.repository.CrudRepository;
import recipes.entity.Category;
import recipes.entity.Recipe;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    public Iterable<Recipe> findAllRecipesById(long id);

}
