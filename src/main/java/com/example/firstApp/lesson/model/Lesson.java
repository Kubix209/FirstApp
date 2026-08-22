package com.example.firstApp.lesson.model;

import com.example.firstApp.student.model.Student;
import com.example.firstApp.teacher.model.Teacher;
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
}
