package EM.example.EM.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String category;
    private LocalDate date;
    private Integer amount;
    private String description;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "paid_by_user_id")
    private User paidByUser;

    private Boolean isSplitExpense = false;

    @OneToMany(mappedBy = "expense")
    @JsonIgnore
    private List<ExpenseParticipant>participants;

    @OneToMany(mappedBy = "expense")
    @JsonIgnore
    private List<SplitExpense> splits;

}
