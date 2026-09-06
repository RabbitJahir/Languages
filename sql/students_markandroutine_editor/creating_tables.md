## Creating the tables

```sql
CREATE TABLE students_account (
    db_id INT AUTO_INCREMENT PRIMARY KEY,
    std_id INT NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);
```

```sql
CREATE TABLE departments (
    dep_id TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    CHECK(dep_id BETWEEN 1 AND 8)
);
```
```sql
CREATE TABLE semesters (
    sem_id TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    sems VARCHAR(8) NOT NULL UNIQUE,
    CHECK(sem_id BETWEEN 1 AND 9)
);
```
```sql
CREATE TABLE sections (
    sec_name VARCHAR(10) PRIMARY KEY,
    section VARCHAR(10) NOT NULL,
    dep_id TINYINT UNSIGNED NOT NULL,
    sem_id TINYINT UNSIGNED NOT NULL,

    FOREIGN KEY (dep_id) REFERENCES departments(dep_id),
    FOREIGN KEY (sem_id) REFERENCES semesters(sem_id),

    UNIQUE (section, dep_id, sem_id)
);
```
```sql
CREATE TABLE current_section (
    sec_id SMALLINT UNSIGNED PRIMARY KEY,
    sec_name VARCHAR(10) NOT NULL UNIQUE,
    
    FOREIGN KEY (sec_name) REFERENCES sections(sec_name),
    CHECK(sec_id BETWEEN 1 AND 32)
);
```

```sql
CREATE TABLE students_sections (
    std_id INT(25) NOT NULL PRIMARY KEY,
    sec_id SMALLINT UNSIGNED NOT NULL,

    FOREIGN KEY (std_id) REFERENCES students_account(std_id),
    FOREIGN KEY (sec_id) REFERENCES current_section(sec_id)
);
```

```sql
CREATE TABLE courses (
    course_id SMALLINT UNSIGNED PRIMARY KEY,
    course_code VARCHAR(20) NOT NULL UNIQUE,
    course_name VARCHAR(100) NOT NULL,
    credit DECIMAL(2,1) NOT NULL,

    CHECK (credit IN (0.5, 1.0, 1.5, 2.0, 3.0, 4.0))

);
```
```sql
CREATE TABLE rooms (
    room_id TINYINT UNSIGNED PRIMARY KEY,
    room_no VARCHAR(20) NOT NULL UNIQUE,
    room_name VARCHAR(100)
);
```
```sql
CREATE TABLE teachers (
    teacher_id SMALLINT UNSIGNED PRIMARY KEY,
    initial VARCHAR(20) NOT NULL UNIQUE,
    full_name VARCHAR(100),
    dep_id TINYINT UNSIGNED NOT NULL,

    FOREIGN KEY(dep_id) references departments(dep_id)
);
```

```sql
CREATE TABLE exam_type(
    exam_type_id TINYINT UNSIGNED PRIMARY KEY,
    exam_type VARCHAR(20) NOT NULL UNIQUE
)
```

```sql
CREATE TABLE marks (
    mark_id INT AUTO_INCREMENT PRIMARY KEY,
    std_id INT(25) NOT NULL,
    sec_id SMALLINT UNSIGNED NOT NULL,
    course_id SMALLINT UNSIGNED NOT NULL,
    exam_type_id TINYINT UNSIGNED ,
    total_marks DECIMAL(5,2) NOT NULL,
    gotten_marks DECIMAL(5,2) NOT NULL,

    FOREIGN KEY (std_id) REFERENCES students_account(std_id),
    FOREIGN KEY (sec_id) REFERENCES current_section(sec_id),
    FOREIGN KEY (course_id) REFERENCES courses(course_id),
    FOREIGN KEY (exam_type_id) REFERENCES exam_type(exam_type_id),

    CHECK (total_marks > 0),
    CHECK (gotten_marks >= 0 AND gotten_marks <= total_marks),

    UNIQUE (std_id, sec_id, course_id, exam_type_id)
);
```

```sql
CREATE TABLE routine (
    routine_id INT AUTO_INCREMENT PRIMARY KEY,
    sec_id SMALLINT UNSIGNED NOT NULL,
    teacher_id SMALLINT UNSIGNED NOT NULL,
    course_id SMALLINT UNSIGNED NOT NULL,
    day_of_week TINYINT NOT NULL ,
    room_id TINYINT UNSIGNED NOT NULL,
    start_time time NOT NULL,
    end_time time NOT NULL,

    FOREIGN KEY (sec_id) REFERENCES current_section(sec_id),
    FOREIGN KEY (course_id) REFERENCES courses(course_id),
    FOREIGN KEY (room_id) REFERENCES rooms(room_id),
    FOREIGN KEY (teacher_id) REFERENCES teachers(teacher_id),

    CHECK (day_of_week BETWEEN 1 AND 7),
    CHECK (end_time > start_time),
    UNIQUE (sec_id, day_of_week, start_time)
);
```
