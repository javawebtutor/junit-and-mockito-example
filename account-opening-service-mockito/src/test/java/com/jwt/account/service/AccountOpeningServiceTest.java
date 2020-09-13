package com.jwt.account.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.jwt.account.enums.AccountOpeningStatus;
import com.jwt.account.manager.ReferenceIdsManager;
import com.jwt.account.model.BackgroundCheckResults;
import com.jwt.account.repo.AccountRepository;
import static com.jwt.account.service.AccountOpeningService.UNACCEPTABLE_RISK_PROFILE;

public class AccountOpeningServiceTest {

	private AccountOpeningService accountOpeningService;
	private BackGroundCheckService backGroundCheckService = mock(BackGroundCheckService.class);
	private ReferenceIdsManager referenceIdsManager = mock(ReferenceIdsManager.class);
	private AccountRepository accountRepository = mock(AccountRepository.class);

	@Before
	public void setup() {
		accountOpeningService = new AccountOpeningService(backGroundCheckService, referenceIdsManager,
				accountRepository);
	}

	@Test
	public void test_should_open_account() throws IOException {
		BackgroundCheckResults value = new BackgroundCheckResults();
		value.setRiskProfile("NO");
		value.setUpperAccountLimit(100);
		when(backGroundCheckService.confirm("abc", "abc", "123", new Date())).thenReturn(value);
		when(referenceIdsManager.obtainId("abc", "abc", "123", new Date())).thenReturn("some_id");
		final AccountOpeningStatus result = accountOpeningService.openAccount("abc", "abc", "123", new Date());
		assertEquals(AccountOpeningStatus.OPENED, result);
		
	}

	@Test
	public void test_should_not_create_account_due_to_risk_profile() throws IOException {
		when(backGroundCheckService.confirm("Mukesh", "Kumar", "123", new Date()))
				.thenReturn(new BackgroundCheckResults(UNACCEPTABLE_RISK_PROFILE, 0));
		AccountOpeningStatus result = accountOpeningService.openAccount("Mukesh", "Kumar", "123", new Date());
		assertEquals(AccountOpeningStatus.DECLINED, result);
	}
	
	@Test
	public void test_should_not_create_account_due_to_null_risk_profile() throws IOException {
		when(backGroundCheckService.confirm("abc", "abc", "1234", new Date())).thenReturn(null);
		AccountOpeningStatus result = accountOpeningService.openAccount("abc", "abc", "1234", new Date());
		assertEquals(AccountOpeningStatus.DECLINED, result);
		
		
	}
	
	@Test(expected = IOException.class)
	public void test_if_backgroundChecksService_should_throw_exception() throws IOException {
		when(backGroundCheckService.confirm("abc", "abc", "123", new Date())).thenThrow(new IOException());
		throw new IOException();
	}
	
	
}
