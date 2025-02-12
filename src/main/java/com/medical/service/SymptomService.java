package com.medical.service;

import com.medical.model.Symptom;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SymptomService {
    private Map<String, Symptom> symptoms = new HashMap<>();

    @PostConstruct
    public void init() {
        // 一般的な症状とそれに対応する診療科のサンプルデータ
        addSymptom("1", "発熱", "38度以上の熱がある", "内科");
        addSymptom("2", "頭痛", "継続的な頭痛がある", "脳神経外科/内科");
        addSymptom("3", "腹痛", "お腹に痛みがある", "消化器内科");
        addSymptom("4", "関節の痛み", "関節に痛みや腫れがある", "整形外科");
        addSymptom("5", "皮膚の発疹", "皮膚に発疹や痒みがある", "皮膚科");
        addSymptom("6", "目の痛み・かすみ", "目に違和感や視界がぼやける", "眼科");
        addSymptom("7", "歯痛", "歯や歯茎の痛み", "歯科");
        addSymptom("8", "耳鳴り・めまい", "耳鳴りやめまいがする", "耳鼻咽喉科");
    }

    private void addSymptom(String id, String name, String description, String department) {
        Symptom symptom = new Symptom();
        symptom.setId(id);
        symptom.setName(name);
        symptom.setDescription(description);
        symptom.setRecommendedDepartment(department);
        symptoms.put(id, symptom);
    }

    public List<Symptom> getAllSymptoms() {
        return new ArrayList<>(symptoms.values());
    }

    public Symptom getSymptomById(String id) {
        return symptoms.get(id);
    }
} 