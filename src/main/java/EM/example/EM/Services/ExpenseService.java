package EM.example.EM.Services;

import EM.example.EM.DTO.ExpenseDTO;
import EM.example.EM.Entity.Expense;

import java.util.List;

public interface ExpenseService {

     Expense postExpense(ExpenseDTO expenseDTO);
    List<Expense> getAllExpense();
    Expense getExpenseById (long id);
    Expense updateExpense (Long id,ExpenseDTO expenseDTO);
}
