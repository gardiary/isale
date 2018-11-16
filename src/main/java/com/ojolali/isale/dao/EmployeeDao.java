package com.ojolali.isale.dao;

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
//	public Employee findOneByEmail(String email);
//
//	public Page<Employee> findByNameContainingIgnoreCase(String name, Pageable pageable);
//
//	public Employee findByUserId(String userId);
}
