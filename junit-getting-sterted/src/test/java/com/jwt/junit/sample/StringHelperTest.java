package com.jwt.junit.sample;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StringHelperTest {

	private StringHelper helper;

	@Before
	public void setup() {
		System.out.println("This method will execute before every test case...");
		helper = new StringHelper();

	}

	// AABC => Bc ABC => BC CDEF => CDEF CDAA => CDAA
	@Test
	public void test_truncateAInFirst2Positions() {
		String result = helper.truncateAInFirst2Positions("AABC");
		assertEquals("BC", result);
	}

	@Test
	public void test_truncateAInFirst2Positions_input_length_less_than2() {
		String result = helper.truncateAInFirst2Positions("AB");
		assertEquals("B", result);
	}

	// ABCD => false ABAB => true AB => true A => false
	@Test
	public void test_areFirstAndLastTwoCharactersTheSame() {
		boolean result = helper.areFirstAndLastTwoCharactersTheSame("ABAB");
		assertEquals(true, result);

	}

	@Test
	public void test_areFirstAndLastTwoCharactersTheSame_length_2() {
		boolean result = helper.areFirstAndLastTwoCharactersTheSame("ab");
		assertEquals(true, result);

	}

	@Test
	public void test_areFirstAndLastTwoCharactersTheSame_length_1() {
		boolean result = helper.areFirstAndLastTwoCharactersTheSame("a");
		assertEquals(false, result);

	}

	@Test
	public void test_areFirstAndLastTwoCharactersTheSame_length_3() {
		boolean result = helper.areFirstAndLastTwoCharactersTheSame("abc");
		assertEquals(false, result);

	}
	
	@After
	public void tearDown() {
		System.out.println("This method will execute afer every test case...");
		helper = null;
	}

}
