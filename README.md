# springboot-2-angular-8-crud

Learn how to develop a CRUD (Create, Read, Update, Delete) Web Application using Angular 8 as a front-end and Spring boot 2 restful API as a backend.

## Features Implementation
* Create an Employee
* Update an Employee
* List of Employees
* Delete Employee
* View Employee

1. **rest-server**: This project is used to develop CRUD RESTFul APIs for a simple using Spring Boot 2, JPA and MySQL as a database.

## Tools and technologies used

### Server-side technologies
* Spring Boot - 2.2.1.RELEASE
* JDK - 1.11
* Spring Framework - 5.0.8 RELEASE
* Hibernate - 5.2.17.Final
* Spring Data JPA - 2+

## Tools
* Maven - 3.2+

### Spring Boot CRUD Rest APIs Development

| API Name         | Path                  |     Status Code   |    Description               |
| ----------- | ----------- |  ----------- |  ----------- |
| GET Employees   | /api/v1/employees      | 200 (OK)          | All employees are fetched    |
| POST Employee   | /api/v1/employees      | 201 (Created)     | Create new Employee resource |
| GET Employee    | /api/v1/employees/{id} | 200 (OK)          | One Employee is fetched      |
| PUT Employee    | /api/v1/employees/{id} | 200 (OK)          | Employee resource is updated |
| DELETE Employee | /api/v1/employees/{id} | 204 (No Content)  | Create new Employee resource |
