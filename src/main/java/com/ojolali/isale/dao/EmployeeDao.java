package com.ojolali.isale.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ojolali.isale.model.Employee;

/**
 * 
 * @author mwiyono
 *
 */
@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface EmployeeDao extends PagingAndSortingRepository<Employee, String> {
//	public Employee findOneByEmail(String email);
//
//	public Page<Employee> findByNameContainingIgnoreCase(String name, Pageable pageable);
//
//	public Employee findByUserId(String userId);
}
