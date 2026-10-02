# Room Rental Database — `creating_tables.md`

## 1. `user_account`

Stores all users.

```sql
CREATE TABLE user_account (
    user_id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    full_name VARCHAR(100) NOT NULL,
    mobile CHAR(13) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE,
    password_hash VARCHAR(255) NOT NULL
);
```

## 2. `role`

Defines the types of users that can exist in the system.

```sql
CREATE TABLE role (
    role_id TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    role_name CHAR(6) UNIQUE NOT NULL
);
```

Example roles:

```sql
INSERT INTO role (role_name)
VALUES
    ('Owner'),
    ('Tenant'),
    ('Admin');
```

## 3. `user_role`

Connects users to their roles.

A user can have more than one role. For example, the same person may be both an Owner and a Tenant.

```sql
CREATE TABLE user_role (
    user_id INT UNSIGNED NOT NULL,
    role_id TINYINT UNSIGNED NOT NULL,

    PRIMARY KEY (user_id, role_id),

    FOREIGN KEY (user_id)
        REFERENCES user_account(user_id)
        ON DELETE CASCADE,

    FOREIGN KEY (role_id)
        REFERENCES role(role_id)
        ON DELETE CASCADE
);
```

## 4. `building`

Stores building/property-level information.

`owner_id` identifies the user who owns/lists the building.

```sql
CREATE TABLE building (
    building_id INT PRIMARY KEY UNSIGNED AUTO_INCREMENT,

    owner_id INT UNSIGNED NOT NULL,

    area_name NVARCHAR(50) NOT NULL,
    local_name NVARCHAR(50),
    local_attribute NVARCHAR(100),
    formal_address NVARCHAR(255) NOT NULL,
    contact_numbers JSON CHECK (JSON_VALID(contact_numbers)),

    has_lift BOOLEAN DEFAULT TRUE,

    FOREIGN KEY (owner_id)
        REFERENCES user_account(user_id)
);
```

## 5. `room`

Stores individual rentable rooms inside a building.

```sql
CREATE TABLE room (
    room_id INT PRIMARY KEY UNSIGNED AUTO_INCREMENT,

    building_id INT UNSIGNED NOT NULL,

    room_number CHAR(5),
    floor TINYINT UNSIGNED NOT NULL,

    price DECIMAL(10,2) NOT NULL,

    status ENUM(
        'Available',
        'Pending',
        'Rented'
    ) DEFAULT 'Available',

    bachelor_allowed BOOLEAN DEFAULT TRUE,
    family_allowed BOOLEAN DEFAULT FALSE,

    negotiable BOOLEAN DEFAULT TRUE,

    other_rules NVARCHAR(500),

    FOREIGN KEY (building_id)
        REFERENCES building(building_id)
        ON DELETE CASCADE
);
```

## 6. `facility`

Contains the master and initial lists of facilities supported by the application.

```sql
CREATE TABLE facility (
    facility_id SMALLINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    facility_name NVARCHAR(50) UNIQUE NOT NULL,
    description VARCHAR(255)
);
```

Example:

```sql
INSERT INTO facility (facility_name, description)
VALUES
    ('Parking', 'Parking space is available'),
    ('Generator', 'Backup generator available'),
    ('Security', 'Security service available'),
    ('WiFi', 'Internet/WiFi available'),
    ('Gas', 'Gas connection available'),
    ('Water', 'Water supply available'),
    ('Electricity', 'Electricity connection available'),
    ('Lift', 'Elevator/lift available'),
    ('Rooftop', 'Rooftop access available');
```

## 7. `building_facility`

Connects buildings with facilities.

A building can have many facilities, and a facility can exist in many buildings.

```sql
CREATE TABLE building_facility (
    building_id INT NOT NULL,
    facility_id SMALLINT UNSIGNED NOT NULL,

    PRIMARY KEY (building_id, facility_id),

    FOREIGN KEY (building_id)
        REFERENCES building(building_id)
        ON DELETE CASCADE,

    FOREIGN KEY (facility_id)
        REFERENCES facility(facility_id)
        ON DELETE CASCADE
);
```

## 8. `room_facility`

Connects individual rooms with room-specific facilities.

This is useful when a facility applies to a room rather than the entire building.

```sql
CREATE TABLE room_facility (
    room_id INT NOT NULL,
    facility_id SMALLINT UNSIGNED NOT NULL,

    PRIMARY KEY (room_id, facility_id),

    FOREIGN KEY (room_id)
        REFERENCES room(room_id)
        ON DELETE CASCADE,

    FOREIGN KEY (facility_id)
        REFERENCES facility(facility_id)
        ON DELETE CASCADE
);
```

## 9. `room_images`

Stores paths/URLs for room images. The actual image files are stored outside the database.

```sql
CREATE TABLE room_images (
    image_id INT PRIMARY KEY AUTO_INCREMENT,

    room_id INT NOT NULL,

    image_path VARCHAR(500) NOT NULL,

    is_primary BOOLEAN DEFAULT FALSE,

    FOREIGN KEY (room_id)
        REFERENCES room(room_id)
        ON DELETE CASCADE
);
```

## 10. `rental`

Stores actual rental agreements.

`tenant_id` identifies the user who rented the room.

```sql
CREATE TABLE rental (
    rental_id INT PRIMARY KEY UNSIGNED AUTO_INCREMENT,

    room_id INT UNSIGNED NOT NULL,
    tenant_id INT UNSIGNED NOT NULL,

    start_date DATE NOT NULL,
    end_date DATE,

    monthly_rent DECIMAL(10,2) NOT NULL,

    status ENUM(
        'Active',
        'Completed',
        'Cancelled'
    ) DEFAULT 'Active',

    FOREIGN KEY (room_id)
        REFERENCES room(room_id),

    FOREIGN KEY (tenant_id)
        REFERENCES user_account(user_id)
);
```

## 11. `user_documents`

Stores optional identity-verification document paths.

```sql
CREATE TABLE user_documents (
    document_id INT PRIMARY KEY AUTO_INCREMENT,

    user_id INT NOT NULL,

    document_type ENUM(
        'NID',
        'Passport'
    ) NOT NULL,

    document_path VARCHAR(500) NOT NULL,

    FOREIGN KEY (user_id)
        REFERENCES user_account(user_id)
        ON DELETE CASCADE
);
```

---

# Relationship Overview
