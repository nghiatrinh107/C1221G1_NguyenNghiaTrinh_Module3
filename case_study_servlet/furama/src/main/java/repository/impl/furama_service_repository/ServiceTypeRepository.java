package repository.impl.furama_service_repository;

import model.furama_service.RentType;
import model.furama_service.ServiceType;
import repository.BaseRepository;
import repository.IServiceTypeRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceTypeRepository implements IServiceTypeRepository {
    BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<ServiceType> getList() {
        List<ServiceType> serviceTypeList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(
                    "select * from loai_dich_vu;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer typeId = resultSet.getInt("ma_loai_dich_vu");
                String nameType = resultSet.getString("ten_loai_dich_vu");
                serviceTypeList .add(new ServiceType(typeId, nameType));
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
        return serviceTypeList ;
    }
}
