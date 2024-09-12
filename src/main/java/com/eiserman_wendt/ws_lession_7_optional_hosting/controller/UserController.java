package com.eiserman_wendt.ws_lession_7_optional_hosting.controller;


import com.eiserman_wendt.ws_lession_7_optional_hosting.model.User;
import com.eiserman_wendt.ws_lession_7_optional_hosting.repository.UserRepository;
import com.eiserman_wendt.ws_lession_7_optional_hosting.response.ErrorResponse;
import com.eiserman_wendt.ws_lession_7_optional_hosting.response.UserResponse;
import com.eiserman_wendt.ws_lession_7_optional_hosting.response.WsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    
    private final UserRepository userRepository;
    
    
    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    
    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }
    
    
    @GetMapping("/{id}")
    public ResponseEntity<WsResponse> getUserById(@PathVariable("id") Long id) {
        Optional<User> user = userRepository.findById(id);
        
        if (user.isPresent()) {
            return ResponseEntity.ok(new UserResponse(user.get()));
        }
        
        return ResponseEntity.status(204).body(new ErrorResponse("User did not exist, try again"));
    }
    
    @PostMapping()
    public ResponseEntity<User> postUser(@RequestBody User user){
        return ResponseEntity.ok(userRepository.save(user));
    }

}
