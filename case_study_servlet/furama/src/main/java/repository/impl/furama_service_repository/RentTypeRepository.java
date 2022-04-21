package repository.impl.furama_service_repository;


import model.furama_service.RentType;
import repository.BaseRepository;
import repository.IRentTypeRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentTypeRepository implements IRentTypeRepository {
    BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<RentType> getRentTypeList() {
        List<RentType> rentTypeList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(
                    "select * from kieu_thue;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer typeId = resultSet.getInt("ma_kieu_thue");
                String nameType = resultSet.getString("ten_kieu_thue");
                rentTypeList .add(new RentType(typeId, nameType));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rentTypeList ;
    }
}
