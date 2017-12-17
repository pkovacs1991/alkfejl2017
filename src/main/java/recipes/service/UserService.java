package recipes.service;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.apache.commons.codec.digest.DigestUtils;
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
        String encryptedPassword = DigestUtils.sha1Hex(user.getPassword());
        user.setPassword(encryptedPassword);
        return this.user = userRepository.save(user);
    }

    public User login(User user) throws UserNotValidException {
        if (isValid(user)) {
            return this.user = userRepository.findByUsername(user.getUsername()).get();
        }
        throw new UserNotValidException();
    }

    public void logout() {
        user = null;
    }

    public List<User> getUsers() {
        List<User> list = new ArrayList<>();
        userRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }
    
    public User getLoggedInUser() {
        return user;
    }

    public boolean isLoggedIn() {
        return user != null;
    }

    public boolean isValid(User user) {
        String encryptedPassword = DigestUtils.sha1Hex(user.getPassword());

        return userRepository.findByUsernameAndPassword(
                user.getUsername(), encryptedPassword)
                .isPresent();
    }
    
    public void deleteUser(Long id) {
        userRepository.delete(id);
    }
}
