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

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        Student student = studentService.findById(id);
        model.addAttribute("student", student);
        model.addAttribute("languages", Language.values());
        return "students/edit";
    }

    @PostMapping("/{id}/edit")
    public String update(@PathVariable Long id, Student student) {
        student.setId(id);
        studentService.save(student);
        return "redirect:/students";
    }
    //tutaj setId jest dlatego, ze z formularza html dostajemy info imie nazwisko i jezyk
    // i data binding to łaczy a setId to taka dodatkowa informacja, ktora mowi ze to wszystko sie dzieje dla juz istniejacego studenta
    // z pathvariable bo bez setId databinding by zrobil obiekt javowy z id null i wtedy by ten save mogl by byc zrozumiany inaczej
    // traktowany jako nowy a tak nie jest traktowany jako nowy tylko te dane trafiaja/ updatuja sie do juz istniejacego obiektu
    // czyli w skrocie formularz - nowe dane
    // pathVariable info kogo edytujemy
    // setId jest łacznikiem tych informacji
    // save nadpisuje


}
