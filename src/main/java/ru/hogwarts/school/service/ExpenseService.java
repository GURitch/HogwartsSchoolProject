package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Expense;
import ru.hogwarts.school.model.ExpensesByCategory;

import java.util.List;

public interface ExpenseService {
    List<Expense> getAllExpenses(Integer pageNumber, Integer pageSize);
    void createExpense(Expense expense);
    void deleteExpense(Integer id);
    List<ExpensesByCategory> getExpensesByCategory();
}
