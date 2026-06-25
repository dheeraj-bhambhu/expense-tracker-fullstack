package com.dheeraj.expensetracker.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.dheeraj.expensetracker.dto.AnalyticsResponseDTO;
import com.dheeraj.expensetracker.dto.ExpenseRequestDTO;
import com.dheeraj.expensetracker.dto.ExpenseResponseDTO;
import com.dheeraj.expensetracker.entity.Expense;
import com.dheeraj.expensetracker.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestParam;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.List;
@Tag(name = "Expense API", description = "APIs for managing expenses")
@RestController
@RequestMapping("/expenses")
public class ExpenseController {
    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService){
        this.expenseService = expenseService;
    }
    @Operation(summary = "Create Expense", description = "Creates a new expense")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Expense created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid expense data"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    @PostMapping
    public ExpenseResponseDTO createExpense(@Valid @RequestBody ExpenseRequestDTO requestDTO){
        return expenseService.createExpense(requestDTO);
    }
    @Operation(summary = "Get All Expenses", description = "Returns all expenses")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Expenses retrieved successfully"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    @GetMapping("/get")
    public List<Expense> getExpense(){
        return expenseService.getAllexpenses();
    }
    @Operation(summary = "Get Expense By ID", description = "Returns an expense using its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Expenses retrieved successfully"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    @GetMapping("/{id}")
    public Expense getExpenseById(@PathVariable Long id){
        return expenseService.getExpenseById(id);
    }
    @Operation(summary = "Expense Analytics", description = "Returns total, highest, average expense and total transactions")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Analytics retrieved successfully"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    @GetMapping("/analytics")
    public AnalyticsResponseDTO getAnalytics() {

        return expenseService.getAnalytics();

    }
    @Operation(summary = "Pagination and Sorting", description = "Returns paginated and sorted expenses")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Expenses retrieved successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid pagination or sorting parameters")
    })
    @GetMapping("/page")
    public Page<ExpenseResponseDTO> getAllExpenses(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {

        return expenseService.getAllExpenses(page, size, sortBy,direction);
    }
    @Operation(summary = "Update Expense", description = "Updates an existing expense")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Expense updated successfully"),
            @ApiResponse(responseCode = "404", description = "Expense not found"),
            @ApiResponse(responseCode = "400", description = "Invalid expense data")
    })
    @PutMapping("/{id}")
    public Expense updateExpense(@PathVariable Long id,@RequestBody Expense expense){
        return expenseService.updateExpense(id,expense);
    }
    @Operation(summary = "Delete Expense", description = "Deletes an expense by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Expense deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Expense not found")
    })
    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable Long id){
        expenseService.deleteExpense(id);
    }


}
