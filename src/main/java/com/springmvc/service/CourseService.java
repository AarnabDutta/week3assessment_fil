package com.springmvc.service;

import com.springmvc.model.Course;
import com.springmvc.model.Faculty;
import com.springmvc.repository.CourseRepository;
import com.springmvc.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private FacultyRepository facultyRepository;

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public void assignCourseToFaculty(Long facultyId, Long courseId) {
        Optional<Faculty> faculty = facultyRepository.findById(facultyId);
        Optional<Course> course = courseRepository.findById(courseId);

        if (faculty.isPresent() && course.isPresent()) {
            faculty.get().getCourses().add(course.get());
            facultyRepository.save(faculty.get());
        }
    }
}
