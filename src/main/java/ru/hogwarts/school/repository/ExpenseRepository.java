package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.hogwarts.school.model.Expense;
import ru.hogwarts.school.model.ExpensesByCategory;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
    @Query(value = "SELECT category, sum(amount) as amount FROM expenses GROUP BY category", nativeQuery = true)
    List<ExpensesByCategory> getExpensesByCategory();
}
