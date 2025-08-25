package EM.example.EM.Services.expense;

import EM.example.EM.DTO.ExpenseDTO;
import EM.example.EM.Entity.Expense;

import java.time.LocalDate;
import java.util.List;
// ExpenseService Interface
public interface ExpenseService {
    ExpenseDTO createExpense(ExpenseDTO expenseDTO);
    List<ExpenseDTO> getAllExpenses();
    ExpenseDTO getExpenseById(Long id);
    ExpenseDTO updateExpense(Long id, ExpenseDTO expenseDTO);
    void deleteExpense(Long id);
    List<ExpenseDTO> getExpensesByTitle(String title);
    List<ExpenseDTO> getExpensesByDateRange(LocalDate startDate, LocalDate endDate);
}