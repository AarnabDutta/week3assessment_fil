package com.springmvc.service;

import com.springmvc.model.Faculty;
import com.springmvc.model.Course;
import com.springmvc.repository.FacultyRepository;
import com.springmvc.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private CourseRepository courseRepository;

    public void registerFaculty(Faculty faculty) {
        facultyRepository.save(faculty);
    }

    public Optional<Faculty> login(String email, String password) {
        Optional<Faculty> faculty = facultyRepository.findByEmail(email);
        return faculty.filter(f -> f.getPassword().equals(password));
    }

    public Set<Course> getAssignedCourses(Long facultyId) {
        return facultyRepository.findById(facultyId).map(Faculty::getCourses).orElse(Set.of());
    }
}
