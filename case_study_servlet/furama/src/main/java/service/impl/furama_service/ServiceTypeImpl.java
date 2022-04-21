package service.impl.furama_service;

import model.furama_service.ServiceType;
import repository.IServiceTypeRepository;
import repository.impl.furama_service_repository.ServiceTypeRepository;
import service.IServiceType;

import java.util.ArrayList;
import java.util.List;

public class ServiceTypeImpl implements IServiceType {
    private IServiceTypeRepository iServiceTypeRepository= new ServiceTypeRepository();
    @Override
    public List<ServiceType> getServiceType() {
        List<ServiceType> serviceTypeList = iServiceTypeRepository.getList() ;
        return serviceTypeList;
    }
}
