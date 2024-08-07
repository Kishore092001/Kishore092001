package com.techietact.ems.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.techietact.ems.vo.EmployeeVO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private EntityManager entity;

	@Override
	public EmployeeVO createEmployee(EmployeeVO employeeVo) {
		
		try {
			
			entity.persist(employeeVo);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return employeeVo;
	}

	@Override
	public List<EmployeeVO> getEmployeeList() {
		List<EmployeeVO> list = null;
		try {
			
			CriteriaBuilder criteriaBuilder = entity.getCriteriaBuilder();
			CriteriaQuery<EmployeeVO> criteriaQuery = criteriaBuilder.createQuery(EmployeeVO.class);
			Root<EmployeeVO> root = criteriaQuery.from(EmployeeVO.class);
			criteriaQuery.select(root);
			Query query = entity.createQuery(criteriaQuery);
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return list;
	}

	@Override
	public List<EmployeeVO> searchEmployee(String employeeName) {
		List<EmployeeVO> list = null;
		try {
						
			
			String hql = "from EmployeeVO where employee_name like '%" + employeeName + "%'";
			Query query = entity.createQuery(hql);
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return list;
	}

	@Override
	public EmployeeVO viewEmployee(int id) {
		EmployeeVO employee = null;
		try {
			

			employee =  entity.find(EmployeeVO.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return employee;
	}

	@Override
	public int updateEmployee(EmployeeVO employeeVo) {
		int id = 0;
		try {
			

			entity.merge(employeeVo);
			if (null != employeeVo ) {
				id = employeeVo.getEmployeeId();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public int deleteEmployee(int id) {
		int status = 1;
		try {

			
			EmployeeVO employee = viewEmployee(id);
			entity.remove(employee);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return status;
	}

}
