package pandemia.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pandemia.objects.entities.User;
import pandemia.services.UserService;

import java.util.Optional;

@RestController
public class RestHome {
    private final UserService userService;

    public RestHome(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public Optional<User> firstLog(){
        return this.userService.getUserById(1L);
    }

}
