package recipes.repository;

import org.springframework.data.repository.CrudRepository;
import recipes.entity.User;

import java.util.Optional;

public interface UserRepository  extends CrudRepository<User, Long> {

    Optional<User> findByUsernameAndPassword(String username, String password);

    Optional<User> findByUsername(String username);
}
