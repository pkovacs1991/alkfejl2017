package recipes.repository;

import org.springframework.data.repository.CrudRepository;
import recipes.entity.Comment;
import recipes.entity.User;

public interface CommentRepository extends CrudRepository<Comment,Long> {
    
    Iterable<Comment> getAllByUser(User user);
    
}
