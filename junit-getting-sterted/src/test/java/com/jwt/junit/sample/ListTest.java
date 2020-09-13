package com.jwt.junit.sample;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;

import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

public class ListTest {
	
	@Test
	public void test_list_size() {
		List list = mock(List.class);
		Mockito.when(list.size()).thenReturn(3);
		assertEquals(3, list.size());
	}
	
	@Test
	public void test_list_get() {
		List<String> list = mock(List.class);
		Mockito.when(list.get(0)).thenReturn("abcd");
		assertEquals("abcd", list.get(0));
		assertNull(list.get(1));
	}
	
	@Test
	public void test_list_get_with_any() {
		List<String> list = mock(List.class);
		Mockito.when(list.get(anyInt())).thenReturn("abcd");
		assertEquals("abcd", list.get(0));
		assertEquals("abcd", list.get(3));
	}

}
