package com.example.exercise13q2controller_layerrestcrud.BankManagementSystem;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {
    private String id;
    private String userName;
    private double Balance;

}
