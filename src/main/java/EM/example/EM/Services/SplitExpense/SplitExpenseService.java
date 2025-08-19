package EM.example.EM.Services.SplitExpense;

import EM.example.EM.DTO.SplitExpenseDTO;
import EM.example.EM.Entity.SplitExpense;

import java.util.List;

public interface SplitExpenseService {
    SplitExpense createSplitExpense(SplitExpenseDTO splitExpenseDTO);
   List<SplitExpense> getAllSplitExpenses();
   SplitExpense getSplitExpenseById (Long id);
   void deleteSplitExpense(Long id);
   SplitExpense updateSplitExpense(Long id,SplitExpenseDTO splitExpenseDTO);
}
