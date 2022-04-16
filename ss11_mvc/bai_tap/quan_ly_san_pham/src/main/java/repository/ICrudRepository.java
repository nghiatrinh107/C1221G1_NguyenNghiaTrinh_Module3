package repository;

import model.Product;

import java.util.List;

public interface ICrudRepository<E> {
    List<E> getList();

    void save(E e);

    Product findById(int id);

    void update(int id, E e);

    List<E> search(String name);

    void remove(int id);
}
