package EM.example.EM.DTO;

import lombok.Data;

@Data
public class SplitExpenseDTO {
private Long expenseId;
private Long payerId;
private Long PayeeId;
private Double amount;
}
