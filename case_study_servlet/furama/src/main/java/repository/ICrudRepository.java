package repository;

import model.customer.Customer;

import java.util.List;
import java.util.Map;

public interface ICrudRepository<E> {
    List<E> getList();

    void save(E e);

    E findById(int id);

    void update(E e);

    boolean delete(Integer id);
}
