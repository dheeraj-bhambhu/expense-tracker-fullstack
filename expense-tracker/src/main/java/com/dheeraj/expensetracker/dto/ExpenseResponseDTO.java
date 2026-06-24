package com.dheeraj.expensetracker.dto;

import lombok.Data;

@Data
public class ExpenseResponseDTO {

    private Long id;
    private String title;
    private double amount;
    private String description;

}
