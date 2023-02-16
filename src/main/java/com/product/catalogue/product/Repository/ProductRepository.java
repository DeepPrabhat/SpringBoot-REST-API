package com.product.catalogue.product.Repository;

import com.product.catalogue.product.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product,Long> {
}
