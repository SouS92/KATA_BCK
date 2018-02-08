package com.talan.sou.demo.SERVICE.IMP;

import com.talan.sou.demo.DV.DvAccount;
import com.talan.sou.demo.DV.DvHistory;
import com.talan.sou.demo.MAPPING.DVPOJOAccount;
import com.talan.sou.demo.MAPPING.DVPOJOHistory;
import com.talan.sou.demo.POJO.Account;
import com.talan.sou.demo.POJO.Op;
import com.talan.sou.demo.POJO.Operation;
import com.talan.sou.demo.REPO.AccountRepository;
import com.talan.sou.demo.REPO.OperationsRepository;
import com.talan.sou.demo.SERVICE.INTERFACE.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImp implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private  OperationsRepository operationsRepository;
   @Override
    public List<DvAccount> getAccounts() {
        List<Account> acts = accountRepository.findAll();
        List<DvAccount> listDvs = new ArrayList<>();
        for(Account ac : acts){
            listDvs.add(DVPOJOAccount.POJOtoMVAccount(ac));
        }
        return listDvs;
    }

    @Override
    public DvAccount getAccountByName(String name) {
        return DVPOJOAccount.POJOtoMVAccount(accountRepository.findByAccountName(name));
    }

    @Override
    public DvAccount getAccountByUID(long uid) {
        return DVPOJOAccount.POJOtoMVAccount(accountRepository.findByAccountUID(uid));

    }

    @Override
    public void insertNewAccount(DvAccount account) {
        accountRepository.save(DVPOJOAccount.MVtoPOJOAccount(account));
    }

    @Override
    public void accountOp(long uid, Op o,long amount) {
        Account ac = accountRepository.findByAccountUID(uid);
        switch (o){
            case WITHDRAW: ac.setBalance(ac.getBalance() - amount); break;
            case DEPOSIT: ac.setBalance(ac.getBalance() + amount); break;
        }
        Operation op = new Operation(0,ac.getAccountUID(),amount, LocalDate.now(),o);

        operationsRepository.save(op);
        accountRepository.save(ac);
    }

    @Override
    public void transferOp(long uid, long secondUid, long amount) {
        Account fromAccount = accountRepository.findByAccountUID(uid);
        Account toAccount = accountRepository.findByAccountUID(secondUid);

        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);

        Operation op = new Operation(fromAccount.getAccountUID(),toAccount.getAccountUID(),
                amount, LocalDate.now(),Op.TRANSFER);

        operationsRepository.save(op);

        accountRepository.save(toAccount);
        accountRepository.save(fromAccount);


    }

    @Override
    public List<DvHistory> getListOpsPerAccount(long uid) {
        Account ac = accountRepository.findByAccountUID(uid);
        List<Operation> listOp = operationsRepository.findByAccounts(ac.getAccountUID());
        List<DvHistory> listOps = new ArrayList<>();
        for(Operation op : listOp)
        {
            StringBuilder fromName = new StringBuilder("--");
            if(op.getFromAccount() != 0)
                fromName.replace(0,2,getAccountByUID(op.getFromAccount()).getNameAccount());

                listOps.add(DVPOJOHistory.POJOTODv(fromName.toString(),
                        getAccountByUID(op.getToAccount()).getNameAccount(),Op.getValEnum(op.getOp()),
                        op.getAmount(),op.getDateOp()));
        }



        return listOps;
    }
}
