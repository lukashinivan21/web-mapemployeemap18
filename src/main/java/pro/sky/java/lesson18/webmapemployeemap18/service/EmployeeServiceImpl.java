package pro.sky.java.lesson18.webmapemployeemap18.service;


import org.springframework.stereotype.Service;
import pro.sky.java.lesson18.webmapemployeemap18.exceptions.EmployeeIsAlreadyInsideMapException;
import pro.sky.java.lesson18.webmapemployeemap18.exceptions.EmployeeIsNotFoundException;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    Map<Integer, Employee> mapEmployee = new HashMap<>();
    private int count = 0;

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee addingEmployee = new Employee(firstName, lastName);
        if (mapEmployee.containsValue(addingEmployee)) {
            throw new EmployeeIsAlreadyInsideMapException("Employee is already inside map");
        }
        mapEmployee.put(count, addingEmployee);
        count++;
        System.out.println(mapEmployee);
        return addingEmployee;
    }

    @Override
    public Employee removeEmployee(Integer key) {
        if (!mapEmployee.containsKey(key)) {
            throw new EmployeeIsNotFoundException("Employee is not found");
        }
        Employee removingEmployee = mapEmployee.get(key);
        mapEmployee.remove(key);
        System.out.println(mapEmployee);
        return removingEmployee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee ourEmployee = new Employee(firstName, lastName);
        if (!mapEmployee.containsValue(ourEmployee)) {
            throw new EmployeeIsNotFoundException("Employee is not found");
        }
        return ourEmployee;
    }

    @Override
    public Map<Integer, Employee> printAllEmployees() {
        return mapEmployee;
    }
}
