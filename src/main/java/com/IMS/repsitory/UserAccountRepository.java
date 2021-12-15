package com.IMS.repsitory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.IMS.model.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, Integer>{

	@Query("SELECT ua FROM UserAccount ua WHERE ua.userName LIKE %:userName%")
	UserAccount findByUsername(@Param("userName") String userName);
}
