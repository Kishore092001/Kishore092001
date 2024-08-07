package com.techietact.ems.dao;

import java.util.List;

import com.techietact.ems.vo.EmployeeVO;

public interface EmployeeDao {

	public EmployeeVO createEmployee(EmployeeVO employeeVo);

	public List<EmployeeVO> getEmployeeList();

	public List<EmployeeVO> searchEmployee(String employeeName);

	public EmployeeVO viewEmployee(int id);

	public int updateEmployee(EmployeeVO employeeVo);

	public int deleteEmployee(int id);

}
