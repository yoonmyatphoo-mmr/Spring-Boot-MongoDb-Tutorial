package com.example.springbootmongodbtutorial.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;

/**
 * @Author Yoon Myat Phoo
 * @created 1/7/2024
 * @project spring-boot-mongodb-tutorial
 * @package model
 */

@Data
@Document("expense")
public class Expense {

    @Id
    private String id;

    @Field(name = "name")
    @Indexed(unique = true)
    private String expenseName;

    @Field(name = "category")
    private ExpenseCategory expenseCategory;

    @Field(name = "amount")
    private BigDecimal expenseAmount;

}
