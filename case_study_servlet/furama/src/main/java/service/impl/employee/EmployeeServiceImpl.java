package service.impl.employee;

import model.employee.Employee;
import repository.IEmployeeRepository;
import repository.impl.EmployeeRepository.EmployeeRepository;
import service.IEmployeeService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeServiceImpl implements IEmployeeService {
    private IEmployeeRepository iEmployeeRepository = new EmployeeRepository();

    @Override
    public List<Employee> getList() {
        List<Employee> employeeList = iEmployeeRepository.getList();
        return employeeList;
    }

    @Override
    public Map<String, String> save(Employee employee) {
        Map<String, String> map = new HashMap<>();
        if (employee.getEmployeeName().equals("")) {
            map.put("name", "Not Null");
        } else if (!employee.getEmployeeName().matches("^[a-zA-Z ]+$")) {
            map.put("name", "Invalid name");
        }

        if (map.isEmpty()) {
            iEmployeeRepository.save(employee);
        }
        return map;
    }

    @Override
    public Employee findById(int id) {
        Employee employee = iEmployeeRepository.findById(id);
        return employee;
    }

    @Override
    public Map<String, String> update(Employee employee) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
