package service;

import model.User;

import java.util.List;
import java.util.Map;

public interface IUserService {

    List<User> getListUser();


    Map<String, String> save(User user);

    User selectUser(int id);


    void update( User user);

    void delete(int id);
}
