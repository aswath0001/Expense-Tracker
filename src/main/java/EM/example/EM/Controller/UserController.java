package EM.example.EM.Controller;

import EM.example.EM.DTO.UserDTO;
import EM.example.EM.Entity.User;
import EM.example.EM.Services.User.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {
private final UserService userService;

@PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO){
    try {
        User user = userService.createUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }catch (EntityNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }catch (Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to create user");
    }
}
}
