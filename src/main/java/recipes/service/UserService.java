package recipes.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import recipes.entity.User;
import recipes.repository.UserRepository;
import recipes.service.exception.UserNotValidException;

@SessionScope
@Service
@Data
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private User user;

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public User register(User user) {
        return this.user = userRepository.save(user);
    }

    public User login(User user) throws UserNotValidException {
        if (isValid(user)) {
            return this.user = userRepository.findByUsername(user.getUsername()).get();
        }
        throw new UserNotValidException();
//        return null;
    }

    public void logout() {
        user = null;
    }

    public User getLoggedInUser() {
        return user;
    }

    public boolean isLoggedIn() {
        return user != null;
    }

    public boolean isValid(User user) {
        return userRepository.findByUsernameAndPassword(
                user.getUsername(), user.getPassword())
                .isPresent();
    }
    
    public void deleteUser(Long id) {
        userRepository.delete(id);
    }
}