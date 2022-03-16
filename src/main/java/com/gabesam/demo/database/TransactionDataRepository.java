package com.gabesam.demo.database;

import com.gabesam.demo.model.TransactionDataMySql;
import com.gabesam.demo.model.TransactionMySql;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.Collection;


public interface TransactionDataRepository extends CrudRepository<TransactionDataMySql, Integer>{

    @Modifying
    @Transactional
    @Query(
            value = "delete from transaction_data_my_sql d where d.transaction_id = ?1",
            nativeQuery = true)
    void deleteDataOfTransaction(Integer transactionId);


}
