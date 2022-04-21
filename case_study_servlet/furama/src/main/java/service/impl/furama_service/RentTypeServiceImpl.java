package service.impl.furama_service;

import model.furama_service.RentType;
import repository.IRentTypeRepository;
import repository.impl.furama_service_repository.RentTypeRepository;
import service.IRentTypeService;

import java.util.List;

public class RentTypeServiceImpl implements IRentTypeService {
    IRentTypeRepository iRentTypeRepository =new RentTypeRepository();
    @Override
    public List<RentType> getRentType() {
        List<RentType> rentTypeList = iRentTypeRepository.getRentTypeList();
        return rentTypeList;
    }
}
