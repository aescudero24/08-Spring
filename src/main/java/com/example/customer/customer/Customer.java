package com.example.customer.customer;

import com.example.customer.order.Order;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Customer {
    @Id
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_sequence"
    )
    private Long id;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private Set<Order> orders = new HashSet<>();
    private String customer_name;
    private String phone;
    private LocalDate dob;
    @Transient
    private Integer age;

    public Customer() {
    }

    public Customer(Long id, String customer_name, String phone, LocalDate dob) {
        this.id = id;
        this.customer_name = customer_name;
        this.phone = phone;
        this.dob = dob;
    }

    public Customer(String customer_name, String phone, LocalDate dob) {
        this.customer_name = customer_name;
        this.phone = phone;
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + customer_name + '\'' +
                ", email='" + phone + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
