package com.dheeraj.expensetracker.dto;

import lombok.Data;

@Data
public class ExpenseRequestDTO {

         private String title;
         private double amount;
         private String description;
         
}
