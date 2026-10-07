# SQL Practice Set --- Students & Courses

---

## Table 1: `students`

| Field Name   | Data Type      | Key Type    | Description                             |
| :----------- | :------------- | :---------- | :-------------------------------------- |
| `student_id` | `INT`          | Primary Key | Unique student ID                       |
| `name`       | `VARCHAR(50)`  | -           | Student's full name                     |
| `email`      | `VARCHAR(100)` | -           | Student email                           |
| `city`       | `VARCHAR(30)`  | -           | Student's city                          |
| `age`        | `INT`          | -           | Student's age                           |
| `gpa`        | `DECIMAL(3,2)` | -           | Student GPA                             |
| `is_active`  | `BOOLEAN`      | -           | Whether the student is currently active |

### Sample Data

```sql
INSERT INTO students
(student_id, name, email, city, age, gpa, is_active)
VALUES
(101, 'Rahim', 'rahim@gmail.com', 'Dhaka', 20, 3.75, TRUE),
(102, 'Karim', 'karim@gmail.com', 'Chittagong', 22, 3.20, TRUE),
(103, 'Nadia', 'nadia@gmail.com', 'Dhaka', 19, 3.90, TRUE),
(104, 'Sakib', 'sakib@gmail.com', 'Sylhet', 23, 2.85, FALSE),
(105, 'Mim', 'mim@gmail.com', 'Dhaka', 21, 3.45, TRUE),
(106, 'Hasan', 'hasan@gmail.com', 'Rajshahi', 20, 2.70, FALSE),
(107, 'Tania', 'tania@gmail.com', 'Khulna', 22, 3.60, TRUE),
(108, 'Rafi', 'rafi@gmail.com', 'Dhaka', 24, 3.10, TRUE);
```

---

## Table 2: `courses`

| Field Name     | Data Type      | Key Type    | Description                               |
| :------------- | :------------- | :---------- | :---------------------------------------- |
| `course_id`    | `INT`          | Primary Key | Unique course ID                          |
| `course_code`  | `VARCHAR(10)`  | -           | Course code                               |
| `course_name`  | `VARCHAR(50)`  | -           | Course name                               |
| `department`   | `VARCHAR(30)`  | -           | Department offering course                |
| `credits`      | `INT`          | -           | Number of credits                         |
| `fee`          | `DECIMAL(8,2)` | -           | Course fee                                |
| `is_available` | `BOOLEAN`      | -           | Whether the course is currently available |

---

### Sample Data

```sql
INSERT INTO courses
(course_id, course_code, course_name, department, credits, fee, is_available)
VALUES
(1, 'CSE101', 'Programming Fundamentals', 'CSE', 3, 5000.00, TRUE),
(2, 'CSE203', 'Database Systems', 'CSE', 3, 6000.00, TRUE),
(3, 'CSE305', 'Computer Networks', 'CSE', 3, 5500.00, TRUE),
(4, 'MAT101', 'Calculus', 'Mathematics', 4, 4500.00, TRUE),
(5, 'EEE201', 'Digital Logic', 'EEE', 3, 5200.00, FALSE),
(6, 'ENG101', 'English Communication', 'English', 2, 3000.00, TRUE),
(7, 'CSE401', 'Artificial Intelligence', 'CSE', 3, 7500.00, TRUE),
(8, 'CSE410', 'Machine Learning', 'CSE', 4, 8000.00, FALSE);
```

---

# 30 Practice Questions

## DDL / Table Operations

### 1. (DDL --- CREATE)

Create the `students` table with the given fields and appropriate data
types. Make `student_id` the primary key.

### 2. (DDL --- CREATE)

Create the `courses` table with the given fields and appropriate data
types. Make `course_id` the primary key.

### 3. (DML --- INSERT)

Insert a new student with your own information into the `students`
table.

### 4. (DML --- INSERT)

Insert a new course into the `courses` table.

### 5. (DDL --- ALTER)

Add a new column called `phone` with datatype `VARCHAR(15)` to the
`students` table.

### 6. (DDL --- ALTER)

Change the `phone` column so that it can store up to 20 characters.

### 7. (DDL --- RENAME)

Rename the `courses` table to `course_master`.

### 8. (DDL --- SHOW CREATE TABLE)

Display the complete SQL statement used to create the `students` table.

---

## DQL / SELECT / WHERE

### 9. (DQL)

Display the names and email addresses of all students.

### 10. (DISTINCT)

Display all the different cities represented in the `students` table.

### 11. (WHERE)

Find all students who live in `Dhaka`.

### 12. (Comparison Operators)

Find all students whose GPA is greater than `3.50`.

### 13. (BETWEEN)

Find all students whose age is between `20` and `22`.

### 14. (IN)

Find students who live in `Dhaka`, `Sylhet`, or `Khulna`.

### 15. (AND / OR)

Find students who are older than `20` **and** have a GPA greater than
`3.00`.

### 16. (NOT)

Find all students who are **not** from `Dhaka`.

### 17. (LIKE --- `%`)

Find all students whose names start with `R`.

### 18. (LIKE --- `_`)

Find all students whose second letter of their name is `a`.

---

## BOOLEAN / NULL

### 19. (BOOLEAN)

Display all students who are currently active.

### 20. (BOOLEAN + NOT)

Display all students who are **not active**.

### 21. (IS NULL)

Find all students whose email address is `NULL`.

### 22. (IS NOT NULL)

Find all students whose email address is not `NULL`.

---

## Aggregate Functions

### 23. (COUNT)

Find the total number of students.

### 24. (MAX / MIN)

Find the highest and lowest GPA among the students.

### 25. (SUM)

Find the total number of credits offered by all courses.

### 26. (AVG + COUNT + WHERE)

Find the average course fee and total number of courses whose fee is
greater than or equal to `5000`.

---

## ORDER BY / Calculated Columns

### 27. (ORDER BY)

Display all students ordered by GPA from highest to lowest.

### 28. (Calculated Column)

Display each course's name, fee, and a new column called
`fee_after_discount` where the new fee is `90%` of the original fee.

---

## DML

### 29. (UPDATE)

Change the GPA of student `101` to `3.95`.

### 30. (DELETE)

Delete the student whose `student_id` is `106`.

---

# 30 Answers

### 1.

```sql
CREATE TABLE students (
    student_id INT PRIMARY KEY,
    name VARCHAR(50),
    email VARCHAR(100),
    city VARCHAR(30),
    age INT,
    gpa DECIMAL(3,2),
    is_active BOOLEAN
);
```

### 2.

```sql
CREATE TABLE courses (
    course_id INT PRIMARY KEY,
    course_code VARCHAR(10),
    course_name VARCHAR(50),
    department VARCHAR(30),
    credits INT,
    fee DECIMAL(8,2),
    is_available BOOLEAN
);
```

### 3.

```sql
INSERT INTO students
(student_id, name, email, city, age, gpa, is_active)
VALUES
(109, 'Arif', 'arif@gmail.com', 'Dhaka', 21, 3.30, TRUE);
```

### 4.

```sql
INSERT INTO courses
(course_id, course_code, course_name, department, credits, fee, is_available)
VALUES
(9, 'CSE450', 'Cloud Computing', 'CSE', 3, 7000.00, TRUE);
```

### 5.

```sql
ALTER TABLE students
ADD phone VARCHAR(15);
```

### 6.

```sql
ALTER TABLE students
MODIFY phone VARCHAR(20);
```

### 7.

```sql
RENAME TABLE courses TO course_master;
```

After this, remember that the table is called `course_master`, not
`courses`.

### 8.

```sql
SHOW CREATE TABLE students;
```

### 9.

```sql
SELECT name, email
FROM students;
```

### 10.

```sql
SELECT DISTINCT city
FROM students;
```

### 11.

```sql
SELECT *
FROM students
WHERE city = 'Dhaka';
```

### 12.

```sql
SELECT *
FROM students
WHERE gpa > 3.50;
```

### 13.

```sql
SELECT *
FROM students
WHERE age BETWEEN 20 AND 22;
```

### 14.

```sql
SELECT *
FROM students
WHERE city IN ('Dhaka', 'Sylhet', 'Khulna');
```

### 15.

```sql
SELECT *
FROM students
WHERE age > 20
AND gpa > 3.00;
```

### 16.

```sql
SELECT *
FROM students
WHERE NOT city = 'Dhaka';
```

Alternative:

```sql
SELECT *
FROM students
WHERE city <> 'Dhaka';
```

### 17.

```sql
SELECT *
FROM students
WHERE name LIKE 'R%';
```

`%` means zero or more characters.

### 18.

```sql
SELECT *
FROM students
WHERE name LIKE '_a%';
```

`_` represents exactly one character, so `a` must be the second
character.

### 19.

```sql
SELECT *
FROM students
WHERE is_active = TRUE;
```

You can also write:

```sql
SELECT *
FROM students
WHERE is_active;
```

### 20.

```sql
SELECT *
FROM students
WHERE is_active = FALSE;
```

Or:

```sql
SELECT *
FROM students
WHERE NOT is_active;
```

### 21.

```sql
SELECT *
FROM students
WHERE email IS NULL;
```

### 22.

```sql
SELECT *
FROM students
WHERE email IS NOT NULL;
```

### 23.

```sql
SELECT COUNT(*) AS total_students
FROM students;
```

### 24.

```sql
SELECT
    MAX(gpa) AS highest_gpa,
    MIN(gpa) AS lowest_gpa
FROM students;
```

### 25.

```sql
SELECT SUM(credits) AS total_credits
FROM courses;
```

### 26.

```sql
SELECT
    AVG(fee) AS average_fee,
    COUNT(*) AS course_count
FROM courses
WHERE fee >= 5000;
```

### 27.

```sql
SELECT *
FROM students
ORDER BY gpa DESC;
```

`DESC` = highest to lowest.

For lowest to highest:

```sql
ORDER BY gpa ASC;
```

### 28.

```sql
SELECT
    course_name,
    fee,
    (fee * 0.90) AS fee_after_discount
FROM courses;
```

### 29.

```sql
UPDATE students
SET gpa = 3.95
WHERE student_id = 101;
```

### 30.

```sql
DELETE FROM students
WHERE student_id = 106;
```

---

# Topic Coverage

Topic Questions

---

`CREATE` 1--2
`INSERT` 3--4
`ALTER` 5--6
`RENAME` 7
`SHOW CREATE TABLE` 8
`SELECT` 9
`DISTINCT` 10
`WHERE` 11
Comparison operators 12
`BETWEEN` 13
`IN` 14
`AND` 15
`NOT` 16, 20
`LIKE %` 17
`LIKE _` 18
`BOOLEAN` 19--20
`IS NULL` 21
`IS NOT NULL` 22
`COUNT` 23, 26
`MAX / MIN` 24
`SUM` 25
`AVG` 26
`ORDER BY` 27
Calculated columns 28
`UPDATE` 29
`DELETE` 30

## Additional DDL Practice

These are intentionally left outside the 30 questions so you can
practice potentially destructive commands separately:

```sql
TRUNCATE TABLE students;

DROP TABLE students;

DROP TABLE course_master;
```
