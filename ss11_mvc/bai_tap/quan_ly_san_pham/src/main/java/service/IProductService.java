package service;

import model.Product;

import java.util.List;

public interface IProductService {

    List<Product> getListProduct();

    void save(Product product);

    Product findById(int id);

    void update(int id, Product product);

    List<Product> search(String name);

    void delete(int id);
}
