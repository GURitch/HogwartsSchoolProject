package ru.hogwarts.school.service.impl;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Collectors;

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
    public Faculty findFaculty(long facultyId) {
        return facultyHashMap.get(facultyId);
    }

    @Override
    public Faculty editFaculty(Faculty faculty) {
        if (facultyHashMap.containsKey(faculty.getId())) {
            facultyHashMap.put(faculty.getId(), faculty);
            return faculty;
        }
        return null;
    }

    @Override
    public Faculty deleteFaculty(long facultyId) {
        return facultyHashMap.remove(facultyId);
    }

    @Override
    public Collection<Faculty> getAllFaculties() {
        return facultyHashMap.values();
    }

    @Override
    public Collection<Faculty> getAllFacultiesByColor(String color) {
        return facultyHashMap.values().stream()
                .filter(faculty -> faculty.getColor().equals(color))
                .collect(Collectors.toList());
    }
}
