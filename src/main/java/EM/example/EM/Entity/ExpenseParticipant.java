package EM.example.EM.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class ExpenseParticipant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "expense_id")
    private Expense expense;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Double shareAmount;
}
