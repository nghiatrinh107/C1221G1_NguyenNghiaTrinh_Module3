package repository;

import model.employee.Employee;

import java.util.List;

public interface IEmployeeRepository  extends ICrudRepository<Employee> {
    @Override
    List<Employee> getList();

    @Override
    void save(Employee employee);

    @Override
    Employee findById(int id);

    @Override
    void update(Employee employee);
}
