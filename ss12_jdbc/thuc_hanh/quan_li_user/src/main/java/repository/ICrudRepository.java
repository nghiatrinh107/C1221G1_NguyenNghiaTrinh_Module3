package repository;

import model.User;

import java.util.List;

public interface ICrudRepository<E> {
    List<E> getList();

    void save(E e);


    User selectUser(int id);


    boolean update (E e);;

    boolean delete(int id);
}
