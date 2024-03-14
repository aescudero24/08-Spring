package com.example.customer.order;

import com.example.customer.customer.Customer;
import com.example.customer.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/order")
public class OrderController {

    private final OrderService orderService;
    private final CustomerService customerService;

    @Autowired
    public OrderController(OrderService orderService, CustomerService customerService) {
        this.orderService = orderService;
        this.customerService = customerService;
    }

    @GetMapping
    public List<Order> getOrders(){
        return orderService.getOrders();
    }

    @GetMapping(path = "{orderId}")
    public Order orderById(@PathVariable("orderId") Long orderId) {
        return orderService.getOrderById(orderId);
    }

    @PostMapping
    public void registerNewOrder(@RequestBody Order order) {
        orderService.addNewOrder(order);
    }

    @DeleteMapping(path = "{orderId}")
    public void deleteOrder(@PathVariable("orderId") Long orderId) {
        orderService.deleteOrder(orderId);
    }

    @PutMapping(path = "{orderId}/customer/{customerId}")
    Order addCustomerToOrder(@PathVariable("orderId") Long orderId, @PathVariable("customerId") Long customerId) {
        Order order = orderService.getOrderById(orderId);
        Customer customer = customerService.getCustomerById(customerId);
        order.setCustomer(customer);
        return orderService.getOrderById(orderId);
    }
}
