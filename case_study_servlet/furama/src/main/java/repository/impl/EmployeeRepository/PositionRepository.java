package repository.impl.EmployeeRepository;

import model.employee.Position;
import model.furama_service.RentType;
import repository.BaseRepository;
import repository.IPositionRepository;
import service.IPositionService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionRepository implements IPositionRepository {
    BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<Position> getList() {
        List<Position> positionList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(
                    "select * from vi_tri;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer typeId = resultSet.getInt("ma_vi_tri");
                String nameType = resultSet.getString("ten_vi_tri");
                positionList.add(new Position(typeId, nameType));
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
        return positionList ;
    }


}
