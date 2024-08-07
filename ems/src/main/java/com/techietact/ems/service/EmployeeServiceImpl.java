package com.techietact.ems.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techietact.ems.bo.EmployeeBO;
import com.techietact.ems.dao.EmployeeDao;
import com.techietact.ems.vo.EmployeeVO;
import com.techietact.ems.vo.LoginVO;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Component
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeDao employeeDao;

	@Override
	public EmployeeBO createEmployee(EmployeeBO employeeBo) {
		
		try {
			if (null != employeeBo) {
				EmployeeVO employeeVo = new EmployeeVO();
				BeanUtils.copyProperties(employeeBo, employeeVo);
				LoginVO loginVo = new LoginVO();
				loginVo.setEmail(employeeBo.getEmail());
				loginVo.setPassword(employeeBo.getPassword());
				employeeVo.setLogin(loginVo);
				employeeDao.createEmployee(employeeVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}

		return employeeBo;
	}

	@Override
	public List<EmployeeBO> getEmployeeList() {
		List<EmployeeBO> listBO = new ArrayList<>(); 

		try {
			List<EmployeeVO> listVo = employeeDao.getEmployeeList();
			if (null != listVo && !listVo.isEmpty()) {
				for(EmployeeVO employeeVo : listVo) {
					EmployeeBO employeeBo = new EmployeeBO();
					BeanUtils.copyProperties(employeeVo, employeeBo);
					listBO.add(employeeBo);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}

		return listBO;
	}

	@Override
	public List<EmployeeBO> searchEmployee(String employeeName) {
List<EmployeeBO> listBo = null;
		
		try {
			List<EmployeeVO> listVo = employeeDao.searchEmployee(employeeName);
			if(null!=listVo && !listVo.isEmpty()) {
				listBo = new ArrayList<>();
				for(EmployeeVO employeeVo : listVo) {
					EmployeeBO employeeBo = new EmployeeBO();
					BeanUtils.copyProperties(employeeVo, employeeBo);
					listBo.add(employeeBo);
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return listBo;
		
	}

	@Override
	public EmployeeBO viewEmployee(int id) {

		EmployeeBO employeeBo = null;
		try {
			EmployeeVO employeeVo = employeeDao.viewEmployee(id);
			if(null!=employeeVo && employeeVo.getEmployeeId()>0) {
				employeeBo = new EmployeeBO();
				BeanUtils.copyProperties(employeeVo, employeeBo);
			}
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		return employeeBo;
	}

	@Override
	public int updateExmployee(@Valid EmployeeBO employeeBo) {
		int id = 0;
		try {
			if( null!= employeeBo && employeeBo.getEmployeeId()>0) {

				EmployeeVO employeeVo = new EmployeeVO();
				BeanUtils.copyProperties(employeeBo, employeeVo);
				LoginVO loginVo = new LoginVO();
				loginVo.setEmployeeId(employeeDao.viewEmployee(employeeBo.getEmployeeId()).getLogin().getEmployeeId());
				loginVo.setEmail(employeeBo.getEmail());
				loginVo.setPassword(employeeBo.getPassword());
				employeeVo.setLogin(loginVo);
				id = employeeDao.updateEmployee(employeeVo);
			}			
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		return id;
	}

	@Override
	public int deleteEmployee(int id) {
		int status = 0;
		try {
			if(id>0) {
				 status = employeeDao.deleteEmployee(id);
			}
		} catch(Exception e) {
			e.printStackTrace();
			
		}
		return status;
	}

}
