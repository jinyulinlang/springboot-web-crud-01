package com.gao.dao;

import com.gao.entities.Department;
import com.gao.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employees = null;
    @Autowired
    private DepartmentDao departmentDao;

    @PostConstruct
    public void init() {
        employees = new HashMap<> ();
        employees.put (1001, new Employee (1001, "E-AA", "aa@163.com", 1, new Department (101, "D-AA")));
        employees.put (1002, new Employee (1002, "E-BB", "bb@163.com", 1, new Department (101, "D-BB")));
        employees.put (1003, new Employee (1003, "E-CC", "cc@163.com", 01, new Department (101, "D-CC")));
        employees.put (1004, new Employee (1004, "E-DD", "dd@163.com", 0, new Department (101, "D-DD")));
        employees.put (1005, new Employee (1005, "E-EE", "ee@163.com", 1, new Department (101, "D-EE")));

    }

    public static Integer initId = 1006;

    public void save(Employee employee) {
        if (employee.getId () == null) {
            employee.setId (initId++);
        }
        employee.setDepartment (departmentDao.getDepartment (employee.getDepartment ().getId ()));
        employees.put (employee.getId (), employee);
    }


}
