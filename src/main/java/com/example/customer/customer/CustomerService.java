package com.example.customer.customer;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalStateException("No Such Customer With Id of " + customerId + " Exists"));
    }

    @PostMapping
    public void addNewCustomer(Customer customer) {
        Optional<Customer> customerOptional = customerRepository.findCustomerByPhone(customer.getPhone());
        if (customerOptional.isPresent()) {
            throw new IllegalStateException("Phone Number Already Taken");
        }
        customerRepository.save(customer);
    }

    public void deleteCustomer(Long customerId) {
        boolean exists = customerRepository.existsById(customerId);
        if (!exists) {
            throw new IllegalStateException(
                    "No Such Customer With Id of " + customerId + " Exists"
            );
        }
        customerRepository.deleteById(customerId);
    }

    @Transactional
    public void updateCustomer(Long customerId, String customer_name, String phone) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new IllegalStateException("No Such Customer With Id of " + customerId + " Exists"));
        if (customer_name != null && !customer_name.isEmpty() && !Objects.equals(customer.getCustomer_name(), customer_name)) {
            customer.setCustomer_name(customer_name);
        }
        if (phone != null && !phone.isEmpty() && !Objects.equals(customer.getPhone(), phone)) {
            Optional<Customer> customerOptional = customerRepository.findCustomerByPhone(phone);
            if (customerOptional.isPresent()) {
                throw new IllegalStateException("Phone Number Already Taken");
            }
            customer.setPhone(phone);
        }
    }
}
