package EM.example.EM.Services.SplitExpense;

import EM.example.EM.DTO.ExpenseDTO;
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

import java.util.List;

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

    @Override
    public List<SplitExpense> getAllSplitExpenses() {
        return splitExpenseRepository.findAll();
    }
    @Override
    public SplitExpense getSplitExpenseById(Long id){
return splitExpenseRepository.findById( id)
        .orElseThrow(()->new  EntityNotFoundException("split expense not found for id"+id));
    }
    @Override
    public void deleteSplitExpense(Long id) {
        SplitExpense splitExpense = getSplitExpenseById(id);


        User payer = splitExpense.getPayerUser();
        User payee = splitExpense.getPayeeUser();
        payer.setCurrentBalance(payer.getCurrentBalance() + splitExpense.getAmount());
        payee.setCurrentBalance(payee.getCurrentBalance() - splitExpense.getAmount());

        userRepository.save(payer);
        userRepository.save(payee);
        splitExpenseRepository.delete(splitExpense);
    }
    @Override
    public SplitExpense updateSplitExpense(Long id, SplitExpenseDTO splitExpenseDTO) {
        SplitExpense existingSplit = getSplitExpenseById(id);


        User oldPayer = existingSplit.getPayerUser();
        User oldPayee = existingSplit.getPayeeUser();
        oldPayer.setCurrentBalance(oldPayer.getCurrentBalance() + existingSplit.getAmount());
        oldPayee.setCurrentBalance(oldPayee.getCurrentBalance() - existingSplit.getAmount());


        User newPayer = userRepository.findById(splitExpenseDTO.getPayerId())
                .orElseThrow(() -> new EntityNotFoundException("Payer not found"));
        User newPayee = userRepository.findById(splitExpenseDTO.getPayeeId())
                .orElseThrow(() -> new EntityNotFoundException("Payee not found"));

        existingSplit.setPayerUser(newPayer);
        existingSplit.setPayeeUser(newPayee);
        existingSplit.setAmount(splitExpenseDTO.getAmount());


        newPayer.setCurrentBalance(newPayer.getCurrentBalance() - splitExpenseDTO.getAmount());
        newPayee.setCurrentBalance(newPayee.getCurrentBalance() + splitExpenseDTO.getAmount());

        userRepository.save(oldPayer);
        userRepository.save(oldPayee);
        userRepository.save(newPayer);
        userRepository.save(newPayee);

        return splitExpenseRepository.save(existingSplit);
    }

    @Override
    public List<SplitExpense> getExpenseByPayer(Long payerId) {
        return splitExpenseRepository.findByPayerUserId(payerId);
    }

    @Override
    public List<SplitExpense> getExpenseByPayee(Long payeeId){
        return splitExpenseRepository.findByPayeeUserId(payeeId);
    }
    @Override
    public   List<SplitExpense> getUnsettledSplits(){
        return splitExpenseRepository.findByIsSettledFalse();
    }
}

