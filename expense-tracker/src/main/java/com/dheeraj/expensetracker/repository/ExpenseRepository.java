package com.dheeraj.expensetracker.repository;

import com.dheeraj.expensetracker.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense,Long> {
  


    List<Expense> findByTitle(String title);
    @Query("SELECT SUM(e.amount) FROM Expense e")
    Double getTotalExpense();
    @Query("SELECT MAX(e.amount) FROM Expense e")
    Double getHighestExpense();
    @Query("SELECT AVG(e.amount) FROM Expense e")
    Double getAverageExpense();
    @Query("SELECT COUNT(e) FROM Expense e")
    Long getTotalTransactions();
    @Query("SELECT e FROM Expense e WHERE e.amount > :amount")
    List<Expense> getExpensesAboveAmount(@Param("amount") Double amount);
}
