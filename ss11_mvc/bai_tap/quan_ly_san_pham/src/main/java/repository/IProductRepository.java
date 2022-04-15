package repository;

import model.Product;

import java.util.List;

public interface IProductRepository extends ICrudRepository<Product> {
    @Override
    List<Product> getList();

    @Override
    void save(Product product);

    @Override
    void update(int id, Product product);
}
