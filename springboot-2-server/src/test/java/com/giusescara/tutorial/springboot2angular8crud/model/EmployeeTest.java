package com.giusescara.tutorial.springboot2angular8crud.model;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    private Employee employee;

    @BeforeEach
    void setUp() {
        employee = new Employee("John", "Smith", "john.smith@email.com");
    }

    @Test
    void checkEmployee() {
        assertNotNull(employee, "The employee should not be null");
    }

    @Test
    void getId() {
        assertNotNull(employee.getId(), "The employee id should not be null");
    }

    @Test
    void setId() {
        employee.setId(5);
        assertEquals(employee.getId(), 5, "The employee id should be 5");
    }

    @Test
    void getFirstName() {
        assertEquals(employee.getFirstName(), "John", "The employee first name should be John");
    }

    @Test
    void setFirstName() {
        employee.setFirstName("Marc");
        assertNotEquals(employee.getFirstName(), "John", "The employee firstname should not be John");
        assertEquals(employee.getFirstName(), "Marc", "The employee first name should be Marc");
    }

    @Test
    void getLastName() {
        assertEquals(employee.getLastName(), "Smith", "The employee lastname should be Smith");
    }

    @Test
    void setLastName() {
        employee.setLastName("Brezel");
        assertNotEquals(employee.getLastName(), "Smith", "The employee lastname should not be Smith");
        assertEquals(employee.getLastName(), "Brezel", "The employee first name should be Brezel");
    }

    @Test
    void getEmail() {
        assertEquals(employee.getEmail(), "john.smith@email.com", "The employee email should be john.smith@email.com");
    }

    @Test
    void setEmail() {
        employee.setEmail("marc.brezel@gmail.com");
        assertNotEquals(employee.getEmail(), "john.smith@email.com", "The employee email should not be john.smith@email.com");
        assertEquals(employee.getEmail(), "marc.brezel@gmail.com", "The employee first name should be marc.brezel@gmail.com");
    }

    @Test
    void testToString() {
        assertNotNull(employee.toString());
    }

    @AfterEach
    void tearDown() {
        employee = null;
    }
}