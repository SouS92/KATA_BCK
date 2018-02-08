package com.talan.sou.demo.REPO;

import com.talan.sou.demo.POJO.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OperationsRepository extends JpaRepository<Operation,Long> {

    @Query("select o from Operation o where o.fromAccount = ?1 OR o.toAccount = ?1")
     List<Operation> findByAccounts(long accountId);
}