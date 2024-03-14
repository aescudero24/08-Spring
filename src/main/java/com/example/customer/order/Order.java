package com.example.customer.order;

import com.example.customer.customer.Customer;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_sequence"
    )
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "customer_id",
            referencedColumnName = "id"
    )
    private Customer customer;

    private LocalDate date_ordered;

    public Order() {
    }

    public Order(Long id, LocalDate date_ordered) {
        this.id = id;
        this.date_ordered = date_ordered;
    }

    public Order(LocalDate date_ordered) {
        this.date_ordered = date_ordered;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getDate_ordered() {
        return date_ordered;
    }

    public void setDate_ordered(LocalDate date_ordered) {
        this.date_ordered = date_ordered;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date_ordered=" + date_ordered +
                '}';
    }
}
