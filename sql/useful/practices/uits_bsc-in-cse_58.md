# B.Sc. in Computer Science and Engineering Database Schema (SQL)

This database structure models the B.Sc. in Computer Science and Engineering curriculum.

---

## SQL DDL & Schema Setup

```sql
-- Create Database
CREATE DATABASE IF NOT EXISTS CSE_Curriculum;
USE CSE_Curriculum;

-- 1. Master Courses Table
CREATE TABLE courses (
    course_id INT AUTO_INCREMENT PRIMARY KEY,
    course_code VARCHAR(20) NOT NULL UNIQUE,
    course_title VARCHAR(150) NOT NULL,
    credit DECIMAL(3,1) NOT NULL DEFAULT 0.0,
    theory_hours INT DEFAULT 0,
    lab_hours INT DEFAULT 0,
    category VARCHAR(50) NOT NULL -- e.g., 'Core', 'GED', 'Elective I', 'Elective II', 'Specialization'
);

-- 2. Semester Tables (Semester 1 - 8)
CREATE TABLE semester_1 (
    sem1_id INT AUTO_INCREMENT PRIMARY KEY,
    course_id INT NOT NULL,
    FOREIGN KEY (course_id) REFERENCES courses(course_id) ON DELETE CASCADE
);

CREATE TABLE semester_2 (
    sem2_id INT AUTO_INCREMENT PRIMARY KEY,
    course_id INT NOT NULL,
    FOREIGN KEY (course_id) REFERENCES courses(course_id) ON DELETE CASCADE
);

CREATE TABLE semester_3 (
    sem3_id INT AUTO_INCREMENT PRIMARY KEY,
    course_id INT NOT NULL,
    FOREIGN KEY (course_id) REFERENCES courses(course_id) ON DELETE CASCADE
);

CREATE TABLE semester_4 (
    sem4_id INT AUTO_INCREMENT PRIMARY KEY,
    course_id INT NOT NULL,
    FOREIGN KEY (course_id) REFERENCES courses(course_id) ON DELETE CASCADE
);

CREATE TABLE semester_5 (
    sem5_id INT AUTO_INCREMENT PRIMARY KEY,
    course_id INT NOT NULL,
    FOREIGN KEY (course_id) REFERENCES courses(course_id) ON DELETE CASCADE
);

CREATE TABLE semester_6 (
    sem6_id INT AUTO_INCREMENT PRIMARY KEY,
    course_id INT NOT NULL,
    FOREIGN KEY (course_id) REFERENCES courses(course_id) ON DELETE CASCADE
);

CREATE TABLE semester_7 (
    sem7_id INT AUTO_INCREMENT PRIMARY KEY,
    course_id INT NOT NULL,
    FOREIGN KEY (course_id) REFERENCES courses(course_id) ON DELETE CASCADE
);

CREATE TABLE semester_8 (
    sem8_id INT AUTO_INCREMENT PRIMARY KEY,
    course_id INT NOT NULL,
    FOREIGN KEY (course_id) REFERENCES courses(course_id) ON DELETE CASCADE
);

-- 3. General Education Courses (GED) Table
CREATE TABLE ged_courses (
    ged_id INT AUTO_INCREMENT PRIMARY KEY,
    course_id INT NOT NULL,
    FOREIGN KEY (course_id) REFERENCES courses(course_id) ON DELETE CASCADE
);

-- 4. Elective Tables (Elective I and Elective II)
CREATE TABLE elective_1_courses (
    elective1_id INT AUTO_INCREMENT PRIMARY KEY,
    course_id INT NOT NULL,
    FOREIGN KEY (course_id) REFERENCES courses(course_id) ON DELETE CASCADE
);

CREATE TABLE elective_2_courses (
    elective2_id INT AUTO_INCREMENT PRIMARY KEY,
    course_id INT NOT NULL,
    FOREIGN KEY (course_id) REFERENCES courses(course_id) ON DELETE CASCADE
);

-- 5. Specialization Courses Table
CREATE TABLE specialization_courses (
    spec_id INT AUTO_INCREMENT PRIMARY KEY,
    course_id INT NOT NULL,
    group_name VARCHAR(50) NOT NULL, -- 'Intelligent Systems', 'Software Engineering', 'Networks & Security', 'Systems and Hardware'
    FOREIGN KEY (course_id) REFERENCES courses(course_id) ON DELETE CASCADE
);
```

---

##  Data Insertion Scripts

```sql
-- =========================================================
-- 1. INSERT ALL COURSES INTO MASTER TABLE
-- =========================================================

-- Semester 1 Courses
INSERT INTO courses (course_code, course_title, credit, theory_hours, lab_hours, category) VALUES
('CSE0613111', 'Structured Programming Language', 3.0, 3, 0, 'Core'),
('CSE0613112', 'Structured Programming Language Lab', 1.5, 0, 3, 'Core'),
('MATH0541111', 'Differential and Integral Calculus', 3.0, 3, 0, 'Core'),
('CHEM0531175', 'Engineering Chemistry', 3.0, 3, 0, 'Core'),
('GED0232111', 'Communicative English', 3.0, 3, 0, 'GED'),
('GED0232112', 'Communicative English Lab', 1.0, 0, 2, 'GED'),
('PHYS0533111', 'Engineering Physics', 3.0, 3, 0, 'Core'),
('PHYS0533112', 'Engineering Physics Lab', 1.0, 0, 2, 'Core');

-- Semester 2 Courses
INSERT INTO courses (course_code, course_title, credit, theory_hours, lab_hours, category) VALUES
('CSE0613121', 'Object Oriented Programming Language', 3.0, 3, 0, 'Core'),
('CSE0613122', 'Object Oriented Programming Language Lab', 1.5, 0, 3, 'Core'),
('CSE0541123', 'Discrete Mathematics', 3.0, 3, 0, 'Core'),
('EEE0713121', 'Fundamental of Electrical Engineering', 3.0, 3, 0, 'Core'),
('EEE0713122', 'Fundamental of Electrical Engineering Lab', 1.0, 0, 2, 'Core'),
('MATH0541121', 'Ordinary and Partial Differential Equations', 3.0, 3, 0, 'Core'),
('ME0715122', 'Engineering Drawing', 1.0, 0, 2, 'Core'),
('CSE0613124', 'Web Application Design Lab', 1.5, 0, 3, 'Core');

-- Semester 3 Courses
INSERT INTO courses (course_code, course_title, credit, theory_hours, lab_hours, category) VALUES
('CSE0613211', 'Data Structures and Algorithms I', 3.0, 3, 0, 'Core'),
('CSE0613212', 'Data Structures and Algorithms I Lab', 1.5, 0, 3, 'Core'),
('CSE0611215', 'Digital Logic Design', 3.0, 3, 0, 'Core'),
('CSE0611216', 'Digital Logic Design Lab', 1.0, 0, 2, 'Core'),
('CSE0612215', 'Database Management System', 3.0, 3, 0, 'Core'),
('CSE0612216', 'Database Management System Lab', 1.5, 0, 3, 'Core'),
('MATH0541211', 'Coordinate Geometry, Linear Algebra and Vector Analysis', 3.0, 3, 0, 'Core'),
('EEE0714211', 'Electronic Devices and Circuits', 3.0, 3, 0, 'Core'),
('EEE0714212', 'Electronic Devices and Circuits Lab', 1.0, 0, 2, 'Core');

-- Semester 4 Courses
INSERT INTO courses (course_code, course_title, credit, theory_hours, lab_hours, category) VALUES
('CSE0613221', 'Data Structures and Algorithms II', 3.0, 3, 0, 'Core'),
('CSE0613222', 'Data Structures and Algorithms II Lab', 1.5, 0, 3, 'Core'),
('CSE0612223', 'Data Communication', 3.0, 3, 0, 'Core'),
('CSE0613225', 'Software Engineering and System Analysis', 3.0, 3, 0, 'Core'),
('CSE0613226', 'Software Engineering and System Analysis Lab', 1.5, 0, 3, 'Core'),
('CSE0541227', 'Numerical Methods and Analysis', 3.0, 3, 0, 'Core'),
('MATH0541221', 'Complex Variables, Fourier Analysis and Laplace Transform', 3.0, 3, 0, 'Core');

-- Semester 5 Courses
INSERT INTO courses (course_code, course_title, credit, theory_hours, lab_hours, category) VALUES
('CSE0613311', 'Artificial Intelligence', 3.0, 3, 0, 'Core'),
('CSE0613312', 'Artificial Intelligence Lab', 1.0, 0, 2, 'Core'),
('CSE0612313', 'Computer Networks', 3.0, 3, 0, 'Core'),
('CSE0612314', 'Computer Networks Lab', 1.0, 0, 2, 'Core'),
('CSE0611316', 'Software Project Design and Development Lab', 1.5, 0, 3, 'Core'),
('CSE0611317', 'Computer Architecture', 3.0, 3, 0, 'Core'),
('CSE0611319', 'Theory of Computation', 2.0, 2, 0, 'Core'),
('MATH0542313', 'Probability and Statistics', 3.0, 3, 0, 'Core');

-- Semester 6 Courses
INSERT INTO courses (course_code, course_title, credit, theory_hours, lab_hours, category) VALUES
('CSE0613321', 'Compiler', 3.0, 3, 0, 'Core'),
('CSE0613322', 'Compiler Lab', 1.0, 0, 2, 'Core'),
('CSE0711323', 'Microprocessors, Microcontrollers and Assembly Language', 3.0, 3, 0, 'Core'),
('CSE0711324', 'Microprocessors, Microcontrollers and Assembly Language Lab', 1.0, 0, 2, 'Core'),
('CSE0612325', 'Cyber Security', 3.0, 3, 0, 'Core'),
('CSE0612326', 'Cyber Security Lab', 1.0, 0, 2, 'Core'),
('CSE0611327', 'Computer Graphics & Multimedia', 3.0, 3, 0, 'Core'),
('CSE0611328', 'Computer Graphics & Multimedia Lab', 1.5, 0, 3, 'Core');

-- Semester 7 Courses
INSERT INTO courses (course_code, course_title, credit, theory_hours, lab_hours, category) VALUES
('CSE0611411', 'Operating Systems', 3.0, 3, 0, 'Core'),
('CSE0611412', 'Operating Systems Lab', 1.0, 0, 2, 'Core'),
('CSE0613414', 'Scientific Research & Methodologies Lab', 1.0, 0, 2, 'Core'),
('CSE0611416', 'Simulation & Modeling Lab', 1.0, 0, 2, 'Core'),
('CSE0613400', 'Thesis/CAPSTONE Project', 4.5, 0, 9, 'Core');

-- Semester 8 Courses
INSERT INTO courses (course_code, course_title, credit, theory_hours, lab_hours, category) VALUES
('CSE0613416', 'Industrial Attachment', 1.0, 0, 2, 'Core');

-- General Education Courses (GED)
INSERT INTO courses (course_code, course_title, credit, theory_hours, lab_hours, category) VALUES
('GED0411311', 'Financial & Managerial Accounting', 2.0, 2, 0, 'GED'),
('GED0713133', 'Engineering Economics', 2.0, 2, 0, 'GED'),
('GED0413321', 'Industrial and Operation Management', 2.0, 2, 0, 'GED'),
('GED0421323', 'Business Law', 2.0, 2, 0, 'GED'),
('GED0222119', 'History of Emergence of Bangladesh', 2.0, 2, 0, 'GED'),
('GED0222121', 'Bangladesh Studies: History and Culture', 2.0, 2, 0, 'GED'),
('GED0232117', 'Bangla Language', 2.0, 2, 0, 'GED'),
('GED0223421', 'Professional Ethics and Communication for Engineering', 2.0, 2, 0, 'GED');

-- Elective I Courses
INSERT INTO courses (course_code, course_title, credit, theory_hours, lab_hours, category) VALUES
('CSE0613204', 'Advanced Problem-Solving Strategies Lab', 1.0, 0, 2, 'Elective I'),
('CSE0613208', 'Internet Programming Lab', 1.0, 0, 2, 'Elective I'),
('CSE0611302', 'Prototype and User Experience Design Lab', 1.0, 0, 2, 'Elective I'),
('CSE0611304', 'Linux Programming Lab', 1.0, 0, 2, 'Elective I'),
('CSE0679492', 'Technical Writings and Presentation Lab', 1.0, 0, 2, 'Elective I'),
('CSE0613494', 'Software Project Management Lab', 1.0, 0, 2, 'Elective I');

-- Elective II Courses
INSERT INTO courses (course_code, course_title, credit, theory_hours, lab_hours, category) VALUES
('CSE0612401', 'Internet of Things', 3.0, 3, 0, 'Elective II'),
('CSE0612403', 'Foundation of Data Science', 3.0, 3, 0, 'Elective II'),
('CSE0613405', 'Mobile Application Development', 3.0, 3, 0, 'Elective II'),
('CSE0613407', 'Geographical Information Systems & Applications', 3.0, 3, 0, 'Elective II'),
('CSE0611489', 'Advanced Technology used in Computer Science', 3.0, 3, 0, 'Elective II'),
('CSE0612497', 'Graph Theory', 3.0, 3, 0, 'Elective II');

-- Specialization: Intelligent Systems
INSERT INTO courses (course_code, course_title, credit, theory_hours, lab_hours, category) VALUES
('CSE0611431', 'Machine Learning', 3.0, 3, 0, 'Specialization'),
('CSE0611433', 'Pattern Recognition', 3.0, 3, 0, 'Specialization'),
('CSE0611435', 'Computer Vision', 3.0, 3, 0, 'Specialization'),
('CSE0611437', 'Digital Image Processing', 3.0, 3, 0, 'Specialization'),
('CSE0612439', 'Information Retrieval', 3.0, 3, 0, 'Specialization'),
('CSE0611451', 'Neural Networks', 3.0, 3, 0, 'Specialization'),
('CSE0611453', 'Theory of Fuzzy Systems', 3.0, 3, 0, 'Specialization'),
('CSE0612455', 'Data Mining & Warehouse', 3.0, 3, 0, 'Specialization'),
('CSE0612457', 'Big Data Analytics', 3.0, 3, 0, 'Specialization'),
('CSE0611459', 'Bioinformatics & Computational Biology', 3.0, 3, 0, 'Specialization');

-- Specialization: Software Engineering
INSERT INTO courses (course_code, course_title, credit, theory_hours, lab_hours, category) VALUES
('CSE0613441', 'Software Requirements Specification and Analysis', 3.0, 3, 0, 'Specialization'),
('CSE0613443', 'Software Project Management', 3.0, 3, 0, 'Specialization'),
('CSE0613445', 'Software Testing & Quality Assurance', 3.0, 3, 0, 'Specialization'),
('CSE0613447', 'Software Security and Maintenance', 3.0, 3, 0, 'Specialization'),
('CSE0612449', 'Enterprise Resource Planning & Content Management System', 3.0, 3, 0, 'Specialization'),
('CSE0612495', 'Innovation Management and Entrepreneurship', 3.0, 3, 0, 'Specialization'),
('CSE0612451', 'Software Measurement and Metrics', 3.0, 3, 0, 'Specialization'),
('CSE0612453', 'Software Architecture and Design', 3.0, 3, 0, 'Specialization');

-- Specialization: Networks & Security
INSERT INTO courses (course_code, course_title, credit, theory_hours, lab_hours, category) VALUES
('CSE0612461', 'Satellite Communications', 3.0, 3, 0, 'Specialization'),
('CSE0612463', 'Telecommunication Systems Engineering', 3.0, 3, 0, 'Specialization'),
('CSE0612465', 'Mobile & Wireless Networks', 3.0, 3, 0, 'Specialization'),
('CSE0612467', 'Optical Fiber Communications', 3.0, 3, 0, 'Specialization'),
('CSE0612469', 'Computer Data & Network Security', 3.0, 3, 0, 'Specialization'),
('CSE0612471', 'Cloud Computing and Distributed System', 3.0, 3, 0, 'Specialization'),
('CSE0612475', 'Cryptography', 3.0, 3, 0, 'Specialization'),
('CSE0611477', 'Digital Signal Processing', 3.0, 3, 0, 'Specialization'),
('CSE0612479', 'Network Operations and Management', 3.0, 3, 0, 'Specialization');

-- Specialization: Systems and Hardware
INSERT INTO courses (course_code, course_title, credit, theory_hours, lab_hours, category) VALUES
('CSE0611473', 'Real-time Control Systems', 3.0, 3, 0, 'Specialization'),
('CSE0611481', 'Robotics', 3.0, 3, 0, 'Specialization'),
('CSE0611483', 'Human Computer Interaction', 3.0, 3, 0, 'Specialization'),
('CSE0611485', 'Embedded Systems', 3.0, 3, 0, 'Specialization'),
('CSE0611487', 'VLSI', 3.0, 3, 0, 'Specialization');


-- =========================================================
-- 2. LINK COURSES TO SEMESTER TABLES
-- =========================================================
 
-- Semester 1 Links
INSERT INTO semester_1 (course_id)
SELECT course_id FROM courses WHERE course_code IN 
('CSE0613111', 'CSE0613112', 'MATH0541111', 'CHEM0531175', 'GED0232111', 'GED0232112', 'PHYS0533111', 'PHYS0533112');

-- Semester 2 Links
INSERT INTO semester_2 (course_id)
SELECT course_id FROM courses WHERE course_code IN 
('CSE0613121', 'CSE0613122', 'CSE0541123', 'EEE0713121', 'EEE0713122', 'MATH0541211', 'ME0715122', 'CSE0613124');

-- Semester 3 Links
INSERT INTO semester_3 (course_id)
SELECT course_id FROM courses WHERE course_code IN 
('CSE0613211', 'CSE0613212', 'CSE0611215', 'CSE0611216', 'CSE0612215', 'CSE0612216', 'MATH0541211', 'EEE0714211', 'EEE0714212');

-- Semester 4 Links
INSERT INTO semester_4 (course_id)
SELECT course_id FROM courses WHERE course_code IN 
('CSE0613221', 'CSE0613222', 'CSE0612223', 'CSE0613225', 'CSE0613226', 'CSE0541227', 'MATH0541221');

-- Semester 5 Links
INSERT INTO semester_5 (course_id)
SELECT course_id FROM courses WHERE course_code IN 
('CSE0613311', 'CSE0613312', 'CSE0612313', 'CSE0612314', 'CSE0611316', 'CSE0611317', 'CSE0611319', 'MATH0542313');

-- Semester 6 Links
INSERT INTO semester_6 (course_id)
SELECT course_id FROM courses WHERE course_code IN 
('CSE0613321', 'CSE0613322', 'CSE0711323', 'CSE0711324', 'CSE0612325', 'CSE0612326', 'CSE0611327', 'CSE0611328');

-- Semester 7 Links
INSERT INTO semester_7 (course_id)
SELECT course_id FROM courses WHERE course_code IN 
('CSE0611411', 'CSE0611412', 'CSE0613414', 'CSE0611416', 'CSE0613400');

-- Semester 8 Links
INSERT INTO semester_8 (course_id)
SELECT course_id FROM courses WHERE course_code IN 
('CSE0613416');


-- =========================================================
-- 3. LINK COURSES TO GED, ELECTIVES & SPECIALIZATION TABLES
-- =========================================================

-- GED Table Links
INSERT INTO ged_courses (course_id)
SELECT course_id FROM courses WHERE course_code IN 
('GED0232111', 'GED0232112', 'GED0411311', 'GED0713133', 'GED0413321', 'GED0421323', 'GED0222119', 'GED0222121', 'GED0232117', 'GED0223421');

-- Elective 1 Links
INSERT INTO elective_1_courses (course_id)
SELECT course_id FROM courses WHERE course_code IN 
('CSE0613204', 'CSE0613208', 'CSE0611302', 'CSE0611304', 'CSE0679492', 'CSE0613494');

-- Elective 2 Links
INSERT INTO elective_2_courses (course_id)
SELECT course_id FROM courses WHERE course_code IN 
('CSE0612401', 'CSE0612403', 'CSE0613405', 'CSE0613407', 'CSE0611489', 'CSE0612497');

-- Specialization Links
INSERT INTO specialization_courses (course_id, group_name)
SELECT course_id, 'Intelligent Systems' FROM courses WHERE course_code IN 
('CSE0611431', 'CSE0611433', 'CSE0611435', 'CSE0611437', 'CSE0612439', 'CSE0611451', 'CSE0611453', 'CSE0612455', 'CSE0612457', 'CSE0611459');

INSERT INTO specialization_courses (course_id, group_name)
SELECT course_id, 'Software Engineering' FROM courses WHERE course_code IN 
('CSE0613441', 'CSE0613443', 'CSE0613445', 'CSE0613447', 'CSE0612449', 'CSE0612495', 'CSE0612451', 'CSE0612453');

INSERT INTO specialization_courses (course_id, group_name)
SELECT course_id, 'Networks & Security' FROM courses WHERE course_code IN 
('CSE0612461', 'CSE0612463', 'CSE0612465', 'CSE0612467', 'CSE0612469', 'CSE0612471', 'CSE0612475', 'CSE0611477', 'CSE0612479');

INSERT INTO specialization_courses (course_id, group_name)
SELECT course_id, 'Systems and Hardware' FROM courses WHERE course_code IN 
('CSE0611473', 'CSE0611481', 'CSE0611483', 'CSE0611485', 'CSE0611487');
```

---

## 🔍 Sample Queries for Testing

### Get all courses in Semester 1 with title and credit
```sql
SELECT c.course_code, c.course_title, c.credit 
FROM semester_1 s
JOIN courses c ON s.course_id = c.course_id;
```

### Get all Specialization Courses in 'Intelligent Systems'
```sql
SELECT c.course_code, c.course_title, c.credit 
FROM specialization_courses sc
JOIN courses c ON sc.course_id = c.course_id
WHERE sc.group_name = 'Intelligent Systems';
```