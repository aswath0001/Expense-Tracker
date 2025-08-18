package EM.example.EM.Services.income;

import EM.example.EM.DTO.IncomeDTO;
import EM.example.EM.Entity.Income;
import EM.example.EM.Repository.IncomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IncomeServiceImpl implements IncomeService {

    private final IncomeRepository incomeRepository;

    public Income postIncome (IncomeDTO incomeDTO){
        return saveOrUpdateIncome(new Income() ,incomeDTO);
    }

    private Income saveOrUpdateIncome (Income income , IncomeDTO incomeDTO){
        income.setTitle(incomeDTO.getTitle());
        income.setDate(incomeDTO.getDate());
        income.setAmount(incomeDTO.getAmount());
        income.setCategory(incomeDTO.getCategory());
        income.setDescription(incomeDTO.getDescription());

        return incomeRepository.save(income);
    }

}
