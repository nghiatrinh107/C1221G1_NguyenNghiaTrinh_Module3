package service;

import model.customer.Customer;

import java.util.List;
import java.util.Map;

public interface IFuramaService<E> {
    List<E> getList();

    Map<String, String> save(E e);

    E findById(int id);
}
