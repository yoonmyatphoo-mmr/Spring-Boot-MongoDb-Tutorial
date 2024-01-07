package com.example.springbootmongodbtutorial.repository;

import com.example.springbootmongodbtutorial.model.Expense;
import com.mongodb.client.MongoDatabase;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @Author Yoon Myat Phoo
 * @created 1/7/2024
 * @project spring-boot-mongodb-tutorial
 * @package com.example.springbootmongodbtutorial.repository
 */

@Repository
public interface ExpenseRepository extends MongoRepository<Expense, String> {

    @Query("{'name': ?0}")
   Optional<Expense> findByName(String name);
}
