package EM.example.EM.Repository;

import EM.example.EM.Entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ExpenseRepository extends JpaRepository <Expense,Long> {
    Optional<Expense> findByTitle(String title);
    List<Expense> findByDateBetween(LocalDate startDate, LocalDate endDate);
}
