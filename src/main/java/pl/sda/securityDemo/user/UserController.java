package pl.sda.securityDemo.user;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
class UserController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public String users() {
        return "user/list";
    }

    @PostMapping
    public String createUser() {
        User user = new User();
        user.setUsername("jim.beam");
        user.setPassword(passwordEncoder.encode("password"));
        userRepository.save(user);

        return "user/list";
    }
}
