package com.talan.sou.demo.DV;

import com.talan.sou.demo.POJO.Op;

import java.time.LocalDate;

public class DvOperation {

    private long from;
    private long to;
    private long amount;
    private long op;
    private LocalDate dateOp;

    public DvOperation() {
    }

    public DvOperation(long from, long to, long amount, long op, LocalDate dateOp) {
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.op = op;
        this.dateOp = dateOp;
    }

    public long getFrom() {
        return from;
    }

    public void setFrom(long from) {
        this.from = from;
    }

    public long getTo() {
        return to;
    }

    public void setTo(long to) {
        this.to = to;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public long getOp() {
        return op;
    }

    public void setOp(long op) {
        this.op = op;
    }

    public LocalDate getDateOp() {
        return dateOp;
    }

    public void setDateOp(LocalDate dateOp) {
        this.dateOp = dateOp;
    }
}
