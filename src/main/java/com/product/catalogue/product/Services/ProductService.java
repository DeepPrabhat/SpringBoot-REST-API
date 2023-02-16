package com.product.catalogue.product.Services;

import com.product.catalogue.product.Model.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product prdkt);
    Product updateProduct(Product prdkt);
    List<Product> getProduct();
    Product getProductById(long productId);
    void deleteProductById(long productId);
}
