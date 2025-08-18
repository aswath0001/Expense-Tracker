package EM.example.EM.Repository;

import EM.example.EM.Entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface IncomeRepository extends JpaRepository<Income,Long> {
   
}

