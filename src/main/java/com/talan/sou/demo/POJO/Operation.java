package com.talan.sou.demo.POJO;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Operations")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idOperation;


    private long fromAccount;


    private long toAccount;


    private long amount;
    private LocalDate dateOp;
    private Op op;

    public Operation() {
    }

    public Operation(long fromAccount, long toAccount, long amount, LocalDate dateOp,Op op) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.dateOp = dateOp;
        this.op = op;
    }

    public long getIdOperation() {
        return idOperation;
    }

    public void setIdOperation(long idOperation) {
        this.idOperation = idOperation;
    }

    public long getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(long fromAccount) {
        this.fromAccount = fromAccount;
    }


    public LocalDate getDateOp() {
        return dateOp;
    }

    public void setDateOp(LocalDate dateOp) {
        this.dateOp = dateOp;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public Op getOp() {
        return op;
    }

    public void setOp(Op op) {
        this.op = op;
    }

    public long getToAccount() {
        return toAccount;
    }

    public void setToAccount(long toAccount) {
        this.toAccount = toAccount;
    }
}
