package ru.hogwarts.school.service.impl;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    private final HashMap<Long,Student> studentHashMap;
    private long lastId = 0;

    public StudentServiceImpl() {
        this.studentHashMap = new HashMap<>();
    }


    @Override
    public Collection<Student> getAllStudentsByAge(int age) {
        return studentHashMap.values().stream()
                .filter(student -> student.getAge() == age)
                .collect(Collectors.toList());
    }

    @Override
    public Student addStudent(Student student) {
        student.setId(++lastId);
        studentHashMap.put(lastId,student);
        return student;
    }

    @Override
    public Student findStudent(Long studentId) {
        if (studentHashMap.containsKey(studentId)) {
            return studentHashMap.get(studentId);
        }
        return null;
    }

    @Override
    public Student editStudent(Long studentId, Student student) {
        student.setId(studentId);
        studentHashMap.put(studentId, student);
        return student;
    }

    @Override
    public Student deleteStudent(Long studentId) {
        return studentHashMap.remove(studentId);
    }

    @Override
    public Collection<Student> getAllStudents() {
        return studentHashMap.values();
    }
}
