package com.example.customer.product;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new IllegalStateException("No Such Product With Id of " + productId + " Exists"));
    }

    @PostMapping
    public void addNewProduct(Product product) {
        Optional<Product> productOptional = productRepository.findProductByName(product.getProduct_name());
        if (productOptional.isPresent()) {
            throw new IllegalStateException("Product Already Exists");
        }
        productRepository.save(product);
    }

    public void deleteProduct(Long productId) {
        boolean exists = productRepository.existsById(productId);
        if (!exists) {
            throw new IllegalStateException(
                    "No Such Product With Id of " + productId + " Exists"
            );
        }
        productRepository.deleteById(productId);
    }

    @Transactional
    public void updateProduct(Long productId, String product_name, Integer price) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalStateException("No Such Product With Id of " + productId + " Exists"));
        if (product_name != null && !product_name.isEmpty() && !Objects.equals(product.getProduct_name(), product_name)) {
            product.setProduct_name(product_name);
        }
        if (price != null && !Objects.equals(product.getPrice(), price)) {
            product.setPrice(price);
        }
    }
}