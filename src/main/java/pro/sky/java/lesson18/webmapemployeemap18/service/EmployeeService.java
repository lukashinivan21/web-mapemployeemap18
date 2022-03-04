package pro.sky.java.lesson18.webmapemployeemap18.service;

import java.util.Map;

public interface EmployeeService {

    Employee addEmployee(String firstName, String lastName);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    Map<Employee, Integer> printAllEmployees();
}
