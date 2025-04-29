package com.example.demo_dockerize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/controller")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/hello")
    public ResponseEntity<?> getHello(@RequestBody UserEntity user){

        return ResponseEntity.ok("Hello World");
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserEntity>> getAll(){
        List<UserEntity> userEntity = userRepository.findAll();

        return ResponseEntity.ok(userEntity);
    }
}
