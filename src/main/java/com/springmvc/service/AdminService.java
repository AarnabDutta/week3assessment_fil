package com.springmvc.service;

import com.springmvc.model.Admin;
import com.springmvc.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public void registerAdmin(Admin admin) {
        adminRepository.save(admin);
    }

    public boolean login(String email, String password) {
        Optional<Admin> admin = adminRepository.findByEmail(email);
        return admin.isPresent() && admin.get().getPassword().equals(password);
    }
}
