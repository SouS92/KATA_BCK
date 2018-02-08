package com.talan.sou.demo.SERVICE.INTERFACE;

import com.talan.sou.demo.DV.DvAccount;
import com.talan.sou.demo.DV.DvHistory;
import com.talan.sou.demo.POJO.Account;
import com.talan.sou.demo.POJO.Op;

import java.util.List;


public interface AccountService {

    List<DvAccount> getAccounts();
    DvAccount getAccountByName(String name);
    DvAccount getAccountByUID(long uid);
    void insertNewAccount(DvAccount account);
    void accountOp(long uid,Op o,long amount);
    void transferOp(long uid, long secondUid, long amount);
    List<DvHistory>getListOpsPerAccount(long uid);

}
