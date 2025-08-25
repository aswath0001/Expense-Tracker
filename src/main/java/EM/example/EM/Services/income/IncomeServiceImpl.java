package EM.example.EM.Services.income;


import EM.example.EM.DTO.IncomeDTO;
import EM.example.EM.Entity.Income;
import EM.example.EM.Exception.IncomeNotFoundException;
import EM.example.EM.Mapper.IncomeMapper;
import EM.example.EM.Repository.IncomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class IncomeServiceImpl implements IncomeService {

    private final IncomeRepository incomeRepository;
    private final IncomeMapper incomeMapper;

    @Override
    @Transactional
    public IncomeDTO createIncome(IncomeDTO incomeDTO) {
        Income income = incomeMapper.toEntity(incomeDTO);
        Income savedIncome = incomeRepository.save(income);
        return incomeMapper.toDTO(savedIncome);
    }

    @Override
    @Transactional(readOnly = true)
    public List<IncomeDTO> getAllIncome() {
        return incomeRepository.findAll().stream()
                .sorted(Comparator.comparing(Income::getDate).reversed())
                .map(incomeMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public IncomeDTO updateIncome(Long id, IncomeDTO incomeDTO) {
        Income existingIncome = incomeRepository.findById(id)
                .orElseThrow(() -> new IncomeNotFoundException(id));

        incomeMapper.updateEntityFromDTO(incomeDTO, existingIncome);
        Income updatedIncome = incomeRepository.save(existingIncome);
        return incomeMapper.toDTO(updatedIncome);
    }

    @Override
    @Transactional(readOnly = true)
    public IncomeDTO getIncomeById(Long id) {
        Income income = incomeRepository.findById(id)
                .orElseThrow(() -> new IncomeNotFoundException(id));
        return incomeMapper.toDTO(income);
    }

    @Override
    @Transactional
    public void deleteIncome(Long id) {
        if (!incomeRepository.existsById(id)) {
            throw new IncomeNotFoundException(id);
        }
        incomeRepository.deleteById(id);
    }
}