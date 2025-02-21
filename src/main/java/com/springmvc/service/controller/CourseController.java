package com.springmvc.controller;

import com.springmvc.model.Course;
import com.springmvc.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/add")
    public String addCourse(@RequestBody Course course) {
        courseService.addCourse(course);
        return "Course added successfully!";
    }

    @GetMapping("/all")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @PostMapping("/assign")
    public String assignCourse(@RequestParam Long facultyId, @RequestParam Long courseId) {
        courseService.assignCourseToFaculty(facultyId, courseId);
        return "Course assigned to faculty successfully!";
    }
}
