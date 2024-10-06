package com.saurbah.dating.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.saurbah.dating.entities.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, Integer> {

	@Query("SELECT u FROM UserAccount u WHERE (u.age=:age OR u.city=:city OR u.country=:country) AND u.id!=:id")
	List<UserAccount> findMatches(@Param("age") int age, @Param("city") String city, @Param("country") String country,
			@Param("id") int id);
}
