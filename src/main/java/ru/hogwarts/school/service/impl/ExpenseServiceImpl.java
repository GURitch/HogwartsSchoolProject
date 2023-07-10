package ru.hogwarts.school.service.impl;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Expense;
import ru.hogwarts.school.model.ExpensesByCategory;
import ru.hogwarts.school.repository.ExpenseRepository;
import ru.hogwarts.school.service.ExpenseService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public List<Expense> getAllExpenses(Integer pageNumber, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber-1, pageSize);
        return expenseRepository.findAll(pageRequest).getContent();
    }

    @Override
    public void createExpense(Expense expense){
        expenseRepository.save(expense);
    }

    @Override
    public void deleteExpense(Integer id) {
        expenseRepository.deleteById(id);
    }

    @Override
    public List<ExpensesByCategory> getExpensesByCategory() {
            return expenseRepository.getExpensesByCategory();
    }
}
