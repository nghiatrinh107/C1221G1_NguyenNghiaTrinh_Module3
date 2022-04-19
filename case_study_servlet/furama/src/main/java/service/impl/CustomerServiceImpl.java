package service.impl;

import model.customer.Customer;
import model.customer.CustomerType;
import repository.ICustomerRepository;
import repository.impl.CustomerRepository;
import service.ICustomerService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl  implements ICustomerService {
private ICustomerRepository iCustomerRepository = new CustomerRepository();
    @Override
    public List<Customer> getList() {
        List<Customer> customerList = iCustomerRepository.getList();
        return customerList ;
    }

    @Override
    public Map<String, String> save(Customer customer) {
        Map<String, String> map = new HashMap<>();
        if (customer.getCustomerName().equals("")) {
            map.put("name", "Not Null");
        } else if (!customer.getCustomerName().matches("^[a-zA-Z ]+$")) {
            map.put("name", "Invalid name");
        }

        if (map.isEmpty()) {
            iCustomerRepository.save(customer);
        }
        return map;
    }

    @Override
    public List<CustomerType> getTypeList() {
        List<CustomerType> customerTypeList = iCustomerRepository.getTypeList();
        return customerTypeList;
    }

    @Override
    public Customer findById(int id) {
        Customer customer =iCustomerRepository.findById(id);
        return customer;
    }
}
