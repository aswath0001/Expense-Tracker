package EM.example.EM.Entity;

import EM.example.EM.DTO.IncomeDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private Integer amount;
    private LocalDate date;
    private String category;
    private String description;

    public IncomeDTO getIncomeDTO(){
        IncomeDTO incomeDTO = new IncomeDTO();
        incomeDTO.setId(id);
        incomeDTO.setTitle(title);
        incomeDTO.setAmount(amount);
        incomeDTO.setCategory(category);
        incomeDTO.setDescription(description);
        incomeDTO.setDate(date);

        return incomeDTO;
    }

}
