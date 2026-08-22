package com.example.firstApp.teacher;

import com.example.firstApp.teacher.model.Teacher;
import lombok.RequiredArgsConstructor;
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

}
