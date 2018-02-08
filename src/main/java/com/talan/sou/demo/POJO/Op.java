package com.talan.sou.demo.POJO;

public enum Op {
    WITHDRAW,
    DEPOSIT,
    TRANSFER;

    public static Op getEnum(int val){
        switch (val){
            case 0 : return WITHDRAW;
            case 1 : return DEPOSIT;
            case 2 : return TRANSFER;
            default: return null;
        }
    }

    public static String getValEnum(Op op){
        switch (op){
            case WITHDRAW:  return "WITHDRAW";
            case DEPOSIT:  return "DEPOSIT";
            case TRANSFER:  return "TRANSFER";
            default: return "";
        }
    }

}
