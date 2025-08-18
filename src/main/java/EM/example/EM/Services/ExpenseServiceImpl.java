package EM.example.EM.Services;

import EM.example.EM.DTO.ExpenseDTO;
import EM.example.EM.Entity.Expense;
import EM.example.EM.Repository.ExpenseRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;

    public Expense postExpense(ExpenseDTO expenseDTO) {
        return saveOrUpdateExpense(new Expense(), expenseDTO);
    }

    private Expense saveOrUpdateExpense(Expense expense, ExpenseDTO expenseDTO) {
        expense.setTitle(expenseDTO.getTitle());
        expense.setDate(expenseDTO.getDate());
        expense.setAmount(expenseDTO.getAmount());
        expense.setCategory(expenseDTO.getCategory());
        expense.setDescription(expenseDTO.getDescription());

        return expenseRepository.save(expense);
    }

    public Expense updateExpense (Long id,ExpenseDTO expenseDTO){
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if(optionalExpense.isPresent()){
            return saveOrUpdateExpense(optionalExpense.get(),expenseDTO);
        }else{
            throw new EntityNotFoundException("Expense is not present for Id "+ id);
        }
    }


    public List <Expense> getAllExpense() {
        return expenseRepository.findAll().stream()
                .sorted(Comparator.comparing(Expense::getDate).reversed())
                .collect(Collectors.toList());

    }
    public  Expense getExpenseById (long id){
        Optional <Expense> optionalExpense = expenseRepository.findById(id);
       if(optionalExpense.isPresent()){
           return optionalExpense.get();
       }else  {
           throw  new EntityNotFoundException("Expense is not present for the Id "+id);
       }
    }
}