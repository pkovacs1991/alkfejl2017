package recipes.repository;

import org.springframework.data.repository.CrudRepository;
import recipes.entity.Recipe;
import recipes.entity.User;

public interface RecipeRepository extends CrudRepository<Recipe,Long> {

    Iterable<Recipe> getAllByOwner(User owner);
}
