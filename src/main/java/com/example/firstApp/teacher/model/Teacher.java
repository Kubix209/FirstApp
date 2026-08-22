package com.example.firstApp.teacher.model;

import com.example.firstApp.common.Language;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<Language> language;

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
