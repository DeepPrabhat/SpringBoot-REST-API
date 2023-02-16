package com.product.catalogue.product.Controller;

import com.product.catalogue.product.Model.Product;
import com.product.catalogue.product.Services.ProductService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.image.ReplicateScaleFilter;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    private ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok().body(this.productService.getProduct());
    }

    @GetMapping("/products/{prdktId}")
    private Product getProductById(@PathVariable long prdktId) {
        return this.productService.getProductById(prdktId);
    }

    @PostMapping("/newproducts")
    private ResponseEntity<Product> saveProduct(@RequestBody Product prdkt){
        return ResponseEntity.ok().body(this.productService.createProduct(prdkt));
    }

    @PutMapping("/products/{prdktId}")
    private ResponseEntity<Product> updateProduct(@PathVariable long prdktId,@RequestBody Product product){
        product.setProductId(prdktId);
        return ResponseEntity.ok().body(this.productService.updateProduct(product));
    }

    @DeleteMapping("/delete/{prdktId}")
    private HttpStatus deleteProduct(@PathVariable long prdktId){
        this.productService.deleteProductById(prdktId);
        return HttpStatus.OK;
    }




}
