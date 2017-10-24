package recipes.repository;

import org.springframework.data.repository.CrudRepository;
import recipes.entity.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
