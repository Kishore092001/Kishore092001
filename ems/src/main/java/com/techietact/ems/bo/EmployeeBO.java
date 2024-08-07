package com.techietact.ems.bo;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EmployeeBO {

	private int employeeId;
	
	@NotBlank(message = "Employee Name is Required")
	private String employeeName;
	
	@NotBlank(message = "Email Address is Required")
	@Pattern(message = "Invalid Email Address", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
	private String email;
	
	@NotBlank(message = "Password is Required")
	@Size(min = 6, message = "Password must contain atleast 6 characters")
	private String password;
	
	@Range(min = 999999999, message = "Invalid Mobile Number")
	@Digits(integer = 10, fraction = 0, message = "Mobile Number must contain 10 digits only")
	private long mobileNumber;
	
	@NotBlank(message = "Gender is Required")
	private String gender;
	
	@NotBlank(message = "Date of Birth is Required")
	private String dateOfBirth;

	@NotBlank(message = "Address is Required")
	private String address;

	@NotBlank(message = "City Name is Required")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "City Name must contain alphabets only")
	private String city;

	@NotBlank(message = "Country Name is Required")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Country Name must contain alphabets only")
	private String country;

}
