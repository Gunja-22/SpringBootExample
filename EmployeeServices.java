package com.SpringBoot.SpringBootExample.services;

import com.SpringBoot.SpringBootExample.model.Employee;
import com.SpringBoot.SpringBootExample.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServices {
    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeServices(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    //get all employees
    public List<Employee> getAllEmployees()
    {
        List<Employee> list = (List<Employee>)this.employeeRepository.findAll();
        return list;
    }

    //get single employee by id
    public Optional<Employee> getEmployeeById(long id) {
        Optional<Employee> employee = null;
        try {
            employee=this.employeeRepository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employee;
    }

    //create data of employee
    public Employee addEmployee(Employee e)
    {
        Employee result=employeeRepository.save(e);
        return result;
    }

    //delete a employee
    public void deleteEmployee(int eid)
    {
        employeeRepository.deleteById((long) eid);
    }

    //update employee
    public void updateEmployee(Employee employee, int employeeId)
    {
        employee.setId(employeeId);
        employeeRepository.save(employee);
    }
}
