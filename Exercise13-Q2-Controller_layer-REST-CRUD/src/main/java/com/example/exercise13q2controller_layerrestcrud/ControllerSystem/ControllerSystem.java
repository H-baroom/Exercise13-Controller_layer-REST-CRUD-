package com.example.exercise13q2controller_layerrestcrud.ControllerSystem;

import com.example.exercise13q2controller_layerrestcrud.ApiResponse.ApiResponse;
import com.example.exercise13q2controller_layerrestcrud.BankManagementSystem.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/Bank")
public class ControllerSystem {
    ArrayList<Customer> customers = new ArrayList();

    @GetMapping("/displayAllCustomer")
    public ArrayList<Customer> getCustomers() {
        return customers;
    }
    @PostMapping("/add")
    public ApiResponse addCustomer(@RequestBody Customer customer) {
        customers.add(customer);
        return new ApiResponse( "Customer added successfully");
    }

    @PutMapping("/update/{index}")
    public ApiResponse updateCustomer(@RequestBody Customer customer,@PathVariable int index) {
        customers.set(index, customer);
        return new ApiResponse("Customer updated successfully");
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteCustomer( @PathVariable int index) {
        customers.remove(index);
        return new ApiResponse("Customer deleted successfully");
    }

    @PutMapping("/Deposit/{id}/{amount}")
    public ApiResponse Deposit(@PathVariable String id,@PathVariable int amount) {
        for (Customer c : customers) {
            if (c.getId().equals(id)) {
                c.setBalance(c.getBalance() + amount);
                return new ApiResponse("Customer Deposit successfully");
            }
        }
        return new ApiResponse("customer not found");
    }

    @PutMapping("/Withdraw/{id}/{amount}")
    public ApiResponse Withdraw(@PathVariable String id,@PathVariable int amount){
        for (Customer c : customers) {
            if(c.getId().equals(id)) {
                if(c.getBalance() >= amount) {
                    c.setBalance(c.getBalance() - amount);
                    return new ApiResponse("Customer Withdraw successfully");
                }else {
                    return new ApiResponse( "Customer balance not enough");
                }
            }else {
                return new ApiResponse( "customer not found");
            }
        }
        return new ApiResponse( "Customer balance not enough");
    }
}
