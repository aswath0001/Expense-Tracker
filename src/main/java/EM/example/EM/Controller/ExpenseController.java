package EM.example.EM.Controller;

import EM.example.EM.DTO.ExpenseDTO;
import EM.example.EM.Entity.Expense;
import EM.example.EM.Services.expense.ExpenseService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/expense")
@RequiredArgsConstructor
@CrossOrigin("*")

public class ExpenseController {

private  final ExpenseService expenseService;
@PostMapping
public ResponseEntity<?> postExpense (@RequestBody ExpenseDTO dto){
    Expense createExpense = expenseService.postExpense(dto);
    if(createExpense != null){
        return ResponseEntity.status(HttpStatus.CREATED).body(createExpense);
    }else  {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
@GetMapping("/all")
public ResponseEntity<?> getAllExpense(){
    return ResponseEntity.ok(expenseService.getAllExpense());
}
@GetMapping("/{id}")
    public  ResponseEntity<?> getExpenseById (@PathVariable Long id){
   try {
       return ResponseEntity.ok(expenseService.getExpenseById(id));
   }catch (EntityNotFoundException ex){
       return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
   }catch (Exception e ){
       return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
   }
} @GetMapping("/title/{title}")
    public ResponseEntity<?> getExpenseByTitle(@PathVariable String title) {
        try {
            return ResponseEntity.ok(expenseService.getExpenseByTitle(title));
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

@PutMapping("/{id}")
public ResponseEntity<?> updateExpense (@PathVariable Long id,@RequestBody ExpenseDTO dto){
    try {
        return ResponseEntity.ok(expenseService.updateExpense(id,dto));
    }catch (EntityNotFoundException ex){
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }catch (Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
    }
}

    @DeleteMapping("/{id}")
    public ResponseEntity<?> DeleteExpense (@PathVariable Long id){
        try {
            expenseService.deleteExpense(id);
            return ResponseEntity.ok(null);
        }catch (EntityNotFoundException ex){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }
    @GetMapping("/filter")
    public ResponseEntity<?> getExpensesByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate
    ) {
        try {
            List<Expense> expenses = expenseService.getExpenseByDateRange(startDate, endDate);
           if(expenses.isEmpty()){
               return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No expenses is found between "+ startDate+ " and "+endDate);
           }
return ResponseEntity.ok(expenses);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Invalid Data");
        }
    }
}
