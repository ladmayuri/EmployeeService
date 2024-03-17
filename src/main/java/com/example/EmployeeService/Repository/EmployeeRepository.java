package com.example.EmployeeService.Repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.EmployeeService.Model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee,Long>{
	
	List<Employee> findBydeptId(Long deptId);

}
