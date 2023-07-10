package ru.hogwarts.school.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "expenses")
public class Expense {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private LocalDate date;
    private String category;
    private Integer amount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expense expense = (Expense) o;
        return Objects.equals(id, expense.id) && Objects.equals(name, expense.name) && Objects.equals(date, expense.date) && Objects.equals(category, expense.category) && Objects.equals(amount, expense.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, date, category, amount);
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", category='" + category + '\'' +
                ", amount=" + amount +
                '}';
    }
}