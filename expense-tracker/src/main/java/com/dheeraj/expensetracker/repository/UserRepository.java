package com.dheeraj.expensetracker.repository;
import com.dheeraj.expensetracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
