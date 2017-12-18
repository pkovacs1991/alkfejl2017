package recipes.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import recipes.entity.Comment;
import static recipes.entity.User.Role.ADMIN;
import static recipes.entity.User.Role.USER;
import recipes.service.CommentService;
import recipes.service.UserService;
import recipes.service.annotation.Role;
import recipes.service.exception.NotFoundException;
import recipes.service.exception.NotOwnCommentException;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    
    @Autowired
    CommentService commentService;
    
    @Autowired
    UserService userService;
    
    @GetMapping
    public ResponseEntity<List<Comment>> getComments() {
        return ResponseEntity.ok(commentService.getComments());
    }
    
    @GetMapping("/my")
    @Role({ADMIN,USER})
    public ResponseEntity<List<Comment>> getMyComments() {
        return ResponseEntity.ok(commentService.getMyComments(userService.getLoggedInUser()));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Comment> getRecipeById(@PathVariable long id) {
        return ResponseEntity.ok(commentService.getCommentById(id));
    }
    
    @PostMapping
    @Role({ADMIN,USER})
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
        return ResponseEntity.ok(commentService.createComment(comment,userService.getLoggedInUser()));
    }
    
    @PutMapping("/{id}")
    @Role({ADMIN,USER})
    public ResponseEntity<Comment> updateComment(@PathVariable long id, @RequestBody Comment comment) {
        try {
            return ResponseEntity.ok(commentService.updateComment(id, comment ,userService.getLoggedInUser()));
        } catch (NotFoundException | NotOwnCommentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @DeleteMapping("/{id}")
    @Role({ADMIN,USER})
    public ResponseEntity<Map<String, String>> deleteComment(@PathVariable long id) {
        try{
            commentService.deleteComment(id, userService.getLoggedInUser());
            Map<String, String> response = new HashMap<>();
            response.put("message", "Delete Success!" );
            return ResponseEntity.ok(response);
        }catch(NotOwnCommentException e){
            return ResponseEntity.badRequest().build();
        }
    }
}
