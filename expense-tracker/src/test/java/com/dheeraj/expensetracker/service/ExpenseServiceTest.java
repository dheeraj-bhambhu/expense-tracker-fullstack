package com.dheeraj.expensetracker.service;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.dheeraj.expensetracker.dto.ExpenseRequestDTO;
import com.dheeraj.expensetracker.dto.ExpenseResponseDTO;
import com.dheeraj.expensetracker.entity.Category;
import com.dheeraj.expensetracker.entity.Expense;
import com.dheeraj.expensetracker.exception.ResourceNotFoundException;
import com.dheeraj.expensetracker.repository.ExpenseRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExpenseServiceTest {

    @Mock
    private ExpenseRepository expenseRepository;

    @InjectMocks
    private ExpenseService expenseService;


    @Test
    void testCreateExpense() {
        ExpenseRequestDTO request = new ExpenseRequestDTO();
        request.setTitle("Food");
        request.setDescription("Pizza");
        request.setAmount(500.0);
        Expense expense = new Expense();
        expense.setId(1L);
        expense.setTitle("Food");
        expense.setDescription("Pizza");
        expense.setAmount(500.0);

        when(expenseRepository.save(org.mockito.ArgumentMatchers.any(Expense.class)))
                .thenReturn(expense);
        ExpenseResponseDTO response = expenseService.createExpense(request);

        assertEquals(1L, response.getId());
        assertEquals("Food", response.getTitle());
        assertEquals("Pizza", response.getDescription());
        assertEquals(500.0, response.getAmount());

        verify(expenseRepository, times(1)).save(any(Expense.class));
    }
    @Test
    void testGetExpenseById() {
        Expense expense = new Expense();

        expense.setId(1L);
        expense.setTitle("Food");
        expense.setDescription("Pizza");
        expense.setAmount(500.0);
        when(expenseRepository.findById(1L))
                .thenReturn(Optional.of(expense));
        Expense response = expenseService.getExpenseById(1L);

        // Assert
        assertEquals(1L, response.getId());
        assertEquals("Food", response.getTitle());
        assertEquals("Pizza", response.getDescription());
        assertEquals(500.0, response.getAmount());

        verify(expenseRepository, times(1)).findById(1L);

    }
    @Test
    void testGetAllExpenses() {
        Expense expense1 = new Expense();
        expense1.setId(1L);
        expense1.setTitle("Food");

        Expense expense2 = new Expense();
        expense2.setId(2L);
        expense2.setTitle("Travel");

        List<Expense> expenses = Arrays.asList(expense1, expense2);

        when(expenseRepository.findAll()).thenReturn(expenses);
        List<Expense> response = expenseService.getAllexpenses();
        assertEquals(2, response.size());
        assertEquals("Food", response.get(0).getTitle());
        assertEquals("Travel", response.get(1).getTitle());
        verify(expenseRepository, times(1)).findAll();
    }
    @Test
    void testUpdateExpense() {
        Expense existingExpense = new Expense();
        existingExpense.setId(1L);
        existingExpense.setTitle("Food");
        existingExpense.setDescription("Pizza");
        existingExpense.setAmount(500.0);

        Expense updatedExpense = new Expense();
        updatedExpense.setTitle("Shopping");
        updatedExpense.setDescription("Clothes");
        updatedExpense.setAmount(2000.0);

        
        when(expenseRepository.findById(1L))
                .thenReturn(Optional.of(existingExpense));
        when(expenseRepository.save(any(Expense.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        Expense response = expenseService.updateExpense(1L, updatedExpense);

        assertEquals("Shopping", response.getTitle());
        assertEquals("Clothes", response.getDescription());
        assertEquals(2000.0, response.getAmount());

        verify(expenseRepository, times(1)).findById(1L);
        verify(expenseRepository, times(1)).save(any(Expense.class));
    }
    @Test
    void testDeleteExpense() {
        Expense expense = new Expense();
        expense.setId(1L);
        expense.setTitle("Food");
        expense.setDescription("Pizza");
        expense.setAmount(500.0);

        when(expenseRepository.findById(1L))
                .thenReturn(Optional.of(expense));
        expenseService.deleteExpense(1L);

        verify(expenseRepository, times(1)).findById(1L);
        verify(expenseRepository, times(1)).delete(expense);
    }
    @Test
    void testGetExpenseByIdNotFound() {
        when(expenseRepository.findById(1L))
                .thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> {
            expenseService.getExpenseById(1L);
            verify(expenseRepository, times(1)).findById(1L);
        });

    }
    @Test
    void testUpdateExpenseNotFound() {
        Expense updatedExpense = new Expense();
        updatedExpense.setTitle("Shopping");
        updatedExpense.setDescription("Clothes");
        updatedExpense.setAmount(2000.0);

        when(expenseRepository.findById(1L))
                .thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> {
            expenseService.updateExpense(1L, updatedExpense);
        });
        verify(expenseRepository, times(1)).findById(1L);
        verify(expenseRepository, never()).save(any(Expense.class));
    }
    @Test
    void testDeleteExpenseNotFound() {
        when(expenseRepository.findById(1L))
                .thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            expenseService.deleteExpense(1L);
        });

        verify(expenseRepository, times(1)).findById(1L);
        verify(expenseRepository, never()).delete(any(Expense.class));
    }

}