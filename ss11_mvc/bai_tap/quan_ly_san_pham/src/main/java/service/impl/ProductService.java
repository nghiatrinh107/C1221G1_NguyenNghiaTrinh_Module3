package service.impl;

import model.Product;
import repository.IProductRepository;
import repository.impl.ProductRepository;
import service.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    private IProductRepository iProductRepository = new ProductRepository();
    @Override
    public List<Product> getListProduct() {
        List<Product> productList = iProductRepository.getList();
        return productList;
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        Product product = iProductRepository.findById(id);
        return product;
    }

    @Override
    public void update(int id, Product product) {
        iProductRepository.update(id,product);
    }
}
