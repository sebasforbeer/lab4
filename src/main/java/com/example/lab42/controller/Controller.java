package com.example.lab42.controller;

import com.example.lab42.model.Add_comment_json;
import com.example.lab42.model.Add_user_json;
import com.example.lab42.model.User;
import com.example.lab42.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/execute")
public class Controller {
    private final UserService userService;

    @Autowired
    public Controller(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add_user")
    public ResponseEntity<?> addUser(@RequestBody Add_user_json json) {
        return userService.addUser(json.getLogin());
    }

    @PostMapping("/add_comment")
    public ResponseEntity<?> addComment(@RequestBody Add_comment_json json) {
        return userService.addComment(json.getLogin(), json.getComment());
    }

    @GetMapping("/comments")
    public ResponseEntity<?> getUsers(@RequestParam String login) {

        return userService.getUser(login);
    }
}
