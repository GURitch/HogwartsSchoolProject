package ru.hogwarts.school.service.impl;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

import java.util.Collection;
import java.util.HashMap;
@Service
public class FacultyServiceImpl implements FacultyService {
    private final HashMap<Long, Faculty> facultyHashMap;
    private long facultyId = 0;

    public FacultyServiceImpl() {
        this.facultyHashMap = new HashMap<>();
    }

    @Override
    public Faculty addFaculty(Faculty faculty) {
        faculty.setId(++facultyId);
        facultyHashMap.put(facultyId, faculty);
        return faculty;
    }

    @Override
    public Faculty findFaculty(Long facultyId) {
        return facultyHashMap.get(facultyId);
    }

    @Override
    public Faculty editFaculty(Long facultyId, Faculty faculty) {
        facultyHashMap.put(facultyId, faculty);
        return faculty;
    }

    @Override
    public Faculty deleteFaculty(Long facultyId) {
        return facultyHashMap.remove(facultyId);
    }

    @Override
    public Collection<Faculty> getAllFaculties() {
        return facultyHashMap.values();
    }
}
