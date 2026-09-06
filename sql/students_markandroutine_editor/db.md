# Mark Saver & Routine Editor — DBMS Project

## Tables & Schema Structure


### 1. `students_account`

Stores core student authentication and profile information.

- **`db_id`**: Primary Key (PK)
- **`std_id`**: Unique Student Identifier
- **`name`**: Student full name
- **`email`**: Email address (Unique constraint)
- **`password`**: Account password

---

### 2. `departments`

Stores department names and IDs.

- **`dep_id`**: Primary Key (PK)
- **`name`**: Department name (Unique)

---

### 3. `semesters`

Stores semesters (1–8) and their IDs.

- **`sem_id`**: Primary Key (PK)
- **`sems`**: Semester number

---

<!-- made sections to use later in current section -->
### 4. `sections`

Defines specific class sections and links them to departments and semesters.

- **`sec_name`**: Primary Key (PK)
- **`section`**: Section name (A–D)
- **`dep_id`**: Foreign Key (FK) references `departments(dep_id)`
- **`sem_id`**: Foreign Key (FK) references `semesters(sem_id)`

**Unique constraint:**
- `section`, `dep_id`, and `sem_id` together must be unique.

---

<!-- Made current_section because it is easier to just hover over numbers and see sections, such as (CSE1A. CSE5B) -->
### 4. `current_section`

Defines specific class sections and links them to departments and semesters.

- **`sec_id`**: Primary Key (PK)
- **`sec_name`**: Section name (FK) references `student_section(sec_name)`


---

<!-- students select their dep, semester and section from frontend, get assigned a sec_id from current_section from sections -->
### 5. `students_sections`

Junction table establishing a many-to-many relationship between students and sections.

- **`std_id`**: Foreign Key (FK) references `students_account(std_id)`
- **`sec_id`**: Foreign Key (FK) references `sections(sec_id)`
- **Primary Key**: (`std_id`, `sec_id`)

---

<!-- fixed -->
### 6. `courses`

Stores details of all courses offered by the university.

- **`course_id`**: Primary Key (PK)
- **`course_code`**: Unique course code
- **`course_name`**: Course title
- **`credit`**: Credits

---

### 7. `rooms`

Stores classroom and room details.

- **`room_id`**: Primary Key (PK)
- **`room_no`**: Unique room number
- **`room_name`**: Room name or designation

---

### 8. `teachers`

Stores faculty and instructor information.

- **`teacher_id`**: Primary Key (PK)
- **`initial`**:  Unique teacher identifier
- **`full_name`**: Teacher full name 
- **`dep_id`**: from departments(dep_id)

---

### 9. `exam_type`

stores the types of exams

- **`exam_type_id`**: Primary Key (PK)
- **`exam_type`**: Types of exams

---

### 10. `marks`

Stores individual student assessment and examination scores.

- **`mark_id`**: Primary Key (PK)
- **`std_id`**: Foreign Key (FK) references `students_account(std_id)`
- **`sec_id`**: Foreign Key (FK) references `current_section(sec_id)`
- **`course_id`**: Foreign Key (FK) references `courses(course_id)`
- **`exam_type`**: Type of assessment (Midterm, Final, Quiz, Assignment, etc.)
- **`total_marks`**: Maximum possible marks
- **`gotten_marks`**: Marks obtained by the student

**Constraints:**
- `total_marks` must be greater than 0.
- `gotten_marks` must be between 0 and `total_marks`.
- A student cannot have duplicate records for the same section, course, and exam type.

---

### 11. `routine`

Manages course scheduling and timetable information.

- **`routine_id`** Primary Key (PK)
- **`sec_id`**: Foreign Key (FK) references `current_section(sec_id)`
- **`course_id`**: Foreign Key (FK) references `courses(course_id)`
- **`room_id`**: Foreign Key (FK) references `rooms(room_id)`
- **`teacher_id`**: Foreign Key (FK) references `teachers(teacher_id)`
- **`start_time`**: Scheduled time slot
- **`end_time`**: For easier frontend managing

---

# Entity-Relationship Summary Table

| Table Name | Attributes | Primary Key (PK) | Foreign Keys (FK) |
| :--- | :--- | :--- | :--- |
| **`students_account`** | `db_id`, `std_id`, `name`, `email`, `password` | `db_id` | - |
| **`departments`** | `dep_id`, `name` | `dep_id` | - |
| **`semesters`** | `sem_id`, `sems` | `sem_id` | - |
| **`sections`** | `sec_name`, `section`, `dep_id`, `sem_id` | `sec_name` | `dep_id`, `sem_id` |
| **`current_section`** | `sec_id`, `sec_name` | `sec_id` | `sec_name` | 
| **`students_sections`** | `std_id`, `sec_id` | (`std_id`) | `std_id`, `sec_id` |
| **`courses`** | `course_id`, `course_code`, `course_name`, `credit` | `course_id` | - |
| **`rooms`** | `room_id`, `room_no`, `room_name` | `room_id` | - |
| **`teachers`** | `teacher_id`, `initial`, `full_name`, `dep_id` | `teacher_id` | `dep_id` |
| **`marks`** | `mark_id`, `std_id`, `sec_id`, `course_id`, `exam_type`, `total_marks`, `gotten_marks` | `mark_id` | `std_id`, `sec_id`, `course_id` |
| **`routine`** | `routine_id`, `sec_id`, `course_id`, `room_id`, `teacher_id`, `start_time`, `end_time` | `routine_id` | `sec_id`, `course_id`, `room_id`, `teacher_id` |

---


## EXPLANATION

### Starting with students_account
- students will register/login from here, the student id will be checked from the frontend 
- the tuple will be inserted during register whilst checking the attributes
- while logging in the std_id or email will be matched with password from db

### departments
- fixed departments, so using dep_id, easier and efficient
- can easily see the dep_name by hovering

### semesters
- used 8 id for 8 semesters and 9 for special students
- easier to search and see 

### sections
- section names are mainly created here
- will take users dep_id, sem_id and section(A,B,C,D), match with the fixed names (CSE3A, CSE5B) and insert values 

### current_section
- for efficient and easier writing and managing, used sec_id for sec_name
- plus they are fixed

### students_sections

- where the std_id are stored along with sec_id
- every time the student updates their semester, this id will be updated not add a new sec_id, to handle cluster and easier handling,  

### courses
- used course_id

### rooms
- fixed rooms, select room number(room_no) and update routine

### teachers
- used teacher_id for efficiency

### marks

- this is where the sec_id is permanently stored, after the student saves their marks from frontend

### routine
- this is where the id's will come in handy
