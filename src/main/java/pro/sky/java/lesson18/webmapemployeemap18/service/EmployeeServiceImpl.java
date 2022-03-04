package pro.sky.java.lesson18.webmapemployeemap18.service;


import org.springframework.stereotype.Service;
import pro.sky.java.lesson18.webmapemployeemap18.exceptions.EmployeeIsAlreadyInsideMapException;
import pro.sky.java.lesson18.webmapemployeemap18.exceptions.EmployeeIsNotFoundException;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    Map<Employee, Integer> mapEmployee = new HashMap<>();
    private int count = 0;

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee addingEmployee = new Employee(firstName, lastName);
        if (mapEmployee.containsKey(addingEmployee)) {
            throw new EmployeeIsAlreadyInsideMapException("Employee is already inside map");
        }
        mapEmployee.put(addingEmployee, count);
        count++;
        return addingEmployee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee removingEmployee = new Employee(firstName, lastName);
        if (!mapEmployee.containsKey(removingEmployee)) {
            throw new EmployeeIsNotFoundException("Employee is not found");
        }
        mapEmployee.remove(removingEmployee);
        return removingEmployee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee ourEmployee = new Employee(firstName, lastName);
        if (!mapEmployee.containsKey(ourEmployee)) {
            throw new EmployeeIsNotFoundException("Employee is not found");
        }
        return ourEmployee;
    }

    @Override
    public Map<Employee, Integer> printAllEmployees() {
        return mapEmployee;
    }
}
