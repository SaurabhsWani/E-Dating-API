package com.saurbah.dating.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saurbah.dating.entities.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, Integer> {

}
