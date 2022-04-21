package service.impl.furama_service;

import model.customer.Customer;
import model.furama_service.FuramaService;
import repository.IFuramaServiceRepository;
import repository.impl.furama_service_repository.FuramaServiceRepository;
import service.IFuramaServiceService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FuramaServiceImpl implements IFuramaServiceService{
   private IFuramaServiceRepository iFuramaServiceRepository =new FuramaServiceRepository();

    @Override
    public List<FuramaService> getList() {
        List<FuramaService> furamaServiceList = iFuramaServiceRepository.getList();
        return furamaServiceList ;
    }

    @Override
    public Map<String, String> save(FuramaService furamaService) {
        Map<String, String> map = new HashMap<>();
        if (furamaService.getServiceName().equals("")) {
            map.put("name", "Not Null");
        } else if (!furamaService.getServiceName().matches("^[a-zA-Z ]+$")) {
            map.put("name", "Invalid name");
        }

        if (map.isEmpty()) {
            iFuramaServiceRepository.save(furamaService);
        }
        return map;
    }

}
