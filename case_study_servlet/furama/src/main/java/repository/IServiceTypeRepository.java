package repository;

import model.furama_service.ServiceType;

import java.util.List;

public interface IServiceTypeRepository {
    List<ServiceType> getList();
}
