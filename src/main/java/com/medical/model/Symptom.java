package com.medical.model;

import lombok.Data;
import java.util.Set;

@Data
public class Symptom {
    private String id;
    private String name;
    private String description;
    private String recommendedDepartment;
    private SymptomCategory category;
    private Set<BodyPart> relatedBodyParts;
    private String severity;  // 重症度（軽度、中度、重度）
    private String urgency;   // 緊急度（低、中、高）
} 