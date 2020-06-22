package product.service;

import product.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService {
    private static Map<Integer, Product> productMap;

    static {
        productMap = new HashMap<>();
        productMap.put(1, new Product(1, "Nokia 1280", "Ném chó, chó chết", 180000));
        productMap.put(2, new Product(2, "Nokia X2", "Con nhà giàu", 1500000));
        productMap.put(3, new Product(3, "Nokia c2", "Mấy đứa có tiền ms dùng", 2500000));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getProductId(), product);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id, product);
    }

    @Override
    public void delete(int id) {
        productMap.remove(id);
    }
}
