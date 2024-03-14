package com.example.customer.tag;
import com.example.customer.product.Product;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Tag {
    @Id
    @SequenceGenerator(
            name = "tag_sequence",
            sequenceName = "tag_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "tag_sequence"
    )
    private Long id;

    @ManyToMany(mappedBy = "product_tags")
    private Set<Product> products = new HashSet<>();
    private String tag_name;

    public Tag() {
    }

    public Tag(Long id, String tag_name) {
        this.id = id;
        this.tag_name = tag_name;
    }

    public Tag(String tag_name) {
        this.tag_name = tag_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTag_name() {
        return tag_name;
    }

    public void setTag_name(String tag_name) {
        this.tag_name = tag_name;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", tag_name='" + tag_name + '\'' +
                '}';
    }
}
