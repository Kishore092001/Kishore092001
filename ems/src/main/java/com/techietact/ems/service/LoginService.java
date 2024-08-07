package com.techietact.ems.service;

import com.techietact.ems.bo.LoginBO;

import jakarta.validation.Valid;

public interface LoginService {

	public boolean isUser(@Valid LoginBO loginBo);

}
