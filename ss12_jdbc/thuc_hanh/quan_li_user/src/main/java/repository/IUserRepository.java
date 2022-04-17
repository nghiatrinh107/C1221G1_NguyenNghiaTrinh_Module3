package repository;

import model.User;

import java.util.List;

public interface IUserRepository extends ICrudRepository<User> {
    @Override
    List<User> getList();

    @Override
    void save(User user);

    @Override
    boolean update(User user);
}
