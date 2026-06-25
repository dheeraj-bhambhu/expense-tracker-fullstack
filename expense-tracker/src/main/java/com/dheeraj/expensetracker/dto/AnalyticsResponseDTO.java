package com.dheeraj.expensetracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnalyticsResponseDTO {
    private Double totalExpense;

    private Double highestExpense;

    private Double averageExpense;

    private Long totalTransactions;
}
