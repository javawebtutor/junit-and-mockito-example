package com.jwt.account.service;

import java.io.IOException;
import java.util.Date;

import com.jwt.account.enums.AccountOpeningStatus;
import com.jwt.account.manager.ReferenceIdsManager;
import com.jwt.account.model.BackgroundCheckResults;
import com.jwt.account.repo.AccountRepository;

public class AccountOpeningService {

	public static final String UNACCEPTABLE_RISK_PROFILE = "HIGH";

	private BackGroundCheckService backGroundCheckService;

	private ReferenceIdsManager referenceIdsManager;

	private AccountRepository accountRepository;

	public AccountOpeningService(BackGroundCheckService backGroundCheckService, ReferenceIdsManager referenceIdsManager,
			AccountRepository accountRepository) {
		this.backGroundCheckService = backGroundCheckService;
		this.referenceIdsManager = referenceIdsManager;
		this.accountRepository = accountRepository;
	}


	public AccountOpeningStatus openAccount(String firstName, String lastName, String taxId, Date dob)
			throws IOException {

		BackgroundCheckResults backgroundCheckResults = backGroundCheckService.confirm(firstName, lastName, taxId, dob);
		if (backgroundCheckResults == null
				|| backgroundCheckResults.getRiskProfile().equals(UNACCEPTABLE_RISK_PROFILE)) {
			return AccountOpeningStatus.DECLINED;
		} else {
			final String id = referenceIdsManager.obtainId(firstName, lastName, taxId, dob);
			if (id != null) {
				accountRepository.save(id, firstName, lastName, taxId, dob, backgroundCheckResults);
				return AccountOpeningStatus.OPENED;
			} else {
				return AccountOpeningStatus.DECLINED;
			}
		}

	}

}
