package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Expense;
import ru.hogwarts.school.service.ExpenseService;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {
    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpenses (@RequestParam("page")Integer pageNumber, @RequestParam("size")Integer pageSize){
        return ResponseEntity.ok(expenseService.getAllExpenses(pageNumber,pageSize));
    }
    @PostMapping
    public ResponseEntity<Expense> createExpense(@RequestBody Expense expense){
        expenseService.createExpense(expense);
        return ResponseEntity.ok(expense);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Expense> deleteExpense(@PathVariable Integer id){
        expenseService.deleteExpense(id);
        return ResponseEntity.ok(null);
    }

}
