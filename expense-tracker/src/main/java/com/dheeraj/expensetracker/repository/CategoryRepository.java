package com.dheeraj.expensetracker.repository;

import com.dheeraj.expensetracker.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
