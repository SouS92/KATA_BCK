package com.talan.sou.demo.service;

import com.talan.sou.demo.domain.Op;
import com.talan.sou.demo.domain.Operation;

import java.util.List;

public interface OperationService {
    void accountOp(long uid, Op o, long amount);
    void transferOp(long uid, long secondUid, long amount);
    List<Operation> getListOpsPerAccount(long uid);
}
