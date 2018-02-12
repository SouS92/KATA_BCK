package com.talan.sou.demo.controller;

import com.talan.sou.demo.domain.Op;
import com.talan.sou.demo.domain.Operation;
import com.talan.sou.demo.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class OperationController {

    @Autowired
    private OperationService operationService;

    @RequestMapping(value = "/operations",method = RequestMethod.POST)
    public void opAccount(@RequestBody Operation op){
        operationService.accountOp(Integer.parseInt(op.getToAccountName()), Op.getEnum(op.getTypeOp()),op.getAmount());
    }


        @RequestMapping(value = "/operations/{uid}",method = RequestMethod.GET)
    public List<Operation> getListOps(@PathVariable("uid") long uid){
        return operationService.getListOpsPerAccount(uid);
    }

    @RequestMapping(value = "/operations/transfer",method = RequestMethod.POST)
    public void transferOpAccount(@RequestBody Operation op){
        operationService.transferOp(Integer.parseInt(op.getFromAccountName()),Integer.parseInt(op.getToAccountName()),op.getAmount());
    }


}
