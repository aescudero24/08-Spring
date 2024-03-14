package com.example.customer.description;

import jakarta.persistence.*;

@Entity
@Table
public class Description {
    @Id
    @SequenceGenerator(
            name = "description_sequence",
            sequenceName = "description_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "description_sequence"
    )
    private Long id;

    private String text;

    public Description() {
    }

    public Description(Long id, String text) {
        this.id = id;
        this.text = text;
    }

    public Description(String text) {
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Description{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
}
