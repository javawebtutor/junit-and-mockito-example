package com.jwt.data.bo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.jwt.data.api.TodoService;

public class TodoBusinessImplTest {

	@Test
	public void test_retrieveTodosRelatedToSpring() {
		
		TodoService todoService = mock(TodoService.class);
		List<String> value = new ArrayList<>();
		value.add("Spring A");
		value.add("b");
		value.add("Spring S");
		when(todoService.retrieveTodos("Spring")).thenReturn(value);
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		List<String> result = todoBusinessImpl.retrieveTodosRelatedToSpring("Spring");
		assertEquals(2, result.size());
		
		
	}

}
