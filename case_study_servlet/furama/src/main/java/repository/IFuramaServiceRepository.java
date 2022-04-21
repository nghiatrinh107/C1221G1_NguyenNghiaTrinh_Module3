package repository;

import model.furama_service.FuramaService;

import java.util.List;

public interface IFuramaServiceRepository {

    List<FuramaService> getList();

    void save(FuramaService furamaService);
}
