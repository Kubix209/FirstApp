package com.example.firstapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstAppApplication.class, args);
	}

}

/*




PRZEGLĄDARKA → HTTP GET /students

        ↓
   CONTROLLER        ← Odbiera żądanie, decyduje co zrobić

        ↓ wywołuje

     SERVICE          ← Logika biznesowa (walidacje)

        ↓ wywołuje

   REPOSITORY         ← Dostęp do danych (baza / lista)



MODEL - klasa reprezentujaca obiekt biznesowy
np. User, Language, Student, Teacher itd





 */
