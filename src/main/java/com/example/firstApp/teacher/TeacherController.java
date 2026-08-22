package com.example.firstApp.teacher;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("teachers", teacherService.findAll());
        return "teachers/list";
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id) {
        teacherService.deleteById(id);
        return "redirect:/teachers";
    }


}
