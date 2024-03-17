package com.example.EmployeeService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmployeeService.Model.Employee;
import com.example.EmployeeService.Service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService empService;
	
	public EmployeeController(EmployeeService empService) {
		this.empService=empService;
	}
	
	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		return new ResponseEntity<List<Employee>>(empService.getAllEmployee(),HttpStatus.OK);		
	}
	@GetMapping("/employee/{id}")
	public ResponseEntity<Object> findEmpById(@PathVariable Long id){
		return new ResponseEntity<Object>(empService.findByDeptId(id),HttpStatus.OK);
	}
	@PostMapping("/employee/saveEmployee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee request){
		return new ResponseEntity<>(empService.saveEmployee(request),HttpStatus.CREATED);
	}
}
