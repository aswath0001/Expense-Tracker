package EM.example.EM.Controller;

import EM.example.EM.DTO.IncomeDTO;
import EM.example.EM.Entity.Income;
import EM.example.EM.Services.income.IncomeService;
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
}
