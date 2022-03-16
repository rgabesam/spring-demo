package com.gabesam.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.Hashtable;

public class Transaction {
    private int id;
    private String type;
    private String actor;
    private Date timestamp;
    private Hashtable<String, String> transactionData;

    public Transaction(@JsonProperty("id") int id,
                       @JsonProperty("type") String type,
                       @JsonProperty("actor") String actor,
                       @JsonProperty("timestamp") Date timestamp,
                       @JsonProperty("data") Hashtable<String, String> transactionData) {
        this.id = id;
        this.type = type;
        this.actor = actor;
        this.timestamp = timestamp;
        this.transactionData = transactionData;
    }

    public int getId() {
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

    public Hashtable<String, String> getTransactionData() {
        return transactionData;
    }


    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", actor='" + actor + '\'' +
                ", timestamp=" + timestamp +
                ", transactionData=" + transactionData +
                '}';
    }
}
