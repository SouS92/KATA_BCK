package com.talan.sou.demo.POJO;




import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="ACCOUNT")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long accountUID;

    @NotNull
    private String accountName;

    @NotNull
    private long balance;

    public Account(){
    }

    public Account(String name,long balance){
        this.accountName = name;
        this.balance = balance;
    }
    public long getAccountUID() {
        return accountUID;
    }

    public void setAccountUID(long accountUID) {
        this.accountUID = accountUID;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

//    public Set<Operation> getHistoricalList() {
//        return listOps;
//    }
//
//    public void setHistoricalList(Set<Operation> listOps) {
//        this.listOps = listOps;
//    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

}
