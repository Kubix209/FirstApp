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

    public  List<Teacher> getAll() {
        return teacherRepository.findAll();
    }
}
