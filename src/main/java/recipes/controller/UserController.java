package recipes.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import recipes.entity.User;
import recipes.service.UserService;
import recipes.service.annotation.Role;
import recipes.service.exception.UserNotValidException;

import static recipes.entity.User.Role.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Role({USER,ADMIN})
    @GetMapping("/current")
    public ResponseEntity<User> user() {
        if (userService.isLoggedIn()) {
            return ResponseEntity.ok(userService.getUser());
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        try {
            return ResponseEntity.ok(userService.login(user));
        } catch (UserNotValidException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        return ResponseEntity.ok(userService.register(user));
    }

    @GetMapping("/logout")
    @Role({USER,ADMIN})
    public ResponseEntity<Map<String, String>> logout() {
        userService.logout();
        Map<String, String> response = new HashMap<>();
        response.put("message", "Logout success!" );
        return ResponseEntity.ok().body(response);
    }
    
    @GetMapping("")
    @Role({ADMIN})
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }


    @Role({ADMIN})
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Delete success!" );
        return ResponseEntity.ok(response);
    }
}
