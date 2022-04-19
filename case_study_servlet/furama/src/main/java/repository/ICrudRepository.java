package repository;

import model.customer.Customer;

import java.util.List;

public interface ICrudRepository<E> {
    List<E> getList();

    void save(E e);

    E findById(int id);
}
