package com.jwt.account.manager;

import java.util.Date;

public interface ReferenceIdsManager {

	String obtainId(String firstName, String lastName, String taxId, Date dob);

}
