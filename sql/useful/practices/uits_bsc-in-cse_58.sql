-- ============================================================
-- B.Sc. in Computer Science and Engineering (CSE) Database SQL
-- University of Information Technology & Sciences (UITS)
-- Compatible with MySQL / PostgreSQL / SQLite
-- ============================================================

CREATE DATABASE IF NOT EXISTS cse_curriculum;
USE cse_curriculum;

-- ------------------------------------------------------------
-- 1. MASTER COURSES TABLE
-- ------------------------------------------------------------
DROP TABLE IF EXISTS semester_8;
DROP TABLE IF EXISTS semester_7;
DROP TABLE IF EXISTS semester_6;
DROP TABLE IF EXISTS semester_5;
DROP TABLE IF EXISTS semester_4;
DROP TABLE IF EXISTS semester_3;
DROP TABLE IF EXISTS semester_2;
DROP TABLE IF EXISTS semester_1;
DROP TABLE IF EXISTS specialization_courses;
DROP TABLE IF EXISTS elective_2_courses;
DROP TABLE IF EXISTS elective_1_courses;
DROP TABLE IF EXISTS ged_courses;
DROP TABLE IF EXISTS courses;

CREATE TABLE courses (
    course_id INT AUTO_INCREMENT PRIMARY KEY,
    course_code VARCHAR(20) NOT NULL UNIQUE,
    title VARCHAR(150) NOT NULL,
    credit DECIMAL(3,1) NOT NULL,
    theory_hours INT DEFAULT 0,
    lab_hours INT DEFAULT 0,
    category VARCHAR(50) NOT NULL
);

-- Populate Master Courses
INSERT INTO courses (course_code, title, credit, theory_hours, lab_hours, category) VALUES
-- Semester 1
('CSE0613111', 'Structured Programming Language', 3.0, 3, 0, 'Core'),
('CSE0613112', 'Structured Programming Language Lab', 1.5, 0, 3, 'Core Lab'),
('MATH0541111', 'Differential and Integral Calculus', 3.0, 3, 0, 'General Science'),
('CHEM0531111', 'Engineering Chemistry', 3.0, 3, 0, 'General Science'),
('GED0232111', 'Communicative English', 2.0, 2, 0, 'GED'),
('GED0232112', 'Communicative English Lab', 1.0, 0, 2, 'GED Lab'),
('PHYS0533111', 'Engineering Physics', 3.0, 3, 0, 'General Science'),
('PHYS0533112', 'Engineering Physics Lab', 1.0, 0, 2, 'General Science Lab'),

-- Semester 2
('CSE0613121', 'Object Oriented Programming Language', 3.0, 3, 0, 'Core'),
('CSE0613122', 'Object Oriented Programming Language Lab', 1.5, 0, 3, 'Core Lab'),
('CSE0541123', 'Discrete Mathematics', 3.0, 3, 0, 'Core'),
('EEE0713121', 'Fundamental of Electrical Engineering', 3.0, 3, 0, 'Engineering'),
('EEE0713122', 'Fundamental of Electrical Engineering Lab', 1.0, 0, 2, 'Engineering Lab'),
('MATH0541121', 'Ordinary and Partial Differential Equations', 3.0, 3, 0, 'General Science'),
('ME0715122', 'Engineering Drawing', 1.0, 0, 2, 'Engineering Lab'),
('SE0613124', 'Web Application Design Lab', 1.5, 0, 3, 'Software Engineering'),

-- Semester 3
('CSE0613211', 'Data Structures and Algorithms I', 3.0, 3, 0, 'Core'),
('CSE0613212', 'Data Structures and Algorithms I Lab', 1.5, 0, 3, 'Core Lab'),
('CSE0612211', 'Digital Logic Design', 3.0, 3, 0, 'Core'),
('CSE0612212', 'Digital Logic Design Lab', 1.0, 0, 2, 'Core Lab'),
('CSE0612215', 'Database Management System', 3.0, 3, 0, 'Core'),
('CSE0612216', 'Database Management System Lab', 1.5, 0, 3, 'Core Lab'),
('MATH0541211', 'Coordinate Geometry, Linear Algebra and Vector Analysis', 3.0, 3, 0, 'General Science'),
('EEE0714211', 'Electronic Devices and Circuits', 3.0, 3, 0, 'Engineering'),
('EEE0714212', 'Electronic Devices and Circuits Lab', 1.0, 0, 2, 'Engineering Lab'),

-- Semester 4
('CSE0613221', 'Data Structures and Algorithms II', 3.0, 3, 0, 'Core'),
('CSE0613222', 'Data Structures and Algorithms II Lab', 1.0, 0, 2, 'Core Lab'),
('CSE0612223', 'Data Communication', 3.0, 3, 0, 'Core'),
('SE0613225', 'Software Engineering and System Analysis', 3.0, 3, 0, 'Software Engineering'),
('SE0613226', 'Software Engineering and System Analysis Lab', 1.0, 0, 2, 'Software Engineering Lab'),
('CSE0614227', 'Numerical Methods and Analysis', 3.0, 3, 0, 'Core'),
('MATH0541221', 'Complex Variables, Fourier Analysis and Laplace Transform', 3.0, 3, 0, 'General Science'),

-- Semester 5
('CSE0613311', 'Artificial Intelligence', 3.0, 3, 0, 'Core'),
('CSE0613312', 'Artificial Intelligence Lab', 1.0, 0, 2, 'Core Lab'),
('CSE0612313', 'Computer Networks', 3.0, 3, 0, 'Core'),
('CSE0612314', 'Computer Networks Lab', 1.0, 0, 2, 'Core Lab'),
('SE0613316', 'Software Project Design and Development Lab', 1.5, 0, 3, 'Software Engineering Lab'),
('CSE0613315', 'Computer Architecture', 3.0, 3, 0, 'Core'),
('CSE0613317', 'Theory of Computation', 3.0, 3, 0, 'Core'),
('MATH0542311', 'Probability and Statistics', 3.0, 3, 0, 'General Science'),

-- Semester 6
('CSE0613321', 'Compiler', 3.0, 3, 0, 'Core'),
('CSE0613322', 'Compiler Lab', 1.0, 0, 2, 'Core Lab'),
('SE0607323', 'Microprocessors, Microcontrollers and Assembly Language', 3.0, 3, 0, 'Hardware'),
('SE0607324', 'Microprocessors, Microcontrollers and Assembly Language Lab', 1.0, 0, 2, 'Hardware Lab'),
('SE0612325', 'Cyber Security', 3.0, 3, 0, 'Security'),
('SE0612326', 'Cyber Security Lab', 1.0, 0, 2, 'Security Lab'),
('SE0613327', 'Computer Graphics & Multimedia', 3.0, 3, 0, 'Graphics'),
('SE0613328', 'Computer Graphics & Multimedia Lab', 1.5, 0, 3, 'Graphics Lab'),

-- Semester 7
('CSE0613411', 'Operating Systems', 3.0, 3, 0, 'Core'),
('CSE0613412', 'Operating Systems Lab', 1.0, 0, 2, 'Core Lab'),
('CSE0613414', 'Scientific Research & Methodologies Lab', 1.0, 0, 2, 'Research Lab'),
('CSE0613415', 'Simulation & Modeling Lab', 1.0, 0, 2, 'Simulation Lab'),
('CSE0613400', 'Thesis/CAPSTONE Project', 6.0, 0, 12, 'Project'),

-- Semester 8
('CSE0613416', 'Industrial Attachment', 1.0, 0, 2, 'Internship'),

-- General Education Courses (GED)
('GED0222111', 'Financial & Managerial Accounting', 2.0, 2, 0, 'GED Option'),
('GED0311221', 'Engineering Economics', 2.0, 2, 0, 'GED Option'),
('GED0541221', 'Industrial and Operation Management', 2.0, 2, 0, 'GED Option'),
('GED0421221', 'Business Law', 2.0, 2, 0, 'GED Option'),
('GED0222115', 'History of Emergence of Bangladesh', 2.0, 2, 0, 'GED Option'),
('GED0222113', 'Bangladesh Studies, History and Culture', 2.0, 2, 0, 'GED Option'),
('GED0232117', 'Bangla Language', 2.0, 2, 0, 'GED Option'),
('GED0222401', 'Professional Ethics and Communication for Engineering', 2.0, 2, 0, 'GED Option'),

-- Elective I
('CSE0611123A', 'Advanced Problem Solving Strategies Lab', 1.0, 0, 2, 'Elective I'),
('CS0611126', 'Internet Programming Lab', 1.0, 0, 2, 'Elective I'),
('CS0611202', 'Prototype and User Experience Design Lab', 1.0, 0, 2, 'Elective I'),
('CS0611302', 'Linux Programming Lab', 1.0, 0, 2, 'Elective I'),
('CS0611403', 'Technical Writings and Presentation Lab', 1.0, 0, 2, 'Elective I'),
('CS0611404', 'Software Project Management Lab', 1.0, 0, 2, 'Elective I'),

-- Elective II
('CSE0613426', 'Internet of Things', 3.0, 3, 0, 'Elective II'),
('CSE0613423', 'Foundations of Data Science', 3.0, 3, 0, 'Elective II'),
('CSE0613409', 'Mobile Application Development', 3.0, 3, 0, 'Elective II'),
('CSE0613407', 'Geographical Information Systems & Applications', 3.0, 3, 0, 'Elective II'),
('CSE0613405', 'Advanced Technology Used in Computer Science', 3.0, 3, 0, 'Elective II'),
('CSE0613497', 'Graph Theory', 3.0, 3, 0, 'Elective II'),

-- Specialization: Intelligent Systems
('CSE0613431', 'Machine Learning', 3.0, 3, 0, 'Intelligent Systems'),
('CSE0613431L', 'Machine Learning Lab', 1.0, 0, 2, 'Intelligent Systems Lab'),
('CSE0613432', 'Pattern Recognition', 3.0, 3, 0, 'Intelligent Systems'),
('CSE0613435', 'Computer Vision', 3.0, 3, 0, 'Intelligent Systems'),
('CSE0613437', 'Digital Image Processing', 3.0, 3, 0, 'Intelligent Systems'),
('CSE0613439', 'Information Retrieval', 3.0, 3, 0, 'Intelligent Systems'),
('CSE0613421', 'Neural Networks', 3.0, 3, 0, 'Intelligent Systems'),
('CSE0613422', 'Theory of Fuzzy Systems', 3.0, 3, 0, 'Intelligent Systems'),
('CSE0613425', 'Data Mining & Warehouse', 3.0, 3, 0, 'Intelligent Systems'),
('CSE0613427', 'Big Data Analytics', 3.0, 3, 0, 'Intelligent Systems'),
('CSE0613428', 'Bioinformatics & Computational Biology', 3.0, 3, 0, 'Intelligent Systems'),

-- Specialization: Software Engineering
('CSE0613441', 'Software Requirements Specification and Analysis', 3.0, 3, 0, 'Software Engineering'),
('CSE0613442', 'Software Project Management', 3.0, 3, 0, 'Software Engineering'),
('CSE0613443', 'Software Testing & Quality Assurance', 3.0, 3, 0, 'Software Engineering'),
('CSE0613444', 'Software Security and Maintenance', 3.0, 3, 0, 'Software Engineering'),
('CSE0613445', 'Enterprise Resource Planning & Content Management System', 3.0, 3, 0, 'Software Engineering'),
('CSE0613449', 'Innovation Management and Entrepreneurship', 3.0, 3, 0, 'Software Engineering'),
('CSE0613451', 'Software Measurement and Metrics', 3.0, 3, 0, 'Software Engineering'),
('CSE0613452', 'Software Architecture and Design', 3.0, 3, 0, 'Software Engineering'),

-- Specialization: Networks & Security
('CSE0612461', 'Satellite Communications', 3.0, 3, 0, 'Networks & Security'),
('CSE0612463', 'Telecommunication Systems Engineering', 3.0, 3, 0, 'Networks & Security'),
('CSE0612465', 'Mobile & Wireless Networks', 3.0, 3, 0, 'Networks & Security'),
('CSE0612467', 'Optical Fiber Communications', 3.0, 3, 0, 'Networks & Security'),
('CSE0612469', 'Computer Data & Network Security', 3.0, 3, 0, 'Networks & Security'),
('CSE0612471', 'Cloud Computing and Distributed System', 3.0, 3, 0, 'Networks & Security'),
('CSE0612473', 'Cryptography', 3.0, 3, 0, 'Networks & Security'),
('CSE0612475', 'Digital Signal Processing', 3.0, 3, 0, 'Networks & Security'),
('CSE0612477', 'Network Operations and Management', 3.0, 3, 0, 'Networks & Security'),

-- Specialization: Systems and Hardware
('CSE0607471', 'Real-Time Control Systems', 3.0, 3, 0, 'Systems & Hardware'),
('CSE0607473', 'Robotics', 3.0, 3, 0, 'Systems & Hardware'),
('CSE0607475', 'Human Computer Interaction', 3.0, 3, 0, 'Systems & Hardware'),
('CSE0607481', 'Embedded Systems', 3.0, 3, 0, 'Systems & Hardware'),
('CSE0607483', 'VLSI', 3.0, 3, 0, 'Systems & Hardware');


-- ------------------------------------------------------------
-- 2. GED & ELECTIVE TABLES
-- ------------------------------------------------------------
CREATE TABLE ged_courses (
    ged_id INT AUTO_INCREMENT PRIMARY KEY,
    course_id INT NOT NULL,
    FOREIGN KEY (course_id) REFERENCES courses(course_id) ON DELETE CASCADE
);

INSERT INTO ged_courses (course_id)
SELECT course_id FROM courses WHERE category = 'GED Option';

CREATE TABLE elective_1_courses (
    elective_1_id INT AUTO_INCREMENT PRIMARY KEY,
    course_id INT NOT NULL,
    FOREIGN KEY (course_id) REFERENCES courses(course_id) ON DELETE CASCADE
);

INSERT INTO elective_1_courses (course_id)
SELECT course_id FROM courses WHERE category = 'Elective I';

CREATE TABLE elective_2_courses (
    elective_2_id INT AUTO_INCREMENT PRIMARY KEY,
    course_id INT NOT NULL,
    FOREIGN KEY (course_id) REFERENCES courses(course_id) ON DELETE CASCADE
);

INSERT INTO elective_2_courses (course_id)
SELECT course_id FROM courses WHERE category = 'Elective II';


-- ------------------------------------------------------------
-- 3. SPECIALIZATION COURSES TABLE
-- ------------------------------------------------------------
CREATE TABLE specialization_courses (
    spec_id INT AUTO_INCREMENT PRIMARY KEY,
    course_id INT NOT NULL,
    group_name VARCHAR(100) NOT NULL,
    FOREIGN KEY (course_id) REFERENCES courses(course_id) ON DELETE CASCADE
);

INSERT INTO specialization_courses (course_id, group_name)
SELECT course_id, category FROM courses 
WHERE category IN ('Intelligent Systems', 'Intelligent Systems Lab', 'Software Engineering', 'Networks & Security', 'Systems & Hardware');


-- ------------------------------------------------------------
-- 4. SEMESTER TABLES (1 to 8)
-- ------------------------------------------------------------

-- Semester 1
CREATE TABLE semester_1 (
    sem1_id INT AUTO_INCREMENT PRIMARY KEY,
    course_id INT NOT NULL,
    FOREIGN KEY (course_id) REFERENCES courses(course_id) ON DELETE CASCADE
);

INSERT INTO semester_1 (course_id)
SELECT course_id FROM courses WHERE course_code IN (
    'CSE0613111', 'CSE0613112', 'MATH0541111', 'CHEM0531111', 
    'GED0232111', 'GED0232112', 'PHYS0533111', 'PHYS0533112'
);

-- Semester 2
CREATE TABLE semester_2 (
    sem2_id INT AUTO_INCREMENT PRIMARY KEY,
    course_id INT NOT NULL,
    FOREIGN KEY (course_id) REFERENCES courses(course_id) ON DELETE CASCADE
);

INSERT INTO semester_2 (course_id)
SELECT course_id FROM courses WHERE course_code IN (
    'CSE0613121', 'CSE0613122', 'CSE0541123', 'EEE0713121', 
    'EEE0713122', 'MATH0541121', 'ME0715122', 'SE0613124'
);

-- Semester 3
CREATE TABLE semester_3 (
    sem3_id INT AUTO_INCREMENT PRIMARY KEY,
    course_id INT NOT NULL,
    FOREIGN KEY (course_id) REFERENCES courses(course_id) ON DELETE CASCADE
);

INSERT INTO semester_3 (course_id)
SELECT course_id FROM courses WHERE course_code IN (
    'CSE0613211', 'CSE0613212', 'CSE0612211', 'CSE0612212', 
    'CSE0612215', 'CSE0612216', 'MATH0541211', 'EEE0714211', 'EEE0714212'
);

-- Semester 4
CREATE TABLE semester_4 (
    sem4_id INT AUTO_INCREMENT PRIMARY KEY,
    course_id INT NOT NULL,
    FOREIGN KEY (course_id) REFERENCES courses(course_id) ON DELETE CASCADE
);

INSERT INTO semester_4 (course_id)
SELECT course_id FROM courses WHERE course_code IN (
    'CSE0613221', 'CSE0613222', 'CSE0612223', 'SE0613225', 
    'SE0613226', 'CSE0614227', 'MATH0541221'
);

-- Semester 5
CREATE TABLE semester_5 (
    sem5_id INT AUTO_INCREMENT PRIMARY KEY,
    course_id INT NOT NULL,
    FOREIGN KEY (course_id) REFERENCES courses(course_id) ON DELETE CASCADE
);

INSERT INTO semester_5 (course_id)
SELECT course_id FROM courses WHERE course_code IN (
    'CSE0613311', 'CSE0613312', 'CSE0612313', 'CSE0612314', 
    'SE0613316', 'CSE0613315', 'CSE0613317', 'MATH0542311'
);

-- Semester 6
CREATE TABLE semester_6 (
    sem6_id INT AUTO_INCREMENT PRIMARY KEY,
    course_id INT NOT NULL,
    FOREIGN KEY (course_id) REFERENCES courses(course_id) ON DELETE CASCADE
);

INSERT INTO semester_6 (course_id)
SELECT course_id FROM courses WHERE course_code IN (
    'CSE0613321', 'CSE0613322', 'SE0607323', 'SE0607324', 
    'SE0612325', 'SE0612326', 'SE0613327', 'SE0613328'
);

-- Semester 7
CREATE TABLE semester_7 (
    sem7_id INT AUTO_INCREMENT PRIMARY KEY,
    course_id INT NOT NULL,
    FOREIGN KEY (course_id) REFERENCES courses(course_id) ON DELETE CASCADE
);

INSERT INTO semester_7 (course_id)
SELECT course_id FROM courses WHERE course_code IN (
    'CSE0613411', 'CSE0613412', 'CSE0613414', 'CSE0613415', 'CSE0613400'
);

-- Semester 8
CREATE TABLE semester_8 (
    sem8_id INT AUTO_INCREMENT PRIMARY KEY,
    course_id INT NOT NULL,
    FOREIGN KEY (course_id) REFERENCES courses(course_id) ON DELETE CASCADE
);

INSERT INTO semester_8 (course_id)
SELECT course_id FROM courses WHERE course_code = 'CSE0613416';
