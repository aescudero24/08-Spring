package com.example.customer.product;
import com.example.customer.tag.Tag;
import com.example.customer.tag.TagService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/product")
public class ProductController {

    private final ProductService productService;
    private final TagService tagService;

    @Autowired
    public ProductController(ProductService productService, TagService tagService) {
        this.productService = productService;
        this.tagService = tagService;
    }

    @GetMapping
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @GetMapping(path = "{productId}")
    public Product productById(@PathVariable("productId") Long productId) {
        return productService.getProductById(productId);
    }

    @PostMapping
    public void registerNewProduct(@RequestBody Product product) {
        productService.addNewProduct(product);
    }

    @DeleteMapping(path = "{productId}")
    public void deleteProduct(@PathVariable("productId") Long productId) {
        productService.deleteProduct(productId);
    }

    @PutMapping(path = "{productId}")
    public void updateProduct(@PathVariable("productId") Long productId, @RequestParam(required = false) String product_name, @RequestParam(required = false) Integer price) {
        productService.updateProduct(productId, product_name, price);
    }

    @PutMapping(path = "{productId}/tag/{tagId}")
    Product addTagtoProduct(@PathVariable("productId") Long productId, @PathVariable("tagId") Long tagId) {
        Product product = productService.getProductById(productId);
        Tag tag = tagService.getTagById(tagId);

        product.addProduct_tag(tag);
        return productService.getProductById(productId);
    }
}
