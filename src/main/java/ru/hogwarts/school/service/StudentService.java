package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import java.util.Collection;

public interface StudentService {
    Student addStudent (Student student);
    Student findStudent (long id);
    Student editStudent (Student student);
    void deleteStudent (long id);
    Collection<Student> getAllStudents ();
    Collection<Student> getAllStudentsByAge (int age);
    Collection<Student> findByAgeBetween (int min, int max);
    Faculty getFacultyOfStudentById(long studentId);

}