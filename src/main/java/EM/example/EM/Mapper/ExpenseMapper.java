package EM.example.EM.Mapper;

import EM.example.EM.DTO.ExpenseDTO;
import EM.example.EM.Entity.Expense;
import org.springframework.stereotype.Component;

@Component
public class ExpenseMapper {

    public Expense toEntity(ExpenseDTO dto) {
        if (dto == null) {
            return null;
        }

        Expense expense = new Expense();
        expense.setTitle(dto.getTitle());
        expense.setCategory(dto.getCategory());
        expense.setDate(dto.getDate());
        expense.setAmount(dto.getAmount());
        expense.setDescription(dto.getDescription());
        return expense;
    }

    public ExpenseDTO toDTO(Expense entity) {
        if (entity == null) {
            return null;
        }

        ExpenseDTO dto = new ExpenseDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setCategory(entity.getCategory());
        dto.setDate(entity.getDate());
        dto.setAmount(entity.getAmount());
        dto.setDescription(entity.getDescription());
        return dto;
    }

    public void updateEntityFromDTO(ExpenseDTO dto, Expense entity) {
        if (dto == null || entity == null) {
            return;
        }

        entity.setTitle(dto.getTitle());
        entity.setCategory(dto.getCategory());
        entity.setDate(dto.getDate());
        entity.setAmount(dto.getAmount());
        entity.setDescription(dto.getDescription());
    }
}