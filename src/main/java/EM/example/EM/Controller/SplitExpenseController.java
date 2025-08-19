package EM.example.EM.Controller;

import EM.example.EM.DTO.SplitExpenseDTO;
import EM.example.EM.Entity.SplitExpense;
import EM.example.EM.Services.SplitExpense.SplitExpenseService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/split-expense")
@CrossOrigin("*")
public class SplitExpenseController {
    private final SplitExpenseService splitExpenseService;

    @PostMapping
    public ResponseEntity<?> createSplitExpense(@RequestBody SplitExpenseDTO dto){
        try {
            SplitExpense splitExpense = splitExpenseService.createSplitExpense(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(splitExpense);
        }catch (EntityNotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create split");
        }
    }

}
