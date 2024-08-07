package com.techietact.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techietact.ems.bo.EmployeeBO;
import com.techietact.ems.bo.LoginBO;
import com.techietact.ems.service.EmployeeService;
import com.techietact.ems.service.LoginService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class EmployeeController {
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	EmployeeService employeeService;

	@GetMapping("/")
	public String getIndexPage() {
		return "index";
	}
	
	@GetMapping("/login")
	public String getLoginPage(Model model) {

		LoginBO user = new LoginBO();
		model.addAttribute("user", user);
		return "login";
	}

	@PostMapping("/login")
	public ModelAndView login(@Valid @ModelAttribute("user") LoginBO user, BindingResult result ,HttpServletRequest request,RedirectAttributes redirectAttributes) {

		ModelAndView model = new ModelAndView();
		if (result.hasErrors()) {
			model.addObject("user", user);
			model.setViewName("login");
		} else {
		try {
			if(null != user && !user.getEmail().isEmpty() && !user.getPassword().isEmpty()) {
				if (loginService.isUser(user)) {
					HttpSession session = request.getSession();
					session.setAttribute("loggedInUser", user.getEmail());
					redirectAttributes.addFlashAttribute("successMessage", "Login Successfully");
					model.setViewName("redirect:/home");
				} else {
					redirectAttributes.addFlashAttribute("errorMessage", "Incorrect Username or Password");
					model.setViewName("login");
				}
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		}
		return model;
	}
	
	@GetMapping("/home")
	public String getHomePage(HttpServletRequest request) {

		HttpSession session = request.getSession();
		if (null != session.getAttribute("loggedInUser")) {
			return "home";
		}
		
		return "redirect:/login";
	}

	@GetMapping("/create")
	public String getCreatePage(Model model, HttpServletRequest request) {

		HttpSession session = request.getSession();
		if (null != session.getAttribute("loggedInUser")) {
			EmployeeBO employee = new EmployeeBO();
			model.addAttribute("employee", employee);
			return "create";
		}

		return "redirect:/login";
	}

	@PostMapping("/create")
	public ModelAndView create(@Valid @ModelAttribute("employee") EmployeeBO employee, BindingResult result,RedirectAttributes redirectAttributes) {

		ModelAndView model = new ModelAndView();
		if (result.hasErrors()) {
			model.addObject("employee", employee);
			model.setViewName("create");
		} else {
			try {
				if (employeeService.createEmployee(employee)!=null) {
					redirectAttributes.addFlashAttribute("successMessage", "Create Employee successfully registered");
				} else {
					redirectAttributes.addFlashAttribute("errorMessage", "Create Employee Registration failed");
				}
				model.setViewName("redirect:/list");
			} catch (Exception e) {
				
			}
		}
		
		return model;
	}
	
	@GetMapping("/list")
	public String getListPage(Model model,HttpServletRequest request) {

		HttpSession session = request.getSession();
		if(null != session.getAttribute("loggedInUser")) {
			EmployeeBO employee = new EmployeeBO();
			model.addAttribute("employee", employee);
			List<EmployeeBO> employeeList = employeeService.getEmployeeList();
			if (null != employeeList && !employeeList.isEmpty()) {
				model.addAttribute("employeeList", employeeList);
			} else {
				model.addAttribute("errorMessage", "No Records Found");
			}
			return "list";
		}
		
		return "redirect:/login";
	}

	@PostMapping("/search")
	public ModelAndView searchEmployee(@ModelAttribute("employee") EmployeeBO employee, HttpServletRequest request,
			RedirectAttributes redirectAttributes) {
		
		ModelAndView model = new ModelAndView();
		
		HttpSession session = request.getSession();
		if(null != session.getAttribute("loggedInUser")) {
			try {
				if (null != employee && !employee.getEmployeeName().isEmpty()) {

					String employeeName = employee.getEmployeeName();
					List<EmployeeBO> employeeList = employeeService.searchEmployee(employeeName);
					model.addObject("employee", employee);
					if (null != employeeList && !employeeList.isEmpty()) {
						model.addObject("employeeList", employeeList);
					} else {
						model.addObject("errorMessage", "No Records Found");
					}
					model.setViewName("list");
				} else {
					redirectAttributes.addFlashAttribute("errorMessage", "Employee Name is Required");
					model.setViewName("redirect:/list");
				}
			} catch (Exception e) {
				e.printStackTrace();
				
			}

			
		}
		else {
			model.setViewName("redirect:/login");
		}

		return model;
	}


	@GetMapping("/view")
	public ModelAndView viewEmployee(@RequestParam(value = "id", required = false) int id,
			RedirectAttributes redirectAttributes, HttpServletRequest request) {

		ModelAndView model = new ModelAndView();

		HttpSession session = request.getSession();
		if (null != session.getAttribute("loggedInUser")) {

			try {
				EmployeeBO employee = employeeService.viewEmployee(id);
				if (null != employee && employee.getEmployeeId() > 0) {
					model.addObject("employee", employee);
					
					model.setViewName("view");
				} else {
					redirectAttributes.addFlashAttribute("errorMessage", "No Such Employee Exists");
					model.setViewName("redirect:/list");
				}

			} catch (Exception e) {
				e.printStackTrace();
				
			}
		} else {
			model.setViewName("redirect:/login");
		}

		return model;
	}
	
	@GetMapping("/edit")
	public ModelAndView editEmployee(@RequestParam(value = "id", required = false) int id, HttpServletRequest request,
			RedirectAttributes redirectAttributes) {

		ModelAndView model = new ModelAndView();

		HttpSession session = request.getSession();
		if (null != session.getAttribute("loggedInUser")) {
			try {
				EmployeeBO employee = employeeService.viewEmployee(id);
				if (null != employee && employee.getEmployeeId() > 0) {
					model.addObject("employee", employee);
					model.setViewName("edit");
				} else {
					redirectAttributes.addFlashAttribute("errorMessage", "No Such Employee Exists");
					model.setViewName("redirect:/list");
				}
			} catch (Exception e) {
				e.printStackTrace();
				
			}
		} else {
			model.setViewName("redirect:/login");
		}

		return model;
	}

	@PostMapping("/edit")
	public ModelAndView editEmployee(@Valid @ModelAttribute("employee") EmployeeBO employee, BindingResult result,
			RedirectAttributes redirectAttributes, HttpServletRequest request) {

		ModelAndView model = new ModelAndView();
		
		HttpSession session = request.getSession();
		if(null != session.getAttribute("loggedInUser")) {
			if (result.hasErrors()) {
				model.addObject("employee", employee);
				model.setViewName("edit");
			} else {
				try {
					int id = employeeService.updateExmployee(employee);
					if (id > 0) {
						redirectAttributes.addFlashAttribute("successMessage",
								"Employee successfully updated");
					} else {
						redirectAttributes.addFlashAttribute("errorMessage", "Employee Updation failed");
					}
					model.setViewName("redirect:/list");
				} catch (Exception e) {
					e.printStackTrace();
					
				}
			}
		} else {
			model.setViewName("redirect:/login");
		}

		return model;
	}
	

	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam(value = "id", required = false) int id,
			RedirectAttributes redirectAttributes, HttpServletRequest request) {

		HttpSession session = request.getSession();
		if (null != session.getAttribute("loggedInUser")) {
			try {
				if (employeeService.deleteEmployee(id) > 0) {
					redirectAttributes.addFlashAttribute("successMessage",
							"Employee Successfully Deleted");
				} else {
					redirectAttributes.addFlashAttribute("errorMessage", "Employee Deletion failed");
				}
			} catch (Exception e) {
				e.printStackTrace();
				
			}
			return "redirect:/list";
		}
		
		return "login";
		
	}
	
	@GetMapping("/logout")
	public String logout(Model model, HttpServletRequest request,RedirectAttributes redirectAttribute) {

		HttpSession session = request.getSession();
		session.removeAttribute("loggedInUser");
		session.invalidate();

		redirectAttribute.addFlashAttribute("errorMessage", " Successfully Loggedout");
		return "redirect:/login";
	}
}
