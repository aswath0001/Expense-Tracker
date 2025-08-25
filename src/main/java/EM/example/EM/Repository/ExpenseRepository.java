package EM.example.EM.Repository;


import EM.example.EM.Entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    List<Expense> findByDateBetween(LocalDate startDate, LocalDate endDate);

    List<Expense> findByTitleContainingIgnoreCase(String title);

    @Query("SELECT e FROM Expense e WHERE LOWER(e.title) = LOWER(:title)")
    Optional<Expense> findByTitleIgnoreCase(@Param("title") String title);
}