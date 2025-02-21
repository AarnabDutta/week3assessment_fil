CREATE DATABASE springmvc_cli;
USE springmvc_cli;
CREATE TABLE admin (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);
CREATE TABLE faculty (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    mobile VARCHAR(15) NOT NULL
);

CREATE TABLE course (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    duration VARCHAR(50) NOT NULL
);

CREATE TABLE faculty_course_assignment (
    faculty_id INT,
    course_id INT,
    PRIMARY KEY (faculty_id, course_id),
    FOREIGN KEY (faculty_id) REFERENCES faculty(id) ON DELETE CASCADE,
    FOREIGN KEY (course_id) REFERENCES course(id) ON DELETE CASCADE
);

-- Insert Admin
INSERT INTO admin (name, email, password) VALUES 
('Admin User', 'admin@example.com', 'admin123');

-- Insert Faculties
INSERT INTO faculty (name, email, password, mobile) VALUES 
('Dr. John Doe', 'john@example.com', 'password123', '9876543210'),
('Prof. Jane Smith', 'jane@example.com', 'password456', '8765432109');

-- Insert Courses
INSERT INTO course (name, duration) VALUES 
('Java Programming', '3 Months'),
('Spring Boot', '4 Months');

-- Assign Courses to Faculties
INSERT INTO faculty_course_assignment (faculty_id, course_id) VALUES 
(1, 1),  
(2, 2);  

SELECT * FROM admin;

-- Check Faculties
SELECT * FROM faculty;

-- Check Courses
SELECT * FROM course;

-- Check Faculty-Course Assignments
SELECT f.name AS Faculty, c.name AS Course 
FROM faculty_course_assignment fca
JOIN faculty f ON fca.faculty_id = f.id
JOIN course c ON fca.course_id = c.id;


