package com.jwt.account.repo;


import java.util.Date;

import com.jwt.account.model.Account;
import com.jwt.account.model.BackgroundCheckResults;

public interface AccountRepository {

	boolean isExpired(Account account);
	
	boolean save(String id, String firstName, String lastName, String taxId, Date dob, BackgroundCheckResults backgroundCheckResults);

}
