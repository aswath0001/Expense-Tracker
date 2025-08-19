package EM.example.EM.Services.SplitExpense;

import EM.example.EM.DTO.SplitExpenseDTO;
import EM.example.EM.Entity.Expense;
import EM.example.EM.Entity.SplitExpense;
import EM.example.EM.Entity.User;
import EM.example.EM.Repository.ExpenseRepository;
import EM.example.EM.Repository.SplitExpenseRepository;
import EM.example.EM.Repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SplitExpenseServiceImpl implements SplitExpenseService{
    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;
    private final SplitExpenseRepository splitExpenseRepository;

    @Override
    public SplitExpense createSplitExpense(SplitExpenseDTO splitExpenseDTO) {
        User payer = userRepository.findById(splitExpenseDTO.getPayerId())
                .orElseThrow(()->new EntityNotFoundException("Payer not found with id "+ splitExpenseDTO.getPayerId()));
        User payee = userRepository.findById(splitExpenseDTO.getPayeeId())
                .orElseThrow(()->new EntityNotFoundException("Payee not found with id "+ splitExpenseDTO.getPayeeId()));
        Expense expense = expenseRepository.findById(splitExpenseDTO.getExpenseId())
                .orElseThrow(()->new EntityNotFoundException("No expenses found with id"+ splitExpenseDTO.getExpenseId()));

        SplitExpense splitExpense = new SplitExpense();
       splitExpense.setPayerUser(payer);
       splitExpense.setPayeeUser(payee);
       splitExpense.setExpense(expense);
       splitExpense.setAmount(splitExpenseDTO.getAmount());
       splitExpense.setIsSettled(false);

       payer.setCurrentBalance(payer.getCurrentBalance()-splitExpense.getAmount());
       payee.setCurrentBalance(payee.getCurrentBalance()-splitExpense.getAmount());

       userRepository.save(payee);
       userRepository.save(payer);
       return splitExpenseRepository.save(splitExpense);
    }
}
