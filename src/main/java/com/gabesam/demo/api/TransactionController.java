package com.gabesam.demo.api;

import com.gabesam.demo.model.Transaction;
import com.gabesam.demo.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/transaction")
@RestController
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public void insertTransaction(@RequestBody Transaction transaction){
        transactionService.insertTransaction(transaction);
    }

    @GetMapping(path = "{id}")
    public Transaction getTransaction(@PathVariable("id") int id) {
        return transactionService.getTransaction(id);
    }

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @PutMapping(path = "{id}")
    public void updateTransaction(@PathVariable("id") int id, @RequestBody Transaction transaction) {
        transactionService.updateTransaction(id, transaction);
    }

    @DeleteMapping(path = "{id}")
    public void deleteTransaction(@PathVariable("id") int id) {
        transactionService.deleteTransaction(id);
    }
}
