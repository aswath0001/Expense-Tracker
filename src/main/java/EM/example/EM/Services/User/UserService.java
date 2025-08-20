package EM.example.EM.Services.User;

import EM.example.EM.DTO.UserDTO;
import EM.example.EM.Entity.User;

import java.util.List;

public interface UserService {
    User createUser(UserDTO userDTO);
    List <User>getAllUser();
   User getUserById(Long id);
   User updateUser(Long id,UserDTO userDTO);

}
