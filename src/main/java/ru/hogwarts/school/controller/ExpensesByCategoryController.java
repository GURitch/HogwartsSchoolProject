package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.hogwarts.school.model.ExpensesByCategory;
import ru.hogwarts.school.service.ExpenseService;

import java.util.List;

@RestController
public class ExpensesByCategoryController {
    private final ExpenseService expenseService;

    public ExpensesByCategoryController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }


    @GetMapping("/expenses-by-category")
    public ResponseEntity<List<ExpensesByCategory>> getExpensesByCategory(){
        return ResponseEntity.ok(expenseService.getExpensesByCategory());
    }
}
