package EM.example.EM.Services.expense;

import EM.example.EM.DTO.ExpenseDTO;
import EM.example.EM.Entity.Expense;

import java.time.LocalDate;
import java.util.List;

public interface ExpenseService {

     Expense postExpense(ExpenseDTO expenseDTO);
    List<Expense> getAllExpense();
    Expense getExpenseById (long id);
    Expense updateExpense (Long id,ExpenseDTO expenseDTO);
    void deleteExpense(long id);
    Expense getExpenseByTitle(String title);
    List<Expense> getExpenseByDateRange(LocalDate startDate, LocalDate endDate);
}
