package com.gabesam.demo.database;

import com.gabesam.demo.model.TransactionMySql;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;


public interface TransactionRepository extends CrudRepository<TransactionMySql, Integer> {

}
