package com.example.firstApp.student.model;

import com.example.firstApp.common.Language;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Language language;

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }


}
