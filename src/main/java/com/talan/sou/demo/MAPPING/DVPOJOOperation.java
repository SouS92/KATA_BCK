package com.talan.sou.demo.MAPPING;

import com.talan.sou.demo.DV.DvOperation;
import com.talan.sou.demo.POJO.Op;
import com.talan.sou.demo.POJO.Operation;

import java.time.LocalDate;

public class DVPOJOOperation {

    public static Operation DvtoPojoOperation(DvOperation dv){
        return new Operation(dv.getFrom(),dv.getTo(),dv.getAmount(),
                LocalDate.now(), Op.getEnum((int)dv.getOp()));
    }
}
