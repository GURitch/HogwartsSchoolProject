package ru.hogwarts.school.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.exception.StudentIsNotFound;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public Student addStudent(Student student) {
        logger.info("addStudent method invoked");
        return studentRepository.save(student);
    }

    @Override
    public Student findStudent(long studentId) {
        try {
            logger.info("findStudent method invoked");
            return studentRepository.findById(studentId).orElseThrow(StudentIsNotFound::new);
        } catch (StudentIsNotFound e) {
            logger.info("Студент не найден");

            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Student editStudent(Student student) {
        logger.info("editStudent method invoked");
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(long studentId){
        studentRepository.delete(findStudent(studentId));
        logger.info("deleteStudent method invoked");
    }

    @Override
    public Collection<Student> getAllStudents() {
        logger.info("getAllStudents method invoked");
        return studentRepository.findAll();
    }

    @Override
    public Collection<Student> getAllStudentsByAge(int age) {
        logger.info("getAllStudentsByAge method invoked");
        return studentRepository.findAllByAge(age);
    }

    @Override
    public Collection<Student> findByAgeBetween(int min, int max) {
        logger.info("findByAgeBetween method invoked");
        return studentRepository.findByAgeBetween(min,max);
    }

    @Override
    public Faculty getFacultyOfStudentById(long studentId){
        logger.info("getFacultyOfStudentById method invoked");
        return findStudent(studentId).getFaculty();
    }

    @Override
    public Integer getCountAllStudents() {
        logger.info("getCountAllStudents method invoked");
        return studentRepository.getCountAllStudents();
    }

    @Override
    public Double getAverageAgeStudents() {
        logger.info("getAverageAgeStudents method invoked");
        return studentRepository.getAvgAgeStudents();
    }

    @Override
    public List<Student> getLastFiveStudents() {
        logger.info("getLastFiveStudents method invoked");
        return studentRepository.getLastFiveStudents();
    }

    @Override
    public List<String> getStudentsStartWithA() {
        return studentRepository.findAll().stream()
                .map(Student::getName)
                .map(String::toUpperCase)
                .filter(e -> e.startsWith("A"))
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public Double getAverageAgeStudents2() {
        return studentRepository.findAll().stream()
                .mapToInt(Student::getAge)
                .average()
                .orElse(0.0);
    }

    @Override
    public void treadsPrintToConsole() {
        List<Student> studentList = studentRepository.findAll();

        System.out.println(studentList.get(0).getName());
        System.out.println(studentList.get(1).getName());

        new Thread(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(studentList.get(2).getName());
            System.out.println(studentList.get(3).getName());
        }).start();

        new Thread(() -> {
            System.out.println(studentList.get(4).getName());
            System.out.println(studentList.get(5).getName());
        }).start();
    }

    @Override
    public void synchronizedTreadsPrintToConsole() {
        List<Student> studentList = studentRepository.findAll();

        printToConsole(studentList.get(0));
        printToConsole(studentList.get(1));

        new Thread(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            printToConsole(studentList.get(2));
            printToConsole(studentList.get(3));
        }).start();

        new Thread(() -> {
            printToConsole(studentList.get(4));
            printToConsole(studentList.get(5));
        }).start();
    }

    private synchronized void printToConsole(Student student){
        System.out.println(student.getName());
    }

}
