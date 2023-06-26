package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Student;

import java.util.Collection;

public interface StudentService {
    Student addStudent (Student student);
    Student findStudent (Long id);
    Student editStudent (Long studentId, Student student);
    Student deleteStudent (Long id);
    Collection<Student> getAllStudents ();
    Collection<Student> getAllStudentsByAge (int age);

}
