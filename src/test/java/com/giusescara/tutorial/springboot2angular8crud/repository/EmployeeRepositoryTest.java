package com.giusescara.tutorial.springboot2angular8crud.repository;

import com.giusescara.tutorial.springboot2angular8crud.exception.ResourceNotFoundException;
import com.giusescara.tutorial.springboot2angular8crud.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;

@Ignore
@DataJpaTest
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository repository;

    private String getName() {
        return null;
    }

    @Test(expectedExceptions = ResourceNotFoundException.class)
    void testSaveEmployee() throws ResourceNotFoundException {
        Employee employee = new Employee("John", "Smith", "john.smith@email.com");
        repository.save(employee);
        employee = repository.findById(employee.getId()).orElseThrow(() -> new ResourceNotFoundException(""));
        assertNotNull(employee);
        assertEquals(employee.getFirstName(), "John", "The employee firstname should be John");
    }

    @Test
    void testGetEmployee() throws ResourceNotFoundException {
        Employee employee = new Employee("John", "Smith", "john.smith@email.com");
        repository.save(employee);
        employee = repository.findById(employee.getId()).orElseThrow(() -> new ResourceNotFoundException(""));
        assertNotNull(employee);
        assertEquals(employee.getFirstName(), "John", "The employee firstname should be John");
    }

    @Test
    void testDeleteEmployee() {
        Employee employee = new Employee("John", "Smith", "john.smith@email.com");
        repository.save(employee);
        repository.delete(employee);
        assertNull(repository.findAll(), "No employee in the database");
    }
}