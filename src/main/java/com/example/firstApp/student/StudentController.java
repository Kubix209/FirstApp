package com.example.firstApp.student;

import com.example.firstApp.common.Language;
import com.example.firstApp.student.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    //do wyciagania danych z bazy sluzy get

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "students/list";
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id) {
        studentService.deleteById(id);
        return "redirect:/students";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("languages", Language.values());
        return "students/register";
    }

    @PostMapping("/create")
    public String save(Student student) {
        studentService.save(student);
        return "redirect:/students";
    }

    @GetMapping("/{id}/edit}")
    public String editForm(@PathVariable id studenta i Model model) {
        musimy wczytac studenta po id z bazy
                dodac studenta do html
                dodac wszystkie jezyki do html bo moze chciec edytowac jezyk tak jak przy dodawniu
                i pozniej otworzyc formularz html
        return "students/register";
    }

    @PostMapping("/{id}/edit}")
    public String update(@PathVariable id studenta ktorego edytujesz i  Student student czyli jak ma wygladac po edycji) {
        student.setId(id);
        tu zapiszemy tego studenta
                poczytaj dlaczego musimy ustawic id i jak sie zachowac wtedty save()
        return "redirect:/students";
    }
}
