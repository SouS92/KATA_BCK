package com.talan.sou.demo.REPO;

import com.talan.sou.demo.POJO.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
     Account findByAccountName(String name);
     Account findByAccountUID(long uid);
}
