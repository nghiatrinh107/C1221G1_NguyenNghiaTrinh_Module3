package repository;

import model.customer.Customer;
import model.customer.CustomerType;

import java.util.List;
import java.util.Map;

public interface ICustomerRepository  extends ICrudRepository<Customer>{
    @Override
    List<Customer> getList();

    List<CustomerType> getTypeList();

    @Override
    void save(Customer customer);

    @Override
    Customer findById(int id);

    @Override
    void update(Customer customer);


    List<Customer> search(String name, String address, String typeId);
}
