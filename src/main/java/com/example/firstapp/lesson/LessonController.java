package com.example.firstapp.lesson;

import com.example.firstapp.lesson.model.Lesson;
import com.example.firstapp.student.StudentService;
import com.example.firstapp.teacher.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/lessons")
@RequiredArgsConstructor
public class LessonController {

    private final LessonService lessonService;
    private final StudentService studentService;
    private final TeacherService teacherService;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("lessons", lessonService.findAll());
        return "lessons/list";
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void deleteById(@PathVariable Long id) {
        lessonService.deleteById(id);
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("students", studentService.findAll());
        model.addAttribute("teachers", teacherService.findAll());
        return "lessons/register";
    }

    @PostMapping("/create")
    public String save(Lesson lesson, @RequestParam Long studentId, @RequestParam Long teacherId) {
        lessonService.save(lesson,studentId, teacherId);
        return "redirect:/lessons";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        Lesson lesson = lessonService.findById(id);
        model.addAttribute("lesson", lesson);
        model.addAttribute("students", studentService.findAll());
        model.addAttribute("teachers", teacherService.findAll());
        return "lessons/edit";
    }

    @PostMapping("/{id}/edit")
    public String update(@PathVariable Long id, Lesson lesson, @RequestParam Long studentId, @RequestParam Long teacherId) {
        lesson.setId(id);
        lessonService.save(lesson, studentId, teacherId);
        return "redirect:/lessons";
    }


}
