package EM.example.EM.DTO;

import lombok.Data;

@Data

public class UserDTO {
    private String name;
    private String email;
    private String password;
    private Double currentBalance = 0.0;
}
