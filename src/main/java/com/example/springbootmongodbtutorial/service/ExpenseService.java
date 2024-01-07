package com.example.springbootmongodbtutorial.service;

import com.example.springbootmongodbtutorial.model.Expense;
import com.example.springbootmongodbtutorial.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Yoon Myat Phoo
 * @created 1/7/2024
 * @project spring-boot-mongodb-tutorial
 * @package com.example.springbootmongodbtutorial.service
 */

@Service
public class ExpenseService {

    @Autowired
    ExpenseRepository expenseRepository;

    public void addExpense(Expense expense) {
        expenseRepository.insert(expense);
    }

    public void updateExpense(Expense expense) {

        Expense savedExpense = expenseRepository.findById(expense.getId())
                .orElseThrow(() -> new RuntimeException(
                        String.format("Cannot find Expense by Id %s", expense.getId())));

        savedExpense.setExpenseName(expense.getExpenseName());
        savedExpense.setExpenseAmount(expense.getExpenseAmount());
        savedExpense.setExpenseCategory(expense.getExpenseCategory());

        expenseRepository.save(savedExpense);
    }

    public List<Expense> getAllExpense() {
        return expenseRepository.findAll();
    }

    public Expense getExpenseByName(String name) {
       return expenseRepository.findByName(name).orElseThrow(() -> new RuntimeException(
               String.format("Cannot find expense by name %s,name")
       ));
    }

    public void deleteExpense(String id) {
        expenseRepository.deleteById(id);
    }
}
