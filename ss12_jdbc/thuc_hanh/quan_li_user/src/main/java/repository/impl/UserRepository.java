package repository.impl;

import model.User;
import repository.BaseRepository;
import repository.IUserRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    private BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<User> getList() {
        List<User> userList = new ArrayList<>();
//        PreparedStatement preparedStatement = null;
        CallableStatement callableStatement = null;
//        try {
//            preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(
//                    " select id,`name`,email,country from `users`");
//            ResultSet resultSet = preparedStatement.executeQuery();
//            User user;
//            while (resultSet.next()) {
//                user = new User();
//                user.setId(resultSet.getInt("id"));
//                user.setName(resultSet.getString("name"));
//                user.setEmail(resultSet.getString("email"));
//                user.setCountry(resultSet.getString("country"));
//                userList.add(user);
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        } finally {
//            try {
//                preparedStatement.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
        try {
//            preparedStatement = this.baseRepository.getConn().prepareStatement(SELECT_ALL_USERS);
            callableStatement = this.baseRepository.getConnectionJavaToDB().prepareCall("call show_users");
            ResultSet resultSet = callableStatement.executeQuery();
            User user;
            while (resultSet.next()){
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setCountry(resultSet.getString("country"));
                userList.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                callableStatement.close();
//                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return userList;
    }

    @Override
    public void save(User user) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDB().
                    prepareStatement("insert into users(`name`,email,country) value (?,?,?)");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean update(User user) {
        boolean rowUpdated = false;
//        PreparedStatement preparedStatement = null;
//        try {
//            preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement("UPDATE users SET `name` = ?,email= ?, country =? WHERE id = ?;");
//            preparedStatement.setString(1, user.getName());
//            preparedStatement.setString(2, user.getEmail());
//            preparedStatement.setString(3, user.getCountry());
//            preparedStatement.setInt(4, user.getId());
//            rowUpdated = preparedStatement.executeUpdate() > 0;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                assert preparedStatement != null;
//                preparedStatement.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
        CallableStatement callableStatement = null;
        try {
            callableStatement = this.baseRepository.getConnectionJavaToDB().prepareCall("call edit_user(?,?,?,?)");
            callableStatement.setInt(1,user.getId());
            callableStatement.setString(2,user.getName());
            callableStatement.setString(3,user.getEmail());
            callableStatement.setString(4,user.getCountry());
            callableStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return rowUpdated;
    }

    @Override
    public boolean delete(int id) {
        boolean rowDeleted = false;

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement("DELETE FROM users WHERE id = ?;");
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
//            CallableStatement callableStatement = baseRepository.getConnectionJavaToDB()    .prepareCall("call delete_user(?)");
//            callableStatement.setInt(1, id);
//            rowDeleted = callableStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rowDeleted;

    }

    @Override
    public List<User> search(String country) {
        List<User> userList = new ArrayList<>();

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement("select id, `name`,email,country from users where country like ?;");
            preparedStatement.setString(1,"%"+country+"%");
            ResultSet resultSet = preparedStatement.executeQuery();

            User user;
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setCountry(resultSet.getString("country"));
                userList.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return userList;
    }


    @Override
    public User selectUser(int id) {
        User user = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement("SELECT id,`name`,email,country FROM users WHERE id =?;");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            String name;
            String email;
            String country;
            while (resultSet.next()) {
                name = resultSet.getString("name");
                email = resultSet.getString("email");
                country = resultSet.getString("country");
                user = new User(id, name, email, country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                assert preparedStatement != null;
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }


}
