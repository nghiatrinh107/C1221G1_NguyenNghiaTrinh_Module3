package service.impl;

import model.User;
import repository.IUserRepository;
import repository.impl.UserRepository;
import service.IUserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements IUserService {
    private IUserRepository iUserRepository = new UserRepository();

    @Override
    public List<User> getListUser() {
        List<User> userList = iUserRepository.getList();
        return userList;
    }

    @Override
    public Map<String, String> save(User user) {
        Map<String, String> map = new HashMap<>();
        if (user.getName().equals("")) {
            map.put("name", "Not Null");
        } else if (!user.getName().matches("^[a-zA-Z ]+$")) {
            map.put("name", "Invalid name");
        }

        if (map.isEmpty()) {
            iUserRepository.save(user);
        }
        return map;
    }

    @Override
    public User selectUser(int id) {
        User user =iUserRepository.selectUser(id);
        return user;
    }

    @Override
    public void update(User user) {
        iUserRepository.update(user);
    }

    @Override
    public void delete(int id) {
        iUserRepository.delete(id);
    }


}
