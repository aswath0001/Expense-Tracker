package EM.example.EM.Controller;

import EM.example.EM.DTO.SplitExpenseDTO;
import EM.example.EM.Entity.SplitExpense;
import EM.example.EM.Services.SplitExpense.SplitExpenseService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.ContextNotEmptyException;
import java.util.List;

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
    @GetMapping("/all")
    public ResponseEntity<?>getAllSplitExpenses(){
        try {
            List <SplitExpense> split =splitExpenseService.getAllSplitExpenses();
            if(split.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No split expenses found");
            }
            return ResponseEntity.ok(split);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve split expenses");
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getSplitExpenseById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(splitExpenseService.getSplitExpenseById(id));
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve split expense");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteExpense(@PathVariable Long id){
        try{
            splitExpenseService.deleteSplitExpense(id);
            return ResponseEntity.noContent().build();
        }catch (EntityNotFoundException ex ){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete the expense");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSplitExpense(@PathVariable Long id, @RequestBody SplitExpenseDTO dto) {
        try {
            return ResponseEntity.ok(splitExpenseService.updateSplitExpense(id, dto));
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update split expense");
        }
    }
    @GetMapping("/payer/{payerId}")
    public ResponseEntity<?> getSplitByPayer(@PathVariable Long payerId){
        try {
            List<SplitExpense> splits = splitExpenseService.getExpenseByPayer(payerId);
            if(splits.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No split found for Payer");
            }
            return ResponseEntity.ok(splits);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrive splits by payer");
        }
    }
    @GetMapping("/payee/{payeeId}")
    public ResponseEntity<?> getExpenseByPayee(@PathVariable Long payeeId) {
        try {
            List<SplitExpense> splits = splitExpenseService.getExpenseByPayee(payeeId);
            if (splits.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No splits found for payee");
            }
            return ResponseEntity.ok(splits);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve splits by payee");
        }

    }
    @GetMapping("/unsettled")
    public ResponseEntity<?> getUnsettledSplits() {
        try {
            List<SplitExpense> unSettledSplits = splitExpenseService.getUnsettledSplits();

            if (unSettledSplits.isEmpty()) {
                throw new ContextNotEmptyException("No unsettled splits found ");
            }

            return ResponseEntity.ok(unSettledSplits);

        } catch (ContextNotEmptyException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to retrieve unsettled splits: " + e.getMessage());
        }
    }
}
