package repository;

import model.User;

import java.util.List;

public interface ICrudRepository<E> {
    List<E> getList();

    void save(E e);
}
