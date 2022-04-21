package repository.impl.EmployeeRepository;


import model.employee.EducationDegree;
import repository.BaseRepository;
import repository.IEducationDegreeRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EducationDegreeRepository implements IEducationDegreeRepository {
    private BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<EducationDegree> getList() {
        List<EducationDegree> educationDegrees = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(
                    "select * from trinh_do;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer typeId = resultSet.getInt("ma_trinh_do");
                String nameType = resultSet.getString("ten_trinh_do");
                educationDegrees.add(new EducationDegree(typeId, nameType));
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
        return educationDegrees ;
    }
}
