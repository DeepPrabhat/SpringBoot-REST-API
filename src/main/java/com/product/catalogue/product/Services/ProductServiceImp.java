package com.product.catalogue.product.Services;

import com.product.catalogue.product.Exception.ProductException;
import com.product.catalogue.product.Model.Product;
import com.product.catalogue.product.Repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImp implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product prdkt) {
        return productRepository.save(prdkt);
    }

    @Override
    public Product updateProduct(Product prdkt) {
        Optional<Product> productObj=this.productRepository.findById(prdkt.getProductId());
        if(productObj.isPresent()) {
            Product productUpdate = productObj.get();
            productUpdate.setProductId(prdkt.getProductId());
            productUpdate.setProductName(prdkt.getProductName());
            productUpdate.setPrice(prdkt.getPrice());
            return this.productRepository.save(productUpdate);
        }
        else {
            throw new ProductException("No product found with"+prdkt.getProductId());
        }
    }

    @Override
    public List<Product> getProduct() {
        return this.productRepository.findAll();
    }

    @Override
    public Product getProductById(long productId) {
        Optional<Product> productObj=this.productRepository.findById(productId);
        if(productObj.isPresent())
        {
            return productObj.get();
        }
        else {
            throw new ProductException("Product not found with "+productId);
        }
    }
    @Override
    public void deleteProductById(long productId) {
        Optional<Product> productObj=this.productRepository.findById(productId);
        if(productObj.isPresent())
        {
            productRepository.delete(getProductById(productId));
        }
        else {
            throw new ProductException("Product not found with "+productId);
        }
    }
}
