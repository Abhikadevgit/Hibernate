package com.example.demo;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.dao.EmployeeDAOImpl;
import com.example.demo.entity.Employee;
import com.example.demo.util.HibernateUtil;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();

        // Create a new employee
        Employee emp1 = new Employee("John Doe", "john@example.com");
        employeeDAO.saveEmployee(emp1);
        System.out.println("Employee saved: " + emp1);

        // Read employee by id
        Employee fetchedEmployee = employeeDAO.getEmployee(emp1.getId());
        System.out.println("Employee fetched: " + fetchedEmployee);

        // Update employee
        fetchedEmployee.setEmail("john.doe@newdomain.com");
        employeeDAO.updateEmployee(fetchedEmployee);
        System.out.println("Employee updated: " + fetchedEmployee);

        // Create another employee
        Employee emp2 = new Employee("Jane Smith", "jane@example.com");
        employeeDAO.saveEmployee(emp2);

        // Get all employees
        List<Employee> employees = employeeDAO.getAllEmployees();
        System.out.println("All employees:");
        for (Employee emp : employees) {
            System.out.println(emp);
        }

        // Delete an employee
        employeeDAO.deleteEmployee(emp2.getId());
        System.out.println("Deleted employee with id: " + emp2.getId());

        // Verify deletion
        employees = employeeDAO.getAllEmployees();
        System.out.println("Employees after deletion:");
        for (Employee emp : employees) {
            System.out.println(emp);
        }

        // Shutdown Hibernate SessionFactory
        HibernateUtil.shutdown();
    }
}
