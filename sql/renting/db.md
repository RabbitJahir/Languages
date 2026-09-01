# Room Rental Database — `db.md`

# 1. `user_account`

Stores all users who use the system.

A user is a general account. The account itself does not determine whether the person is an owner, tenant, or administrator.

### Attributes

| Attribute | Key / Constraint | Description |
|---|---|---|
| `user_id` | PK, AUTO_INCREMENT | Unique ID of the user. |
| `full_name` | NOT NULL | Full name of the user. |
| `mobile` | UNIQUE, NOT NULL | Mobile number used for contact and potentially verification. |
| `email` | UNIQUE | User's email address. |
| `password_hash` | NOT NULL | Securely hashed password used for authentication. |



# 2. `role`

Defines the different roles a user can have.

### Attributes

| Attribute | Key / Constraint | Description |
|---|---|---|
| `role_id` | PK, AUTO_INCREMENT | Unique ID of the role. |
| `role_name` | UNIQUE, NOT NULL | Name of the role, such as `Owner`, `Tenant`, or `Admin`. |


---

# 3. `user_role`

Connects users with their roles.

The many-to-many relationship is implemented through `user_role`.

This table answers the question:

> "What role does this user have?"

A person can have multiple roles.

### Attributes

| Attribute | Key / Constraint | Description |
|---|---|---|
| `user_id` | PK, FK → `user_account.user_id` | Identifies the user. |
| `role_id` | PK, FK → `role.role_id` | Identifies the user's role. |

The combined primary key:

```text
(user_id, role_id)
```

prevents assigning the same role to the same user twice.

---

# 4. `building`

Stores building/property-level information.

A building is owned or listed by a user.

### Attributes

| Attribute | Key / Constraint | Description |
|---|---|---|
| `building_id` | PK, AUTO_INCREMENT | Unique ID of the building. |
| `owner_id` | FK → `user_account.user_id` | Identifies the owner/listing user. |
| `area_name` | NOT NULL | General area or district. |
| `local_name` | — | Local/common name of the location. |
| `local_attribute` | — | Additional location information or nearby landmark information. |
| `formal_address` | NOT NULL | Full formal address of the building. |
| `contact_number` | — | Contact number associated with the property/listing. |
| `has_lift` | DEFAULT TRUE | Indicates whether the building has a lift. |


---

# 5. `room`

Stores an individual rentable room.

Room-specific information belongs here instead of in `building`.

### Attributes

| Attribute | Key / Constraint | Description |
|---|---|---|
| `room_id` | PK, AUTO_INCREMENT | Unique ID of the room. |
| `building_id` | FK → `building.building_id` | Identifies the building containing the room. |
| `room_number` | — | Room number/name. |
| `floor` | NOT NULL | Floor where the room is located. |
| `price` | NOT NULL | Monthly rental price. |
| `status` | DEFAULT `Available` | Current room state: `Available`, `Pending`, or `Rented`. |
| `bachelor_allowed` | DEFAULT TRUE | Whether bachelors are allowed. |
| `family_allowed` | DEFAULT FALSE | Whether families are allowed. |
| `negotiable` | DEFAULT TRUE | Whether the rental price can be negotiated. |
| `other_rules` | — | Additional rental rules. |


---

# 6. `facility`

Contains the master list of facilities supported by the system.

Examples:

```text
Parking
Generator
Security
WiFi
Gas
Water
Electricity
Lift
Rooftop
```

### Attributes

| Attribute | Key / Constraint | Description |
|---|---|---|
| `facility_id` | PK, AUTO_INCREMENT | Unique facility ID. |
| `facility_name` | UNIQUE, NOT NULL | Name of the facility. |
| `description` | — | Explanation of the facility. |

---

# 7. `building_facility`

Connects buildings and facilities.

This is necessary because:

```text
One building -> many facilities
One facility -> many buildings
```


### Attributes

| Attribute | Key / Constraint | Description |
|---|---|---|
| `building_id` | PK, FK | Identifies the building. |
| `facility_id` | PK, FK | Identifies the facility. |


---

# 8. `room_facility`

Connects rooms and facilities.

Useful when a facility specifically belongs to an individual room.

For example:

```text
Room 101
    ├── Attached Bathroom
    ├── Balcony
    └── Air Conditioning
```

### Attributes

| Attribute | Key / Constraint | Description |
|---|---|---|
| `room_id` | PK, FK | Identifies the room. |
| `facility_id` | PK, FK | Identifies the facility. |

---

# 9. `room_images`

Stores image metadata for rooms.

The actual image is stored outside the database.

### Attributes

| Attribute | Key / Constraint | Description |
|---|---|---|
| `image_id` | PK, AUTO_INCREMENT | Unique ID of the image record. |
| `room_id` | FK → `room.room_id` | Identifies the room. |
| `image_path` | NOT NULL | Path or URL where the image is stored. |
| `is_primary` | DEFAULT FALSE | Identifies the main/cover image. |

---

# 10. `rental`

Stores actual rental agreements.

This table answers:

> "Who is currently renting this room?"

### Attributes

| Attribute | Key / Constraint | Description |
|---|---|---|
| `rental_id` | PK, AUTO_INCREMENT | Unique rental record ID. |
| `room_id` | FK → `room.room_id` | Room being rented. |
| `tenant_id` | FK → `user_account.user_id` | User renting the room. |
| `start_date` | NOT NULL | Date the rental starts. |
| `end_date` | — | Date the rental ends. NULL while active. |
| `monthly_rent` | NOT NULL | Agreed monthly rent. |
| `status` | DEFAULT `Active` | Rental state: `Active`, `Completed`, or `Cancelled`. |

### Connections

```text
room 1 : N rental
user_account 1 : N rental
```

### Determining the tenant

```text
rental.tenant_id
       │
       ▼
user_account.user_id
       │
       ▼
user_role
       │
       ▼
role = Tenant
```

---

# 11. `user_documents`

Stores optional identity-verification document information.

### Attributes

| Attribute | Key / Constraint | Description |
|---|---|---|
| `document_id` | PK, AUTO_INCREMENT | Unique document record ID. |
| `user_id` | FK → `user_account.user_id` | User who provided the document. |
| `document_type` | NOT NULL | `NID` or `Passport`. |
| `document_path` | NOT NULL | Secure path/URL to the document. |

### Connection

```text
user_account 1 : N user_documents
```

---

# Complete Schema

```text
                         ┌──────────────────┐
                         │   user_account   │
                         │                  │
                         │ PK user_id       │
                         └────────┬─────────┘
                                  │
                    ┌─────────────┼──────────────┐
                    │             │              │
                    ▼             ▼              ▼
              ┌──────────┐  ┌──────────┐  ┌───────────────┐
              │ user_role│  │ building │  │user_documents │
              └────┬─────┘  └────┬─────┘  └───────────────┘
                   │             │
                   ▼             │
              ┌──────────┐       │
              │   role   │       │
              └──────────┘       │
                                 ▼
                              ┌──────┐
                              │ room │
                              └──┬───┘
                                 │
                     ┌───────────┼────────────┐
                     │           │            │
                     ▼           ▼            ▼
               room_images  room_facility  rental
                                  │            │
                                  │            │
                                  ▼            ▼
                               facility    user_account
                                  ▲
                                  │
                           building_facility
                                  ▲
                                  │
                               building
```

# How Owner and Tenant Are Identified

There are two levels to this design.

## 1. Role

`user_role` tells us what a user is allowed to be:

```text
User #1 → Owner
User #2 → Tenant
User #3 → Owner + Tenant
User #4 → Admin
```

## 2. Relationship

The actual records tell us what the user is doing.

For ownership:

```text
building.owner_id → user_account.user_id
```

For renting:

```text
rental.tenant_id → user_account.user_id
```

Therefore, roles and relationships have different purposes.

```text
ROLE
"What type of user is this?"

RELATIONSHIP
"What is this user doing with this particular record?"
```

This is why simply adding:

```text
user_type = Owner/Tenant
```

to `user_account` is less flexible. A person may own one property while also renting another property.

---

# Example

Suppose:

```text
user_account

user_id | full_name
--------+-----------
1       | Rahim
2       | Karim
```

```text
user_role

user_id | role_id
--------+--------
1       | Owner
2       | Tenant
```

Then:

```text
building

building_id | owner_id
------------+---------
10          | 1
```

means:

```text
Rahim owns Building #10.
```

And:

```text
rental

rental_id | room_id | tenant_id
----------+---------+-----------
50        | 100     | 2
```

means:

```text
Karim rents Room #100.
```

The database can therefore answer:

```text
Who owns Building #10?
→ Rahim

Who rents Room #100?
→ Karim

Is Rahim an Owner?
→ Yes

Is Karim a Tenant?
→ Yes
```

---

# Current Tables

1. `user_account`
2. `role`
3. `user_role`
4. `building`
5. `room`
6. `facility`
7. `building_facility`
8. `room_facility`
9. `room_images`
10. `rental`
11. `user_documents`
