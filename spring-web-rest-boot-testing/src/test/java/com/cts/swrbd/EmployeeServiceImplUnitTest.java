package com.cts.swrbd;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.swrbd.dao.EmployeeRepository;
import com.cts.swrbd.model.Department;
import com.cts.swrbd.model.Employee;
import com.cts.swrbd.service.EmployeeService;
import com.cts.swrbd.service.EmployeeServiceImpl;

@RunWith(SpringRunner.class)
public class EmployeeServiceImplUnitTest {
	@TestConfiguration
	static class EmployeeServiceImplTestContextConfiguration{
		
		@Bean
		public EmployeeService employeeService() {
			return new EmployeeServiceImpl();
		}
	}
	
	@Autowired
	private EmployeeService employeeService;
	
	@MockBean
	private EmployeeRepository employeeRepository;
	
	@Before
	public void setUp() {
		Employee emp=new Employee("Kumar","reddy",48000,LocalDate.now(),Department.DEVELOPMENT,"9000076582","kumar@gmail.com");
		Mockito.when(employeeRepository.findByMobileNumber(emp.getMobileNumber())).thenReturn(emp);
	}
	@Test
	public void whenValidMobileNumber_thenEmployeeShouldBeFound() {
		String mno="9000076582";
		Employee found=employeeService.findByMobileNumber(mno);
		assertThat(found.getMobileNumber()).isEqualTo(mno);
	}
	@Test
	public void whenInvalidMobileNumber_thenEmployeeShouldNotBeFound() {
		String mno="123456789";
		Employee found=employeeService.findByMobileNumber(mno);
		assertThat(found).isNull();
	}

}
