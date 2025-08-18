package EM.example.EM.Services.income;

import EM.example.EM.DTO.IncomeDTO;
import EM.example.EM.Entity.Income;

import java.util.List;

public interface IncomeService {
    Income postIncome (IncomeDTO incomeDTO);
    List<IncomeDTO> getAllIncome();
    Income updateIncome (Long id, IncomeDTO incomeDTO);
}
