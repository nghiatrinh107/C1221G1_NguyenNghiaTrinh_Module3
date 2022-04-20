package repository.impl.furama_service_repository;

import model.furama_service.FuramaService;
import repository.IFuramaServiceRepository;
import service.IFuramaService;

import java.util.List;

public class FuramaServiceRepository implements IFuramaServiceRepository {
    @Override
    public List<FuramaService> getList() {
        return null;
    }

    @Override
    public void save(FuramaService furamaService) {

    }

    @Override
    public FuramaService findById(int id) {
        return null;
    }

    @Override
    public void update(FuramaService furamaService) {

    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
