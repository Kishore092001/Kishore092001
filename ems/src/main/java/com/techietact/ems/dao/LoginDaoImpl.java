package com.techietact.ems.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.techietact.ems.vo.LoginVO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class LoginDaoImpl implements LoginDao {

	@Autowired
	private EntityManager entity;

	@Override
	public boolean isUser(LoginVO loginVo) {
		boolean isUser = false;

		try {
		
			CriteriaBuilder criteriaBuilder = entity.getCriteriaBuilder();
			CriteriaQuery<LoginVO> criteriaQuery = criteriaBuilder.createQuery(LoginVO.class);
			Root<LoginVO> root = criteriaQuery.from(LoginVO.class);
			Predicate[] predicates = new Predicate[2];
			predicates[0] = criteriaBuilder.equal(root.get("email"), loginVo.getEmail());
			predicates[1] = criteriaBuilder.equal(root.get("password"), loginVo.getPassword());
			criteriaQuery.select(root).where(predicates);
			Query query = entity.createQuery(criteriaQuery);
			LoginVO user = (LoginVO) query.getSingleResult();
			if (user.getEmployeeId() > 0) {
				isUser = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			
		}

		return isUser;
	}

}
