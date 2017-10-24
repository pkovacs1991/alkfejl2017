package recipes.repository;

import org.springframework.data.repository.CrudRepository;
import recipes.entity.Recipe;

public interface RecipeEntity extends CrudRepository<Recipe,Long> {
}
