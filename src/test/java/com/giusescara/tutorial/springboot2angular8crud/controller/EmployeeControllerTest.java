package com.giusescara.tutorial.springboot2angular8crud.controller;

import com.giusescara.tutorial.springboot2angular8crud.Application;
import com.giusescara.tutorial.springboot2angular8crud.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmployeeControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String url;

    @BeforeEach
    void setUp() {
        url = "http://localhost:" + port + "/crud-rest/api/v1/employees";
    }

    @Test
    void getAllEmployees() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url,
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody(), "The body should not be null");
        assertTrue(response.getBody().contains("lastName"), "The body should contains lastname");
    }

    @Test
    @RepeatedTest(5)
    void createEmployee() {
        Employee employee = new Employee();
        employee.setFirstName("FirstName");
        employee.setLastName("LastName");
        employee.setEmail("Email");
        ResponseEntity<Employee> response = restTemplate.postForEntity(url, employee, Employee.class);
        assertNotNull(response, "The response should not be null");
        assertEquals(response.getBody().getFirstName(), "FirstName", "The employee first name should be FirstName");

    }

    @Test
    void getEmployeeId() {
        Employee employee = restTemplate.getForObject(url + "/1", Employee.class);
        assertNotNull(employee, "The employee should not be null");
        assertEquals(employee.getFirstName(), "Lokesh", "The employee first name should be Lokesh");
    }

    @Test
    void updateEmployee() {
        Employee employee = restTemplate.getForObject(url + "/3", Employee.class);
        assertNotNull(employee);
        employee.setFirstName("FirstName");
        employee.setLastName("LastName");
        restTemplate.put(url + "/3", employee);
        employee = restTemplate.getForObject(url + "/3", Employee.class);
        assertEquals(employee.getFirstName(), "FirstName", "The employee firstname should be FirstName");
        assertEquals(employee.getLastName(), "LastName", "The employee lastname should be LastName");
    }

    @Test
    void deleteEmployee() {
        Employee employee = restTemplate.getForObject(url + "/2", Employee.class);
        assertNotNull(employee);
        restTemplate.delete(url + "/2");
        restTemplate.getForObject(url + "/2", Employee.class);
    }
}