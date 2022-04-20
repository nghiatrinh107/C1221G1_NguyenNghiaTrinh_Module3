package service;

import model.furama_service.FuramaService;

import java.util.List;
import java.util.Map;

public interface IFuramaServiceService extends IFuramaService<FuramaService>{
    @Override
    List<FuramaService> getList();

    @Override
    Map<String, String> save(FuramaService furamaService);

    @Override
    FuramaService findById(int id);

    @Override
    Map<String, String> update(FuramaService furamaService);
}
