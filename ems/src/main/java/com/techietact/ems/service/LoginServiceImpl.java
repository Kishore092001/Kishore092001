package com.techietact.ems.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techietact.ems.bo.LoginBO;
import com.techietact.ems.dao.LoginDao;
import com.techietact.ems.vo.LoginVO;

import jakarta.validation.Valid;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDao loginDao;

	@Override
	public boolean isUser(@Valid LoginBO loginBo) {
		boolean isUser = false;

		try {

			LoginVO loginVo = new LoginVO();

			if (null != loginBo) {
				BeanUtils.copyProperties(loginBo, loginVo);
				if (loginDao.isUser(loginVo)) {
					isUser = true;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return isUser;
	}

}
