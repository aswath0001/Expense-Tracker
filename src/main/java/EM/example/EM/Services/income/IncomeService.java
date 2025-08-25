package EM.example.EM.Services.income;

import EM.example.EM.DTO.IncomeDTO;
import EM.example.EM.Entity.Income;

import java.util.List;

public interface IncomeService {
    IncomeDTO createIncome(IncomeDTO incomeDTO);
    List<IncomeDTO> getAllIncome();
    IncomeDTO updateIncome(Long id, IncomeDTO incomeDTO);
    IncomeDTO getIncomeById(Long id);
    void deleteIncome(Long id);
}

