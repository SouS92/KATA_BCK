package com.talan.sou.demo.DV;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DvHistory {

    private String from;
    private String to;
    private long amount;
    private String op;
    private String dateOperation;

    public DvHistory(){

    }

    public DvHistory(String from, String to, long amount, String op, LocalDate d){
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.op = op;
        this.dateOperation= d.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public String getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(String dateOperation) {
        this.dateOperation = dateOperation;
    }
}
