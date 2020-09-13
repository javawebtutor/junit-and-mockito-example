package com.jwt.account.service;

import java.io.IOException;
import java.util.Date;

import com.jwt.account.model.BackgroundCheckResults;

public interface BackGroundCheckService {

	BackgroundCheckResults confirm(String firstName, String lastName, String taxId, Date dob) throws IOException;

}
