package repository.impl;

import model.customer.Customer;
import model.customer.CustomerType;
import repository.BaseRepository;
import repository.ICustomerRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private BaseRepository baseRepository = new BaseRepository();


    @Override
    public List<Customer> getList() {
        List<Customer> customerList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(
                    "select ma_khach_hang,ma_loai_khach,ho_ten,ngay_sinh,gioi_tinh,so_cmnd,so_dien_thoai,email,dia_chi from khach_hang;");
            ResultSet resultSet = preparedStatement.executeQuery();
//            Customer customer;
            while (resultSet.next()) {
//                customer = new Customer();
                Integer id = resultSet.getInt("ma_khach_hang");
                Integer idType = resultSet.getInt("ma_loai_khach");
                String name = resultSet.getString("ho_ten");
                String dob = resultSet.getString("ngay_sinh");
                Integer gender = resultSet.getInt("gioi_tinh");
                String customerIdCard = resultSet.getString("so_cmnd");
                String customerPhone = resultSet.getString("so_dien_thoai");
                String customerEmail = resultSet.getString("email");
                String customerAddress = resultSet.getString("dia_chi");
                customerList.add(new Customer(id, idType, name, dob, gender, customerIdCard, customerPhone, customerEmail, customerAddress));
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
        return customerList;
    }

    @Override
    public List<CustomerType> getTypeList() {
        List<CustomerType> customerTypeList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(
                    "select ma_loai_khach,ten_loai_khach from loai_khach;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer typeId = resultSet.getInt("ma_loai_khach");
                String nameType = resultSet.getString("ten_loai_khach");
                customerTypeList.add(new CustomerType(typeId, nameType));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return customerTypeList;
        }

    }


    @Override
    public void save(Customer customer) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDB().
                    prepareStatement("insert into khach_hang(ma_loai_khach,ho_ten,ngay_sinh,gioi_tinh,so_cmnd,so_dien_thoai,email,dia_chi) value (?,?,?,?,?,?,?,?)");
            preparedStatement.setInt(1, customer.getCustomerTypeId());
            preparedStatement.setString(2, customer.getCustomerName());
            preparedStatement.setString(3, customer.getCustomerBirthday());
            preparedStatement.setInt(4, customer.getCustomerGender());
            preparedStatement.setString(5, customer.getCustomerIdCard());
            preparedStatement.setString(6, customer.getCustomerPhone());
            preparedStatement.setString(7, customer.getCustomerEmail());
            preparedStatement.setString(8, customer.getCustomerAddress());
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
    public Customer findById(int id) {
        Customer customer = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement("SELECT ma_khach_hang,ma_loai_khach,ho_ten,ngay_sinh,gioi_tinh,so_cmnd,so_dien_thoai,email,dia_chi FROM users WHERE ma_khach_hang =?;");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer idType = resultSet.getInt("ma_loai_khach");
                String name = resultSet.getString("ho_ten");
                String dob = resultSet.getString("ngay_sinh");
                Integer gender = resultSet.getInt("gioi_tinh");
                String customerIdCard = resultSet.getString("so_cmnd");
                String customerPhone = resultSet.getString("so_dien_thoai");
                String customerEmail = resultSet.getString("email");
                String customerAddress = resultSet.getString("dia_chi");
                customer = new Customer(id, idType, name, dob, gender, customerIdCard, customerPhone, customerEmail, customerAddress);
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
        return customer;
    }
}
