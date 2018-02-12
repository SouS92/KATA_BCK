package com.talan.sou.demo.service.impl;

import com.talan.sou.demo.domain.Account;
import com.talan.sou.demo.domain.Op;
import com.talan.sou.demo.domain.Operation;
import com.talan.sou.demo.repository.AccountRepository;
import com.talan.sou.demo.repository.OperationsRepository;
import com.talan.sou.demo.service.AccountService;
import com.talan.sou.demo.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class OperationServiceImp implements OperationService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private OperationsRepository operationsRepository;

    @Autowired
    private AccountService accountService;

    @Override
    public List<Operation> getListOpsPerAccount(long uid) {
        List<Operation> listOp = operationsRepository.findByAccounts(uid);

        for(Operation op : listOp)
        {
            StringBuilder fromName = new StringBuilder("--");
            if(op.getFromAccount() != 0)
                op.setFromAccountName(accountService.getAccountByUID(op.getFromAccount()).getAccountName());
                op.setToAccountName(accountService.getAccountByUID(op.getToAccount()).getAccountName());
                op.setTypeOp(Op.getValEnum(op.getOp()));
                op.setOpDate(op.getDateOp().format(DateTimeFormatter.ISO_LOCAL_DATE));
        }
        return listOp;
    }

    @Override
    public void accountOp(long uid, Op o, long amount) {
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
}
