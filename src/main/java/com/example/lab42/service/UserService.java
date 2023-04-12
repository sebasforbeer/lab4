package com.example.lab42.service;

import com.example.lab42.model.Comment;
import com.example.lab42.model.User;
import com.example.lab42.repository.CommentRepo;
import com.example.lab42.repository.UserRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService {

    private final UserRepo userRepo;
    private final CommentRepo commentRepo;

    @Autowired
    public UserService(UserRepo userRepo, CommentRepo commentRepo) {
        this.userRepo = userRepo;
        this.commentRepo = commentRepo;
    }

    @Transactional
    public ResponseEntity<?> addUser(String login) {
        if (userRepo.findByLogin(login) != null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        User user = new User();
        user.setLogin(login);
        userRepo.save(user);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<?> addComment(String login, String text) {
        User user = userRepo.findByLogin(login);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        Comment comment = new Comment();
        comment.setText(text);
        comment.setUser(user);
        commentRepo.save(comment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    public ResponseEntity<String> getUser(String login) {
        User user = userRepo.findByLogin(login);
        if (user == null) {
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }
        String userJson = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            userJson = objectMapper.writeValueAsString(user);
        }catch (JsonProcessingException aa){
            System.out.println("jopa");
        }

        return new ResponseEntity<>(userJson, HttpStatus.OK);

    }

}
