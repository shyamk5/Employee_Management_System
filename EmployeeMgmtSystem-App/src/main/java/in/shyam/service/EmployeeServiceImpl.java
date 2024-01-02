package in.shyam.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.shyam.model.Employee;
import in.shyam.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo repo;
	
	
	
	@Override
	public List<Employee> getAllEmployee() {
		return repo.findAll();
	}

	@Override
	public void save(Employee emp) {
		if(Objects.nonNull(emp)) {
			repo.save(emp);
		}
	}

	@Override
	public Employee getById(Integer id) {
		Employee emp = null;
		if(Objects.nonNull(id)) {
			Optional<Employee> optEmp = repo.findById(id);
			if(optEmp.isPresent()) {
				emp = optEmp.get();
			}
			else {
				throw new RuntimeException("Employee Not Found with the id: "+id);
			}
		}
		return emp;
	}

	@Override
	public void deleteById(Integer id) {
		if(Objects.nonNull(id)) {
			repo.deleteById(id);
		}
	}

}
