package com.talan.sou.demo.MAPPING;

import com.talan.sou.demo.DV.DvAccount;
import com.talan.sou.demo.POJO.Account;

public class DVPOJOAccount {

    public static Account MVtoPOJOAccount(DvAccount ac){
        return new Account(ac.getNameAccount(),ac.getBalance());
    }

    public static DvAccount POJOtoMVAccount(Account ac){
        return new DvAccount(ac.getAccountUID(),ac.getAccountName(),ac.getBalance());
    }
}
