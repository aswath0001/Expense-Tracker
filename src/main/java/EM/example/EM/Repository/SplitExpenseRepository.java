package EM.example.EM.Repository;

import EM.example.EM.Entity.SplitExpense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SplitExpenseRepository extends JpaRepository<SplitExpense,Long> {
    List<SplitExpense> findByPayerUserId(Long payerId);
    List<SplitExpense> findByPayeeUserId(Long payeeId);
    List<SplitExpense> findByIsSettledFalse();
}
