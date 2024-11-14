package com.example.exercise13q1controller_layerrestcrud.Tracker_System;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Task {
    private String id;
    private String title;
    private String description;
    private String status;
}
