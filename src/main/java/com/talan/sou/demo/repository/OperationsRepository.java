package com.talan.sou.demo.repository;

import com.talan.sou.demo.domain.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationsRepository extends JpaRepository<Operation,Long> {
    @Query("select o from Operation o where o.fromAccount = ?1 OR o.toAccount = ?1")
     List<Operation> findByAccounts(long accountId);
}