package EM.example.EM.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class SplitExpense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "expense_id")
    private Expense expense;

    @ManyToOne
    @JoinColumn(name = "payer_user_id")
    private User payerUser;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "payee_user_id")
    private User payeeUser;

    private Double amount;
    private Boolean isSettled = false;
    private LocalDate settlementDate;
}
