package service;

import model.employee.Employee;

import java.util.List;
import java.util.Map;

public interface IEmployeeService  extends IFuramaService<Employee>{
    @Override
    List<Employee> getList();

    @Override
    Map<String, String> save(Employee employee);

    @Override
    Employee findById(int id);

    @Override
    Map<String, String> update(Employee employee);
}
