package com.medical.model;

import lombok.Getter;

@Getter
public enum SymptomCategory {
    HEAD("頭部", "頭、顔、目、耳、鼻、口など"),
    CHEST("胸部", "胸、心臓、肺など"),
    DIGESTIVE("消化器系", "口、食道、胃、腸、肝臓、胆のうなど"),
    ABDOMEN("腹部", "胃、腸、肝臓など"),
    LIMBS("四肢", "手、足、関節など"),
    SKIN("皮膚", "皮膚、爪など"),
    MENTAL("精神", "こころの症状"),
    GENERAL("全身", "発熱、倦怠感など");

    private final String name;
    private final String description;

    SymptomCategory(String name, String description) {
        this.name = name;
        this.description = description;
    }
} 