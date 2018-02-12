package com.talan.sou.demo.domain;




import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="ACCOUNT")
@Getter @Setter @NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long accountUID;

    @NotNull
    private String accountName;

    @NotNull
    private long balance;

    public Account(String name,long balance){
        this.accountName = name;
        this.balance = balance;
    }

}

