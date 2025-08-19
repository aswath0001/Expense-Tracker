package EM.example.EM.Entity;

import EM.example.EM.DTO.IncomeDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "received_by_user_id")
    private User receivedByUser;
    private Boolean isSplitSettlement = false;

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
