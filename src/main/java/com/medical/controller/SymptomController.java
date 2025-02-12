package com.medical.controller;

import com.medical.model.Symptom;
import com.medical.model.SymptomCategory;
import com.medical.model.BodyPart;
import com.medical.service.SymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SymptomController {

    @Autowired
    private SymptomService symptomService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("symptoms", symptomService.getAllSymptoms());
        model.addAttribute("categories", symptomService.getAllCategories());
        model.addAttribute("bodyParts", symptomService.getAllBodyParts());
        return "index";
    }

    @GetMapping("/symptom/{id}")
    public String getSymptom(@PathVariable String id, Model model) {
        Symptom symptom = symptomService.getSymptomById(id);
        model.addAttribute("symptom", symptom);
        return "symptom";
    }

    @GetMapping("/category/{category}")
    public String getSymptomsByCategory(@PathVariable SymptomCategory category, Model model) {
        model.addAttribute("symptoms", symptomService.getSymptomsByCategory(category));
        model.addAttribute("categories", symptomService.getAllCategories());
        model.addAttribute("bodyParts", symptomService.getAllBodyParts());
        model.addAttribute("selectedCategory", category);
        return "index";
    }

    @GetMapping("/bodypart/{bodyPart}")
    public String getSymptomsByBodyPart(@PathVariable BodyPart bodyPart, Model model) {
        model.addAttribute("symptoms", symptomService.getSymptomsByBodyPart(bodyPart));
        model.addAttribute("categories", symptomService.getAllCategories());
        model.addAttribute("bodyParts", symptomService.getAllBodyParts());
        model.addAttribute("selectedBodyPart", bodyPart);
        return "index";
    }
} 