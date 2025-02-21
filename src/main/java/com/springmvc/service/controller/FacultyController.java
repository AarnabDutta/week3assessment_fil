package com.springmvc.controller;

import com.springmvc.model.Faculty;
import com.springmvc.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @PostMapping("/register")
    public String registerFaculty(@RequestBody Faculty faculty) {
        facultyService.registerFaculty(faculty);
        return "Faculty registered successfully!";
    }

    @PostMapping("/login")
    public String loginFaculty(@RequestParam String email, @RequestParam String password) {
        Optional<Faculty> faculty = facultyService.login(email, password);
        return faculty.isPresent() ? "Login successful!" : "Invalid credentials!";
    }

    @GetMapping("/{facultyId}/courses")
    public Set<Course> getAssignedCourses(@PathVariable Long facultyId) {
        return facultyService.getAssignedCourses(facultyId);
    }
}
