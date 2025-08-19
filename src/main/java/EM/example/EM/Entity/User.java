package EM.example.EM.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    private Double currentBalance = 0.0;

    @OneToMany(mappedBy = "paidByUser")
    @JsonIgnore
    private List<Expense> expensesPaid;

    @OneToMany(mappedBy = "receivedByUser")
    @JsonIgnore
    private List<Income> incomesReceived;

    @OneToMany(mappedBy = "payerUser")
    @JsonIgnore
    private List<SplitExpense> splitsOwed;


    @OneToMany(mappedBy = "payeeUser")
    @JsonIgnore
    private List<SplitExpense> splitsToReceive;
}
