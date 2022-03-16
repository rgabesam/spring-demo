package com.gabesam.demo.database;

import com.gabesam.demo.model.Transaction;

import java.util.List;

public interface TransactionDatabase {

    int insertTransaction(Transaction transaction);

    Transaction getTransaction(int id);

    List<Transaction> getAllTransactions();

    int updateTransaction(int id, Transaction transaction);

    int deleteTransaction(int id);


}
