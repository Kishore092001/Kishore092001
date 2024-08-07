package com.techietact.ems.service;

import java.util.List;

import com.techietact.ems.bo.EmployeeBO;

public interface EmployeeService {

	public EmployeeBO createEmployee(EmployeeBO employee);

	public List<EmployeeBO> getEmployeeList();

	public List<EmployeeBO> searchEmployee(String employeeName);

	public EmployeeBO viewEmployee(int id);

	public int updateExmployee( EmployeeBO employee);

	public int deleteEmployee(int id);

}
