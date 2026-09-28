package com.example.week10.controller;

import com.example.week10.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final List<Product> products = new ArrayList<>();

    public ProductController() {
        products.add(new Product(1, "Laptop", 55000));
        products.add(new Product(2, "Mobile", 25000));
    }

    // GET - Get all products
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(products);
    }

    // GET - Get product by ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {

        for (Product product : products) {
            if (product.getId() == id) {
                return ResponseEntity.ok(product);
            }
        }

        return ResponseEntity.notFound().build();
    }

    // POST - Add product
    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {

        products.add(product);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(product);
    }

    // PUT - Update product
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable int id,
            @RequestBody Product updatedProduct) {

        for (Product product : products) {

            if (product.getId() == id) {

                product.setName(updatedProduct.getName());
                product.setPrice(updatedProduct.getPrice());

                return ResponseEntity.ok(product);
            }
        }

        return ResponseEntity.notFound().build();
    }

    // DELETE - Delete product
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {

        boolean removed =
                products.removeIf(product -> product.getId() == id);

        if (removed) {
            return ResponseEntity.ok("Product deleted successfully");
        }

        return ResponseEntity.notFound().build();
    }
}