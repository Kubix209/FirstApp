package com.example.firstapp.teacher;

import com.example.firstapp.teacher.model.Teacher;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    public void deleteById(Long id) {
        teacherRepository.deleteById(id);
    }

    public void save(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public Teacher findById(Long id) {
        return teacherRepository.findById(id).orElseThrow(() -> new RuntimeException("teacher with Id " + id + " not found"));
    }
}
