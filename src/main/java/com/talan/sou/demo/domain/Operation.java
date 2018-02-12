package com.talan.sou.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "Operations")
@Getter @Setter @NoArgsConstructor
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idOperation;

    @JsonIgnore
    private long fromAccount;

    @JsonIgnore
    private long toAccount;


    private long amount;
    @JsonIgnore
    private LocalDate dateOp;
    @JsonIgnore
    private Op op;

    @Transient
    private String fromAccountName;
    @Transient
    private String toAccountName;
    @Transient
    private String typeOp;
    @Transient
    private String opDate;

    public Operation(long fromAccount, long toAccount, long amount, LocalDate dateOp,Op op) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.dateOp = dateOp;
        this.op = op;
        this.typeOp = Op.getValEnum(op);
        this.opDate = dateOp.format( DateTimeFormatter.ISO_LOCAL_DATE);
    }

}
