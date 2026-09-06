### CHECK keyword
- checks if the tuple data is valid, 
- works in database-level
- bullet proofing

---

### What if CHECK needs to be updated?

- do, `show create table table_name`    

- see the constraint identifier for the specific CHECK, `CONSTRAINT1`  

- use alter to drop that constraint, 
```sql
ALTER TABLE table_name 
DROP CONSTRAINT constraint_name;
```
  
- finally make a new constraint 
```sql
ALTER TABLE table_name 
ADD CHECK(gotten_marks<10);
``` 
- or you can have your own constraint name
```sql
ALTER TABLE table_name
ADD CONSTRAINT no_low_marks
CHECK (gotten_marks < 10);
```

---

### Why have less inputs and more selections?

- to handle errors
- with specific tuple selection, database becomes mostly bullet proof

---

### How to protect database from sql injection?

- use prepared statements
- turn the inputs into data first and then pass on to database

--- 

### How can users see their previous marks if sec_id is updating and why do update?

- to prevent clusters, users have the freedom to select any department and semester,
- user might change department, might want to see courses of other departments, users might move around sections and will definitely move around semesters. To make the database not clustered use update.
- the marks are saved after they hit save from frontend, this passes to marks table, if the user comes back to the same sec_id, their marks are shown from marks table

### Why use TINYINT and SMALLINT?

- TINYINT uses 1 byte, range for signed(-128 to +127), for unsigned(0-255)
- SMALLINT uses 2 bytes, range for signed(-32,768 to +32768), for unsigned(0-65,535)
- Takes way less than INT, 4 bytes