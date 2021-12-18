package rs.raf.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import rs.raf.demo.model.User;
import rs.raf.demo.repositories.UserRepository;
import rs.raf.demo.services.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/me", produces = MediaType.APPLICATION_JSON_VALUE)
    public User me() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return this.userService.findByUsername(username);
    }

    @PostMapping(value = "/hire", produces = MediaType.APPLICATION_JSON_VALUE)
    public User hire(@RequestParam("salary") Integer salary) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return this.userService.hire(username, salary);
    }
}
