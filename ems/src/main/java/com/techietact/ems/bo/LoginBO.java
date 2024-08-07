package com.techietact.ems.bo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LoginBO {

	
	private int employeeId;

	@NotBlank(message = "Email Address is Required")
	@Pattern(message = "Invalid Email Address", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
	private String email;

	@NotBlank(message = "Password is Required")
	@Size(min=6,message="Password must contain atleast 6 characters")
	private String password;
}
