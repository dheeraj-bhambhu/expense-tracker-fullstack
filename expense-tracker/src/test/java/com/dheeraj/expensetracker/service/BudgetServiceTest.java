package com.dheeraj.expensetracker.service;
import com.dheeraj.expensetracker.entity.Budget;
import com.dheeraj.expensetracker.repository.BudgetRepository;
import com.dheeraj.expensetracker.service.BudgetService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.dheeraj.expensetracker.repository.UserRepository;
import com.dheeraj.expensetracker.dto.BudgetRequestDTO;
import com.dheeraj.expensetracker.dto.BudgetResponseDTO;
import com.dheeraj.expensetracker.entity.User;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import com.dheeraj.expensetracker.repository.ExpenseRepository;
import com.dheeraj.expensetracker.entity.Expense;
@ExtendWith(MockitoExtension.class)
class BudgetServiceTest {

    @Mock
    private ExpenseRepository expenseRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private BudgetRepository budgetRepository;

    @InjectMocks
    private BudgetService budgetService;


    @Test
    void testSetBudget() {

        BudgetRequestDTO request = new BudgetRequestDTO();
        request.setMonthlyBudget(5000.0);

        User user = new User();
        user.setId(1L);

        Budget savedBudget = new Budget();
        savedBudget.setMonthlyBudget(5000.0);
        savedBudget.setUser(user);

        when(userRepository.findAll())
                .thenReturn(List.of(user));

        when(budgetRepository.save(any(Budget.class)))
                .thenReturn(savedBudget);

        BudgetResponseDTO response = budgetService.setBudget(request);

        assertEquals(5000.0, response.getMonthlyBudget());

        verify(userRepository, times(1)).findAll();
        verify(budgetRepository, times(1)).save(any(Budget.class));
    }
    @Test
    void testGetBudgetSummary() {

        Budget budget = new Budget();
        budget.setMonthlyBudget(10000.0);

        Expense expense1 = new Expense();
        expense1.setAmount(2000.0);

        Expense expense2 = new Expense();
        expense2.setAmount(1500.0);

        when(budgetRepository.findAll())
                .thenReturn(List.of(budget));

        when(expenseRepository.findAll())
                .thenReturn(List.of(expense1, expense2));

        BudgetResponseDTO response = budgetService.getBudgetSummary();

        assertEquals(10000.0, response.getMonthlyBudget());
        assertEquals(3500.0, response.getSpentAmount());
        assertEquals(6500.0, response.getRemainingAmount());

        verify(budgetRepository, times(1)).findAll();
        verify(expenseRepository, times(1)).findAll();
    }
}
