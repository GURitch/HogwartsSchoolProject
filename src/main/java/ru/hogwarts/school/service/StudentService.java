package ru.hogwarts.school.service;

import ru.hogwarts.school.controller.Student;

public interface StudentService {
    Student addStudent (Student student);
    Student findStudent (Long id);

}
