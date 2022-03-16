package com.gabesam.demo.model;

import javax.persistence.*;

@Entity
public class TransactionDataMySql {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String dataKey;
    private String value;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="transaction_id")
    private TransactionMySql transactionMySql;

    public Integer getId() {
        return id;
    }


    public String getKey() {
        return dataKey;
    }

    public String getValue() {
        return value;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setKey(String key) {
        this.dataKey = key;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public TransactionMySql getTransactionMySql() {
        return transactionMySql;
    }

    public void setTransactionMySql(TransactionMySql transactionMySql) {
        this.transactionMySql = transactionMySql;
    }
}
