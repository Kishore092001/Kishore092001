package com.techietact.ems.vo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Employee")
public class EmployeeVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="employee_id")
	private int employeeId;
	
	@Column(name="Employee_name",length=25,nullable=false)
	private String employeeName;
	
	@Column(name="email",length=40,nullable=false)
	private String email;
	
	@Column(name="password",length=15,nullable=false)
	private String password;
	
	@Column(name="mobile_number",length=10,nullable=false)
	private long mobileNumber;
	
	@Column(name="gender",nullable=false)
	private String gender;
	
	@Column(name="date_of_birth",length=10,nullable=false)
	private String dateOfBirth;
	
	@Column(name="address",length=25,nullable=false)
	private String address;
	
	@Column(name="city",length=30,nullable=false)
	private String city;
	
	@Column(name="country",length=20,nullable=false)
	private String country;
	
	
	@OneToOne(cascade =CascadeType.ALL)
	@JoinColumn(name="user_id")
	private LoginVO login;

}
