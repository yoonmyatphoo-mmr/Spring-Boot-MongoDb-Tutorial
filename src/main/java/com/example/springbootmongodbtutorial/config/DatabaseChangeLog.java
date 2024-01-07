package com.example.springbootmongodbtutorial.config;

import com.example.springbootmongodbtutorial.model.Expense;
import com.example.springbootmongodbtutorial.model.ExpenseCategory;
import com.example.springbootmongodbtutorial.repository.ExpenseRepository;
import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.example.springbootmongodbtutorial.model.ExpenseCategory.*;

/**
 * Author Yoon Myat Phoo
 * created 1/7/2024
 * project spring-boot-mongodb-tutorial
 * package com.example.springbootmongodbtutorial.config
 */

@ChangeLog //Annotate your changeLog classes by @ChangeLog
public class DatabaseChangeLog {

    //Annotate your changeSet methods by @ChangeSet
    @ChangeSet(order = "001", id = "seedDatabase", author = "Yoon")
    public void seedDatabase(ExpenseRepository expenseRepository) {
        List<Expense> expenseList = new ArrayList<>();
        expenseList.add(createNewExpense("Movie Tickets", ENTERTAINMENT, BigDecimal.valueOf(40)));
        expenseList.add(createNewExpense("Dinner", RESTAURANT, BigDecimal.valueOf(60)));
        expenseList.add(createNewExpense("Netflix", ENTERTAINMENT, BigDecimal.valueOf(10)));
        expenseList.add(createNewExpense("Gym", MISC, BigDecimal.valueOf(20)));
        expenseList.add(createNewExpense("Internet", UTILITIES, BigDecimal.valueOf(30)));

        expenseRepository.insert(expenseList);
    }

    private Expense createNewExpense(String expenseName, ExpenseCategory expenseCategory, BigDecimal amount) {
        Expense expense = new Expense();
        expense.setExpenseName(expenseName);
        expense.setExpenseAmount(amount);
        expense.setExpenseCategory(expenseCategory);
        return expense;
    }
}
