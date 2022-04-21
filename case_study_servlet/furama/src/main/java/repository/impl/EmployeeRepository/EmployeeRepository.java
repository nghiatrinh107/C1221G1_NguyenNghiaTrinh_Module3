package repository.impl.EmployeeRepository;

import model.customer.Customer;
import model.employee.Employee;
import repository.BaseRepository;
import repository.IEmployeeRepository;
import service.IEmployeeService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    private BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<Employee> getList() {
        List<Employee> employeeList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(
                    "select * from nhan_vien;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer employeeId = resultSet.getInt("ma_nhan_vien");
                String employeeName= resultSet.getString("ho_ten");
                String employeeBirthday= resultSet.getString("ngay_sinh");
                String employeeIdCard= resultSet.getString("so_cmnd");
                Integer salary= resultSet.getInt("luong");
                String phone= resultSet.getString("so_dien_thoai");
                String email= resultSet.getString("email");
                String address= resultSet.getString("dia_chi");
                Integer position= resultSet.getInt("ma_vi_tri");
                Integer educationDegree= resultSet.getInt("ma_trinh_do");
                Integer division= resultSet.getInt("ma_bo_phan");
                employeeList.add(new Employee(employeeId,employeeName,employeeBirthday,employeeIdCard,salary,phone,email,address,position,educationDegree,division));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return employeeList;

    }

    @Override
    public void save(Employee employee) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDB().
                    prepareStatement("insert into nhan_vien(ho_ten,ngay_sinh,so_cmnd,luong,so_dien_thoai,email,dia_chi,ma_vi_tri,ma_trinh_do,ma_bo_phan) value (?,?,?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1,employee.getEmployeeName());
            preparedStatement.setString(2,employee.getEmployeeBirthday() );
            preparedStatement.setString(3, employee.getEmployeeIdCard());
            preparedStatement.setInt(4,employee.getSalary() );
            preparedStatement.setString(5,employee.getPhone() );
            preparedStatement.setString(6,employee.getEmail());
            preparedStatement.setString(7,employee.getAddress() );
            preparedStatement.setInt(8,employee.getPosition());
            preparedStatement.setInt(9,employee.getEducationDegree());
            preparedStatement.setInt(10,employee.getDivision());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Employee findById(int id) {
        Employee employee = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement
                    ("SELECT * FROM nhan_vien WHERE ma_nhan_vien =?;");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer employeeId = resultSet.getInt("ma_nhan_vien");
                String employeeName= resultSet.getString("ho_ten");
                String employeeBirthday= resultSet.getString("ngay_sinh");
                String employeeIdCard= resultSet.getString("so_cmnd");
                Integer salary= resultSet.getInt("luong");
                String phone= resultSet.getString("so_dien_thoai");
                String email= resultSet.getString("email");
                String address= resultSet.getString("dia_chi");
                Integer position= resultSet.getInt("ma_vi_tri");
                Integer educationDegree= resultSet.getInt("ma_trinh_do");
                Integer division= resultSet.getInt("ma_bo_phan");

                employee = new Employee(employeeId,employeeName,employeeBirthday,employeeIdCard,salary,phone,email,address,position,educationDegree,division);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                assert preparedStatement != null;
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return employee;

    }

    @Override
    public void update(Employee employee) {

    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
