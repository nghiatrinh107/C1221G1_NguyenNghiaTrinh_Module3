package service;

import model.User;

import java.util.List;
import java.util.Map;

public interface IUserService {

    List<User> getListUser();


    Map<String, String> save(User user);
}
