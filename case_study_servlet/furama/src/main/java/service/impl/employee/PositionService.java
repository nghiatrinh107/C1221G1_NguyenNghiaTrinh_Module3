package service.impl.employee;

import model.employee.Position;
import repository.IPositionRepository;
import repository.impl.EmployeeRepository.PositionRepository;
import service.IPositionService;

import java.util.List;

public class PositionService implements IPositionService {
    private IPositionRepository iPositionRepository = new PositionRepository();
    @Override
    public List<Position> getPosition() {
        List<Position> positionList = iPositionRepository.getList();
        return positionList;
    }
}
