package service;

import model.customer.Customer;
import model.customer.CustomerType;

import java.util.List;
import java.util.Map;

public interface ICustomerService extends IFuramaService<Customer> {
    @Override
    List<Customer> getList();

    List<CustomerType> getTypeList();

    @Override
    Customer findById(int id);

    @Override
    Map<String, String> save(Customer customer);
}
