package com.talan.sou.demo.CONTROLLER;

import com.talan.sou.demo.DV.DvAccount;
import com.talan.sou.demo.DV.DvHistory;
import com.talan.sou.demo.DV.DvOperation;
import com.talan.sou.demo.MAPPING.DVPOJOOperation;
import com.talan.sou.demo.POJO.Account;
import com.talan.sou.demo.POJO.Op;
import com.talan.sou.demo.POJO.Operation;
import com.talan.sou.demo.SERVICE.INTERFACE.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/")
    public List<DvAccount> getAccounts(){
    return accountService.getAccounts();
    }


    @RequestMapping(value = "/opAccount",method = RequestMethod.POST)
    public Account opAccount(@RequestBody DvOperation operation){

         Operation op = DVPOJOOperation.DvtoPojoOperation(operation);
         accountService.accountOp(op.getFromAccount(),op.getOp(),op.getAmount());

            return new Account();
    }


    @RequestMapping(value = "/listops/{uid}",method = RequestMethod.GET)
    public List<DvHistory> getListOps(@PathVariable("uid") long uid){

        return accountService.getListOpsPerAccount(uid);
    }

    @RequestMapping(value = "/transferOpAccount",method = RequestMethod.POST)
    public Account transferOpAccount(@RequestBody DvOperation operation){


        Operation op = DVPOJOOperation.DvtoPojoOperation(operation);
        accountService.transferOp(op.getFromAccount(),op.getToAccount(),op.getAmount());


        return new Account();
    }


    @RequestMapping(value = "/createAccount",method = RequestMethod.POST)
    public Account saveAccount(@RequestBody Account account){
        accountService.insertNewAccount(new DvAccount(account.getAccountUID(),account.getAccountName(),account.getBalance()));
        return account;
    }

}
