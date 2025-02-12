package com.medical.model;

import lombok.Data;

@Data
public class Symptom {
    private String id;
    private String name;
    private String description;
    private String recommendedDepartment;
} 