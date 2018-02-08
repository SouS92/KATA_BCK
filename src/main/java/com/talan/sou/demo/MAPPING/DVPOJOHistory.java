package com.talan.sou.demo.MAPPING;

import com.talan.sou.demo.DV.DvHistory;
import com.talan.sou.demo.POJO.Operation;

import java.time.LocalDate;

public class DVPOJOHistory {

    public static DvHistory POJOTODv(String from, String to, String typeOp, long amount, LocalDate dateOp) {
        return new DvHistory(from, to, amount, typeOp, dateOp);
    }
}
