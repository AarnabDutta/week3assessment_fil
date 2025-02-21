package com.springmvc.controller;

import com.springmvc.model.Admin;
import com.springmvc.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/register")
    public String registerAdmin(@RequestBody Admin admin) {
        adminService.registerAdmin(admin);
        return "Admin registered successfully!";
    }

    @PostMapping("/login")
    public String loginAdmin(@RequestParam String email, @RequestParam String password) {
        return adminService.login(email, password) ? "Admin login successful!" : "Invalid credentials!";
    }
}
