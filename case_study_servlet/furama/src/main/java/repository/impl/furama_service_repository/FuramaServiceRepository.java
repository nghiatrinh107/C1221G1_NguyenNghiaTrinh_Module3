package repository.impl.furama_service_repository;

import model.customer.Customer;
import model.furama_service.FuramaService;
import repository.BaseRepository;
import repository.IFuramaServiceRepository;
import service.IFuramaService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuramaServiceRepository implements IFuramaServiceRepository {
    private BaseRepository baseRepository = new BaseRepository();


    @Override
    public List<FuramaService> getList() {
        List<FuramaService> furamaServiceList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(
                    "select *from dich_vu;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("ma_dich_vu");
                String serviceName = resultSet.getString("ten_dich_vu");
                Integer serviceArea = resultSet.getInt("dien_tich");
                Integer serviceCost = resultSet.getInt("chi_phi_thue");
                Integer serviceMaxPeople = resultSet.getInt("so_nguoi_toi_da");
                Integer rentType = resultSet.getInt("ma_kieu_thue");
                Integer serviceType = resultSet.getInt("ma_loai_dich_vu");
                String standardRoom = resultSet.getString("tieu_chuan_phong");
                String description = resultSet.getString("mo_ta_tien_nghi_khac");
                Integer poolArea = resultSet.getInt("dien_tich_ho_boi");
                Integer numberOfFloors = resultSet.getInt("so_tang");
                furamaServiceList.add(new FuramaService(id, serviceName,serviceArea,serviceCost,serviceMaxPeople,rentType,serviceType,standardRoom,description,poolArea,numberOfFloors));
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
        return furamaServiceList;
    }

    @Override
    public void save(FuramaService furamaService) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDB().
                    prepareStatement("insert into dich_vu(ten_dich_vu,dien_tich,chi_phi_thue,so_nguoi_toi_da,ma_kieu_thue,ma_loai_dich_vu,tieu_chuan_phong,mo_ta_tien_nghi_khac,dien_tich_ho_boi,so_tang) value (?,?,?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1, furamaService.getServiceName());
            preparedStatement.setInt(2, furamaService.getServiceArea());
            preparedStatement.setInt(3, furamaService.getServiceCost());
            preparedStatement.setInt(4, furamaService.getServiceMaxPeople());
            preparedStatement.setInt(5, furamaService.getRentType());
            preparedStatement.setInt(6, furamaService.getServiceType());
            preparedStatement.setString(7, furamaService.getStandardRoom());
            preparedStatement.setString(8, furamaService.getDescription());
            preparedStatement.setInt(9, furamaService.getPoolArea());
            preparedStatement.setInt(10, furamaService.getNumberOfFloors());
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

}
