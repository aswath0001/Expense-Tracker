package EM.example.EM.Controller;

import EM.example.EM.DTO.IncomeDTO;
import EM.example.EM.Entity.Income;
import EM.example.EM.Services.income.IncomeService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/income")
@RequiredArgsConstructor
@CrossOrigin("*")

public class IncomeController {
    private final IncomeService incomeService;

    @PostMapping
    public ResponseEntity<?> postIncome (@RequestBody IncomeDTO dto){
        Income createIncome = incomeService.postIncome(dto);
        if(createIncome != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(createIncome);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @GetMapping("/all")
    public  ResponseEntity<?> getAllIncome (){
        return ResponseEntity.ok(incomeService.getAllIncome());
    }
    @PutMapping("/{id}")
public ResponseEntity<?> updateIncome (@PathVariable Long id, @RequestBody IncomeDTO incomeDTO){
        try {
            return ResponseEntity.ok(incomeService.updateIncome(id,incomeDTO));
        }catch (EntityNotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
}
@GetMapping("/{id}")
public  ResponseEntity<?> getIncomeById(@PathVariable Long id){
        try {
            return ResponseEntity.ok(incomeService.getIncomeById(id));
        }catch (EntityNotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }catch (Exception e ){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
}
}
