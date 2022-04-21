package service;

import model.furama_service.FuramaService;

import java.util.List;
import java.util.Map;

public interface IFuramaServiceService {

    List<FuramaService> getList();


    Map<String, String> save(FuramaService furamaService);


}
