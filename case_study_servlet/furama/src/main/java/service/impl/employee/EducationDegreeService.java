package service.impl.employee;

import model.employee.EducationDegree;


import repository.IEducationDegreeRepository;
import repository.impl.EmployeeRepository.EducationDegreeRepository;
import service.IEducationDegreeService;


import java.util.List;

public class EducationDegreeService implements IEducationDegreeService {
    private IEducationDegreeRepository iEducationDegreeRepository = new EducationDegreeRepository();
    @Override
    public List<EducationDegree> getEducationDegree() {
        List<EducationDegree> educationDegreeList = iEducationDegreeRepository.getList();
        return educationDegreeList;
    }
}
