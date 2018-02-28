package com.talan.sou.demo.repository;

import com.talan.sou.demo.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {

     /** Récupérer un compte par le nom du compte
      * @param name type string
      * @Return Un compte
      *
      */
     Account findByAccountName(String name);
    /** Récupérer un compte par son uid
     * @param uid type long
     * @return Un compte
     */
     Account findByAccountUID(long uid);
}
