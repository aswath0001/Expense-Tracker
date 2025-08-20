package EM.example.EM.Services.User;

import EM.example.EM.DTO.UserDTO;
import EM.example.EM.Entity.User;
import EM.example.EM.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
