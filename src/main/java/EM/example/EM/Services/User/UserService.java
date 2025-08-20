package EM.example.EM.Services.User;

import EM.example.EM.DTO.UserDTO;
import EM.example.EM.Entity.User;

public interface UserService {
    User createUser(UserDTO userDTO);
}
