package com.example.firstApp.student;

import com.example.firstApp.student.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    public void save(Student student) {
        studentRepository.save(student);
    }

    public Student findById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            return student.get();
        } else {
            throw new RuntimeException("Student not found");
        }
    }
}
