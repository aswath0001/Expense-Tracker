package EM.example.EM.Services.User;

import EM.example.EM.DTO.UserDTO;
import EM.example.EM.Entity.User;
import EM.example.EM.Repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public User createUser(UserDTO userDTO){
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setCurrentBalance(userDTO.getCurrentBalance());

        return userRepository.save(user);
    }
    @Override
    public List<User> getAllUser(){
return userRepository.findAll();
    }
    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
    }
    @Override
    public User updateUser(Long id,UserDTO userDTO){
        User existingUser =  getUserById(id);
        existingUser.setName(userDTO.getName());
        existingUser.setEmail(userDTO.getEmail());
        existingUser.setPassword(userDTO.getPassword());
        existingUser.setCurrentBalance(userDTO.getCurrentBalance());

        return userRepository.save(existingUser);
    }

}
