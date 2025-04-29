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

    @PostMapping("/add")
    public ResponseEntity<UserEntity> add(@RequestBody UserEntity user){
        UserEntity userEntity = userRepository.save(user);

        return ResponseEntity.ok(userEntity);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserEntity>> getAll(){
        List<UserEntity> userEntity = userRepository.findAll();

        return ResponseEntity.ok(userEntity);
    }
}
