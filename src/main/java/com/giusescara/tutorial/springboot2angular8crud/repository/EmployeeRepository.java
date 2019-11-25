package com.giusescara.tutorial.springboot2angular8crud.repository;

import com.giusescara.tutorial.springboot2angular8crud.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
