package com.medical.model;

import lombok.Getter;

@Getter
public enum BodyPart {
    HEAD("頭"),
    FACE("顔"),
    EYE("目"),
    EAR("耳"),
    NOSE("鼻"),
    MOUTH("口"),
    THROAT("のど"),
    NECK("首"),
    CHEST("胸"),
    HEART("心臓"),
    LUNG("肺"),
    STOMACH("胃"),
    INTESTINE("腸"),
    LIVER("肝臓"),
    BACK("背中"),
    ARM("腕"),
    HAND("手"),
    LEG("足"),
    JOINT("関節"),
    SKIN("皮膚"),
    WHOLE_BODY("全身");

    private final String name;

    BodyPart(String name) {
        this.name = name;
    }
} 