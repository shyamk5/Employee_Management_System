package in.shyam.service;

import java.util.List;

import in.shyam.model.Employee;

public interface EmployeeService {
	
	
	public List<Employee> getAllEmployee();
	
	public void save(Employee emp);
	
	public Employee getById(Integer id);
	
	public void deleteById(Integer id);
	
}
