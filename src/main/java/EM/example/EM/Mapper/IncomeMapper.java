package EM.example.EM.Mapper;


import EM.example.EM.DTO.IncomeDTO;
import EM.example.EM.Entity.Income;
import org.springframework.stereotype.Component;

@Component
public class IncomeMapper {

    public IncomeDTO toDTO(Income income) {
        if (income == null) return null;

        IncomeDTO dto = new IncomeDTO();
        dto.setId(income.getId());
        dto.setTitle(income.getTitle());
        dto.setCategory(income.getCategory());
        dto.setDate(income.getDate());
        dto.setAmount(income.getAmount());
        dto.setDescription(income.getDescription());
        return dto;
    }

    public Income toEntity(IncomeDTO dto) {
        if (dto == null) return null;

        Income income = new Income();
        income.setTitle(dto.getTitle());
        income.setCategory(dto.getCategory());
        income.setDate(dto.getDate());
        income.setAmount(dto.getAmount());
        income.setDescription(dto.getDescription());
        return income;
    }

    public void updateEntityFromDTO(IncomeDTO dto, Income entity) {
        if (dto == null || entity == null) return;

        entity.setTitle(dto.getTitle());
        entity.setCategory(dto.getCategory());
        entity.setDate(dto.getDate());
        entity.setAmount(dto.getAmount());
        entity.setDescription(dto.getDescription());
    }
}