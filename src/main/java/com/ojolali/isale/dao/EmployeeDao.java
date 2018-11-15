package com.ojolali.isale.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ojolali.isale.model.Employee;

/**
 * 
 * @author mwiyono
 *
 */
@Repository
public interface EmployeeDao extends PagingAndSortingRepository<Employee, String> {
	Employee findOneByEmail(String email);

	Page<Employee> findByNameContainingIgnoreCase(String name, Pageable pageable);

	public Employee findByUserId(String userId);
}
