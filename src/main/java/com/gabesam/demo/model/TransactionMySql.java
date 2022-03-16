package com.gabesam.demo.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class TransactionMySql {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String type;
    private String actor;
    private Date timestamp;
    @OneToMany(mappedBy="transactionMySql")
    private List<TransactionDataMySql> transactionData ;

    public Integer getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getActor() {
        return actor;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public List<TransactionDataMySql> getTransactionData() {
        return transactionData;
    }

    public void setTransactionData(List<TransactionDataMySql> transactionData) {
        this.transactionData = transactionData;
    }


}
