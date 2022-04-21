package service.impl.employee;

import model.employee.Division;
import repository.IDivisionRepository;
import repository.impl.EmployeeRepository.DivisionRepository;
import service.IDivisionService;

import java.util.List;

public class DivisionService implements IDivisionService {
    private IDivisionRepository iDivisionRepository = new DivisionRepository();
    @Override
    public List<Division> getDivisionList() {
        List<Division> divisionList = iDivisionRepository.getList();
        return divisionList;
    }
}
