package EM.example.EM.Controller;

import EM.example.EM.DTO.UserDTO;
import EM.example.EM.Entity.User;
import EM.example.EM.Services.User.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
@GetMapping("/all")
public ResponseEntity<?> getAllUser(){
    try {
        List<User> users = userService.getAllUser();
        if(users.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No user found");
        }
        return ResponseEntity.ok(users);
    }catch (Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to fetch user");
    }

}
@GetMapping("/{id}")
public ResponseEntity<?> getUserById(@PathVariable Long id) {
    try {
        return ResponseEntity.ok(userService.getUserById(id));
    } catch (EntityNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Failed to retrieve user: " + e.getMessage());
    }
}

@PutMapping("/{id}")
    public  ResponseEntity<?> updateUser(@PathVariable Long id,@RequestBody UserDTO userDTO){
    try {
        return ResponseEntity.ok(userService.updateUser(id,userDTO));
    }catch (EntityNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }catch (Exception e){

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Failed to update user");
    }
}

}
