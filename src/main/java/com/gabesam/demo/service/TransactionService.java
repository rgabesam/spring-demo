package com.gabesam.demo.service;

import com.gabesam.demo.database.TransactionDataRepository;
import com.gabesam.demo.database.TransactionRepository;
import com.gabesam.demo.model.Transaction;
import com.gabesam.demo.model.TransactionDataMySql;
import com.gabesam.demo.model.TransactionMySql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionDataRepository transactionDataRepository;


    public int insertTransaction(Transaction transaction){
        TransactionMySql transactionMySql = new TransactionMySql();
        transactionMySql.setActor(transaction.getActor());
        transactionMySql.setTimestamp(transaction.getTimestamp());
        transactionMySql.setType(transaction.getType());

        var saved = transactionRepository.save(transactionMySql);
        System.out.println("S A V E D    id = " + saved.getId());

        transaction.getTransactionData().forEach((key, value) -> {
            TransactionDataMySql data = new TransactionDataMySql();
            data.setTransactionMySql(saved);
            data.setKey(key);
            data.setValue(value);
            System.out.println(data);
            transactionDataRepository.save(data);
        });


        return 0;
    }

    public Transaction getTransaction(int id) {
        var transaction = transactionRepository.findById(id);

        if(transaction.isEmpty())
            return null;


        var result = convertTransactionMySql(transaction.get());


        return result;
    }

    public List<Transaction> getAllTransactions() {
        var transactions = transactionRepository.findAll();
        List<Transaction> result = new ArrayList<>();

        transactions.forEach(item -> result.add(convertTransactionMySql(item)));

        return result;

    }

    //updates only record in transactions table
    public int updateTransaction(int id, Transaction transaction) {
        var transactionMySql = transactionRepository.findById(id);
        if(transactionMySql.isEmpty())
            return -1;


        transactionMySql.get().setActor(transaction.getActor());
        transactionMySql.get().setTimestamp(transaction.getTimestamp());
        transactionMySql.get().setType(transaction.getType());

        var updated = transactionRepository.save(transactionMySql.get());


        return 1;
    }



    public int deleteTransaction(int id) {
        var transaction = transactionRepository.findById(id);
        if(transaction.isEmpty())
            return -1;

        transactionDataRepository.deleteDataOfTransaction(id);
        transactionRepository.deleteById(id);

        return 1;
    }

    private Transaction convertTransactionMySql(TransactionMySql transactionMySql){
        Hashtable<String, String> transactionData = new Hashtable<>();
        transactionMySql.getTransactionData().forEach(singleData -> transactionData.put(singleData.getKey(), singleData.getValue()));

        Transaction result = new Transaction(
                transactionMySql.getId(),
                transactionMySql.getType(),
                transactionMySql.getActor(),
                transactionMySql.getTimestamp(),
                transactionData);
        return result;
    }
}
