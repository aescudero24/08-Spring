package com.example.customer.product;
import com.example.customer.tag.Tag;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Product {
    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "product_tags",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> product_tags = new HashSet<>();
    private String product_name;
    private Integer price;

    public Product() {
    }

    public Product(Long id, String product_name, Integer price) {
        this.id = id;
        this.product_name = product_name;
        this.price = price;
    }

    public Product(String product_name, Integer price) {
        this.product_name = product_name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Tag> getProduct_tags() {
        return product_tags;
    }

    public void addProduct_tag(Tag tag) {
        product_tags.add(tag);
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", product_tags=" + product_tags +
                ", product_name='" + product_name + '\'' +
                ", price=" + price +
                '}';
    }
}
