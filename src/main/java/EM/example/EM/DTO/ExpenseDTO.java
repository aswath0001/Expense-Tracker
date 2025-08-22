package EM.example.EM.DTO;

import lombok.Data;

import java.time.Instant;
import java.time.LocalDate;

@Data
public class ExpenseDTO {
    private long id;
    private String title;
    private String category;
    private LocalDate date;
    private Instant Date1;
    private Integer amount;
    private String description;
}
