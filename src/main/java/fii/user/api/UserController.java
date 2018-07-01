package fii.user.api;

import fii.user.User;
import fii.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/login", consumes = "application/json")
    public UserAuthentification login(@RequestBody LoginDTO login) {
        User user = userService.findByUsername(login.getUsername());
        if (user != null && user.getPassword().equals(login.getPassword())) {
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            userService.save(user);
            return new UserAuthentification(user.getId(), token);
        }
        throw new RuntimeException("Invalid login");
    }
}
