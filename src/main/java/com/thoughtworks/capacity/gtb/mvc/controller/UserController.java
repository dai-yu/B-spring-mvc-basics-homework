package com.thoughtworks.capacity.gtb.mvc.controller;

import com.thoughtworks.capacity.gtb.mvc.domain.User;
import com.thoughtworks.capacity.gtb.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@RestController
@Validated
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid User user) {
        userService.register(user);
        return ResponseEntity.created(null).build();
    }

    @GetMapping("/login")
    public ResponseEntity<User> login(@RequestParam @Pattern(regexp = "\\w+", message = "username is invalid")
                                      @Size(min = 3, max = 10, message = "username should be between 3 and 10 characters long") String username,
                                      @RequestParam @Size(min = 5, max = 12, message = "password is invalid") String password) {
        User user = userService.login(username, password);
        return ResponseEntity.ok(user);
    }
}
