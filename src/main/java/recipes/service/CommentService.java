package recipes.service;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import recipes.entity.Comment;
import recipes.entity.User;
import recipes.repository.CommentRepository;
import recipes.service.exception.NotFoundException;
import recipes.service.exception.NotOwnCommentException;

@Service
@Data
public class CommentService {
    
    @Autowired
    private CommentRepository commentRepository;
    
    public List<Comment> getComments() {
        List<Comment> list = new ArrayList<>();
        commentRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }
    
    public List<Comment> getMyComments(User loggedInUser) {
        List<Comment> list = new ArrayList<>();
        commentRepository.getAllByUser(loggedInUser).iterator().forEachRemaining(list::add);
        return list;
    }
    
    public Comment getCommentById(long id) {
        return commentRepository.findOne(id);
    }
    
    public Comment createComment(Comment comment, User user) {
        comment.setUser(user);
        return commentRepository.save(comment);
    }
    
    public Comment updateComment(long id, Comment comment, User user) throws NotFoundException, NotOwnCommentException {
        Comment currentComment = commentRepository.findOne(id);
        if (currentComment == null) {
            throw new NotFoundException();
        }
        long userID = currentComment.getUser().getId();
        if (userID != user.getId()) {
            throw new NotOwnCommentException();
        }
        currentComment.setComment(comment.getComment());
        return commentRepository.save(currentComment);
    }
    
    public void deleteComment(Long id, User user) throws NotOwnCommentException {
        Comment comment = commentRepository.findOne(id);
        long userID = user.getId();
        if(userID != comment.getUser().getId())
            throw new NotOwnCommentException();
        commentRepository.delete(id);
    }
    
}
