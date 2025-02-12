package com.medical.controller;

import com.medical.model.Symptom;
import com.medical.service.SymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SymptomController {

    @Autowired
    private SymptomService symptomService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("symptoms", symptomService.getAllSymptoms());
        return "index";
    }

    @GetMapping("/symptom/{id}")
    public String getSymptom(@PathVariable String id, Model model) {
        Symptom symptom = symptomService.getSymptomById(id);
        model.addAttribute("symptom", symptom);
        return "symptom";
    }
} 