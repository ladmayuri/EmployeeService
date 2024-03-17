package com.example.EmployeeService.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.EmployeeService.Model.Employee;
import com.example.EmployeeService.Repository.EmployeeRepository;

@Service
public class EmployeeService {

	private EmployeeRepository empRepo;

	public EmployeeService(EmployeeRepository empRepo) {
		this.empRepo = empRepo;
	}

	public Employee saveEmployee(Employee request) {

		return empRepo.save(request);
	}

	public Employee findEmpById(Long id) {
		Optional<Employee> optDb = empRepo.findById(id);
		if (optDb.isPresent())
			return optDb.get();
		else
			throw new RuntimeException("Record with Id: " + id + " not forund");

	}

	public List<Employee> getAllEmployee() {
		return empRepo.findAll();
	}
	
	public  List<Employee>  findByDeptId(Long id){
		List<Employee> list = empRepo.findBydeptId(id);
		if (list.size()>0)
			return list;
		else
			throw new RuntimeException("Record with Id: " + id + " not forund");
	}

}
