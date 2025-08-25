package EM.example.EM.Mapper;

import EM.example.EM.DTO.UserDTO;
import EM.example.EM.Entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDTO toDTO(User user) {
        if (user == null) return null;

        UserDTO dto = new UserDTO();
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        dto.setCurrentBalance(user.getCurrentBalance());
        return dto;
    }

    public User toEntity(UserDTO dto) {
        if (dto == null) return null;

        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setCurrentBalance(dto.getCurrentBalance());
        return user;
    }

    public void updateEntityFromDTO(UserDTO dto, User entity) {
        if (dto == null || entity == null) return;

        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setCurrentBalance(dto.getCurrentBalance());
    }
}