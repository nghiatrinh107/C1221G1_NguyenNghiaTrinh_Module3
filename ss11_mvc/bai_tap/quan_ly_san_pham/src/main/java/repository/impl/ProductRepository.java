package repository.impl;

import model.Product;
import repository.IProductRepository;
import service.IProductService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository implements IProductRepository {
    private static Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1,new Product(1,"nước ngọt",10000,"coca","coca"));
        products.put(2,new Product(2,"kẹo",10000,"sữa","Bốn mùa"));
        products.put(3,new Product(3,"nước cam",10000,"Nhập khẩu","Pessi"));
        products.put(4,new Product(4,"bánh",10000,"kem","KemS"));
        products.put(5,new Product(5,"sữa",10000,"vị dâu","TH"));

    }

    @Override
    public List getList() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(),product);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }
}
