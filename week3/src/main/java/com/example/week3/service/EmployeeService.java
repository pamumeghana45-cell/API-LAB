package com.example.week3.service;

import com.example.week3.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private static final Logger logger =
            LoggerFactory.getLogger(EmployeeService.class);

    public Employee getEmployee() {

        logger.info("Fetching employee details");

        Employee employee =
                new Employee(101, "Meghana", "AI & ML");

        logger.debug("Employee created: {}", employee);

        return employee;
    }
}