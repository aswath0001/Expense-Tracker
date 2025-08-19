package EM.example.EM.Entity;
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
    private List<Expense> expensesPaid;

    @OneToMany(mappedBy = "receivedByUser")
    private List<Income> incomesReceived;

    @OneToMany(mappedBy = "payerUser")
    private List<SplitExpense> splitsOwed;


    @OneToMany(mappedBy = "payeeUser")
    private List<SplitExpense> splitsToReceive;
}
