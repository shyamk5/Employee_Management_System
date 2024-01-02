package in.shyam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import in.shyam.model.Employee;
import in.shyam.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	
	@GetMapping("/")
	public String loadIndexPage(Model model) {
		model.addAttribute("allEmpList",service.getAllEmployee());
		return "index";
	}
	
	
	@GetMapping("/add")
	public String addNewEmployee(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "employee";
	}
	
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee emp) {
		service.save(emp);
		return "redirect:/";
	}
	
	
	@GetMapping("updateform/{id}")
	public String updateForm(@PathVariable(value = "id") Integer id, Model model) {
		Employee emp = service.getById(id);
		model.addAttribute("employee", emp);
		return "update";
	}
	
	
	@GetMapping("/delete/{id}")
	public String deleteById(@PathVariable(value = "id") Integer id, Model model) {
		service.deleteById(id);
		return "redirect:/";
	}
	
}
