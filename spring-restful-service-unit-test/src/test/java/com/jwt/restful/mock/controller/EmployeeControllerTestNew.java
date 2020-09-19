package com.jwt.restful.mock.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.jwt.restful.controller.EmployeeController;
import com.jwt.restful.model.Employee;
import com.jwt.restful.service.EmployeeService;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTestNew {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	EmployeeService employeeService;

	private final String URL = "/employee/";

	@Test
	public void test_get_employee() throws Exception {
		Employee employee = new Employee();
		new Employee(1l, "mukesh", "kumar", "tech lead", 50000);
		when(employeeService.getById(any(Long.class))).thenReturn(employee);
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.get(URL + "{id}", new Long(1)).accept(MediaType.APPLICATION_JSON))
				.andReturn();
		// verify
		int status = result.getResponse().getStatus();
		assertEquals(HttpStatus.OK.value(), status);
		// verify that service method was called once
		verify(employeeService).getById(any(Long.class));
	}
	
	@Test
	public void test_get_employee_no_data_found() throws Exception {
		when(employeeService.getById(any(Long.class))).thenReturn(null);
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(URL + "{id}", new Long(1))
				.accept(MediaType.APPLICATION_JSON))
		        .andReturn();
		int status = result.getResponse().getStatus();
		assertEquals(HttpStatus.NOT_FOUND.value(), status);
		verify(employeeService).getById(any(Long.class));
	}
	
	@Test
	public void test_GetAllEmployee() throws Exception {
		ArrayList<Employee> employees = buildEmployees();
		when(employeeService.getAll()).thenReturn(employees);
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(URL).accept(MediaType.APPLICATION_JSON)).andReturn();
		int status = result.getResponse().getStatus();
		assertEquals(HttpStatus.OK.value(), status);
		verify(employeeService).getAll();
	}
	
	@Test
	public void test_get_all_employee_no_data_found() throws Exception {
		ArrayList<Employee> employees = buildEmployees();
		employees.clear();
		when(employeeService.getAll()).thenReturn(employees);
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(URL).accept(MediaType.APPLICATION_JSON)).andReturn();
		int status = result.getResponse().getStatus();
		assertEquals(HttpStatus.NO_CONTENT.value(), status);
		
	}
	
	@Test
	public void test_delete_employee() throws Exception {
		Employee employee = new Employee();
		employee.setId(1l);
		employee.setFirstname("mukesh");
		employee.setLastname("kumar");
		employee.setDesignation("tech lead");
		employee.setSalary(10000);
		when(employeeService.getById(any(Long.class))).thenReturn(employee);
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.delete(URL +"{id}", new Long(1))).andReturn();
		int status = result.getResponse().getStatus();
		assertEquals(HttpStatus.GONE.value(), status);
		verify(employeeService).delete(1l);
		
	}
	
	@Test
	public void test_delete_employee_no_employee_found() throws Exception {
		when(employeeService.getById(any(Long.class))).thenReturn(null);
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.delete(URL +"{id}", new Long(1))).andReturn();
		int status = result.getResponse().getStatus();
		assertEquals(HttpStatus.NOT_FOUND.value(), status);
		verify(employeeService).delete(1l);
	}
	
	

	private ArrayList<Employee> buildEmployees() {
		ArrayList<Employee> employees = new ArrayList<>();
		Employee employee = new Employee();
		employee.setId(1l);
		employee.setFirstname("mukesh");
		employee.setLastname("kumar");
		employee.setDesignation("tech lead");
		employee.setSalary(10000);
		employees.add(employee);
		return employees;
	}
	
	

}
