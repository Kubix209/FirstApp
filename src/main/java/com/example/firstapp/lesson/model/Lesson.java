package com.example.firstapp.lesson.model;

import com.example.firstapp.student.model.Student;
import com.example.firstapp.teacher.model.Teacher;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Lesson {

    private long id;
    private Teacher teacher;
    private List<Student> students;
    private LocalDateTime dateTime;

    @Override
    public String toString() {
        return "Lesson id: " + id + "\n" +
                "Teacher: " + teacher + "\n" +
                "Students: " + students + "\n" +
                "Date: " + dateTime;
    }

    // rozwin tak samo jak student i teacher w sensie relacje
}
