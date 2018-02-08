package com.talan.sou.demo.DV;

import java.util.List;

public class DvAccount {

    private long id;
    private String nameAccount;
    private long balance;


    public DvAccount() {
    }

    public DvAccount(long id, String name, long balance){
        this.id = id;
        this.nameAccount = name;
        this.balance = balance;
    }
    public String getNameAccount() {
        return nameAccount;
    }

    public void setNameAccount(String nameAccount) {
        this.nameAccount = nameAccount;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
