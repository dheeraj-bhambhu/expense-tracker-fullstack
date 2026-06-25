package com.dheeraj.expensetracker.service;

import com.dheeraj.expensetracker.dto.AnalyticsResponseDTO;
import com.dheeraj.expensetracker.dto.ExpenseRequestDTO;
import com.dheeraj.expensetracker.dto.ExpenseResponseDTO;
import com.dheeraj.expensetracker.entity.Expense;
import com.dheeraj.expensetracker.exception.ResourceNotFoundException;
import com.dheeraj.expensetracker.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public ExpenseResponseDTO createExpense(ExpenseRequestDTO requestDTO) {

        Expense expense = new Expense();

        expense.setTitle(requestDTO.getTitle());
        expense.setAmount(requestDTO.getAmount());
        expense.setDescription(requestDTO.getDescription());

        Expense savedExpense = expenseRepository.save(expense);

        ExpenseResponseDTO responseDTO = new ExpenseResponseDTO();

        responseDTO.setId(savedExpense.getId());
        responseDTO.setTitle(savedExpense.getTitle());
        responseDTO.setAmount(savedExpense.getAmount());
        responseDTO.setDescription(savedExpense.getDescription());

        return responseDTO;
    }


    public List<Expense> getAllexpenses() {
        return expenseRepository.findAll();
    }

    public Expense getExpenseById(Long id) {
        return expenseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Expense not found"));
    }

    public Expense updateExpense(Long id, Expense expense) {
        Expense existingExpense = expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found"));
        existingExpense.setTitle(expense.getTitle());
        existingExpense.setAmount(expense.getAmount());

        return expenseRepository.save(existingExpense);
    }

    public void deleteExpense(Long id) {
        Expense Existingexpense = expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found"));
        expenseRepository.delete(Existingexpense);
    }
    public AnalyticsResponseDTO getAnalytics() {

        List<Expense> expenses = expenseRepository.findAll();

        double totalExpense = 0;
        double highestExpense = 0;
        long totalTransactions = expenses.size();

        for (Expense expense : expenses) {

            totalExpense += expense.getAmount();

            if (expense.getAmount() > highestExpense) {
                highestExpense = expense.getAmount();
            }
        }

        double averageExpense = 0;

        if (!expenses.isEmpty()) {
            averageExpense = totalExpense / totalTransactions;
        }

        AnalyticsResponseDTO response = new AnalyticsResponseDTO();

        response.setTotalExpense(totalExpense);
        response.setHighestExpense(highestExpense);
        response.setAverageExpense(averageExpense);
        response.setTotalTransactions(totalTransactions);

        return response;
    }
}
