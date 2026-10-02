---


### Table 1: `client_master`

| Field Name | Data Type | Key Type | Description |
| :--- | :--- | :--- | :--- |
| `client_no` | `VARCHAR(6)` | Primary Key | Unique client identifier |
| `name` | `VARCHAR(50)` | - | Full name of the client |
| `city` | `VARCHAR(30)` | - | City of residence |
| `pincode` | `VARCHAR(10)` | - | Postal pin code |
| `state` | `VARCHAR(30)` | - | State of residence |
| `bal_due` | `DECIMAL(10,2)` | - | Outstanding balance amount |

#### Sample Data (`client_master`)
```sql
INSERT INTO client_master (client_no, name, city, pincode, state, bal_due) VALUES
('0001', 'Ivan', 'Bombay', '400054', 'Maharashtra', 15000.00),
('0002', 'Vandana', 'Madras', '780001', 'Tamilnadu', 0.00),
('0003', 'Pramada', 'Bombay', '400057', 'Maharashtra', 5000.00),
('0004', 'Basu', 'Bombay', '400056', 'Maharashtra', 0.00),
('0005', 'Ravi', 'Delhi', '100001', 'Maharashtra', 2000.00),
('0006', 'Rukmini', 'Bombay', '400050', 'Maharashtra', 0.00);
```

---

### Table 2: `product_master`

| Field Name       | Data Type       | Key Type    | Description                   |
| :--------------- | :-------------- | :---------- | :---------------------------- |
| `product_no`     | `VARCHAR(6)`    | Primary Key | Unique product ID             |
| `description`    | `VARCHAR(50)`   | -           | Product description/name      |
| `profit_percent` | `DECIMAL(5,2)`  | -           | Profit percentage margin      |
| `unit_measure`   | `VARCHAR(15)`   | -           | Unit of measure (e.g., Piece) |
| `qty_on_hand`    | `INT`           | -           | Available stock quantity      |
| `reorder_lvl`    | `INT`           | -           | Reorder threshold stock level |
| `sell_price`     | `DECIMAL(10,2)` | -           | Selling price per unit        |
| `cost_price`     | `DECIMAL(10,2)` | -           | Cost price per unit           |

#### Sample Data (`product_master`)

```sql
INSERT INTO product_master (product_no, description, profit_percent, unit_measure, qty_on_hand, reorder_lvl, sell_price, cost_price) VALUES
('P00001', '1.44floppies', 5.0, 'Piece', 100, 20, 525.00, 500.00),
('P03453', 'Monitors', 6.0, 'Piece', 10, 3, 12000.00, 11200.00),
('P06734', 'Mouse', 5.0, 'Piece', 20, 3, 10500.00, 500.00),
('P07865', '1.22 floppies', 5.0, 'Piece', 100, 20, 525.00, 500.00),
('P07868', 'Keyboards', 2.0, 'Piece', 10, 3, 3150.00, 3050.00),
('P07885', 'CD Drive', 2.5, 'Piece', 10, 3, 5250.00, 5100.00),
('P07965', '540 HDD', 4.0, 'Piece', 10, 3, 8400.00, 8000.00),
('P07975', '1.44 Drive', 5.0, 'Piece', 10, 3, 1050.00, 1000.00),
('P08865', '1.22 Drive', 5.0, 'Piece', 2, 3, 1050.00, 1000.00);
```

---

## 20 Practice Questions

1. **(DQL)** Find out the names of all clients from `client_master`.
2. **(DQL)** Retrieve the list of names and cities of all clients.
3. **(DQL)** List the various products available from the `product_master` table.
4. **(WHERE)** List all the clients who are located in `'Bombay'`.
5. **(WHERE)** Display the information for `client_no` `'0001'` and `'0002'`.
6. **(LIKE)** Find the products with description as `'1.44 drive'` and `'1.22 Drive'`.
7. **(Operators)** Find all products whose `sell_price` is greater than `5000`.
8. **(IN Operator)** Find all clients who stay in city `'Bombay'`, `'Delhi'`, or `'Madras'`.
9. **(AND Operator)** Find the product whose `sell_price` is greater than `2000` and less than or equal to `5000`.
10. **(NOT Operator)** List the name, city, and state of clients NOT in the state of `'Maharashtra'`.
11. **(DML Update)** Change the selling price of `'1.44 drive'` to `1150.00`.
12. **(DML Delete)** Delete the record with `client_no` `'0001'` from the `client_master` table.
13. **(DML Update)** Change the city of `client_no` `'0005'` to `'Bombay'`.
14. **(DML Update)** Change the `bal_due` of `client_no` `'0001'` to `1000`.
15. **(Calculated Column)** Find products whose selling price is more than `1500` and also find the new selling price as `(sell_price * 15)`.
16. **(Wildcard `_`)** Find out the clients who stay in a city whose second letter is `'a'`.
17. **(Wildcard `_`)** Find out the name of all clients having `'a'` as the second letter in their names.
18. **(ORDER BY)** List all the products in sorted order (`ASC`) of their description.
19. **(Aggregate)** Determine the maximum (`MAX`) and minimum (`MIN`) prices from `product_master`.
20. **(Aggregate)** Calculate the average price (`AVG`) and total count (`COUNT`) of products having price greater than or equal to `1500`.

## 20 answers

1. `SELECT name FROM client_master;`
2. `SELECT name, city FROM client_master;`
3. `SELECT description FROM product_master;`
4. `SELECT * FROM client_master WHERE city = 'Bombay';`
5. `SELECT * FROM client_master WHERE client_no IN ('0001', '0002');`
6. `SELECT * FROM product_master WHERE description IN ('1.44 Drive', '1.22 Drive');`
7. `SELECT * FROM product_master WHERE sell_price > 5000;`
8. `SELECT * FROM client_master WHERE city IN ('Bombay', 'Delhi', 'Madras');`
9. `SELECT * FROM product_master WHERE sell_price > 2000 AND sell_price <= 5000;`
10. `SELECT name, city, state FROM client_master WHERE state <> 'Maharashtra';`
11. `UPDATE product_master SET sell_price = 1150.00 WHERE description = '1.44 Drive';`
12. `DELETE FROM client_master WHERE client_no = '0001';`
13. `UPDATE client_master SET city = 'Bombay' WHERE client_no = '0005';`
14. `UPDATE client_master SET bal_due = 1000 WHERE client_no = '0001';`
15. `SELECT product_no, description, sell_price, (sell_price * 15) AS new_sell_price FROM product_master WHERE sell_price > 1500;`
16. `SELECT * FROM client_master WHERE city LIKE '_a%';`
17. `SELECT name FROM client_master WHERE name LIKE '_a%';`
18. `SELECT * FROM product_master ORDER BY description ASC;`
19. `SELECT MAX(sell_price) AS max_price, MIN(sell_price) AS min_price FROM product_master;`
20. `SELECT AVG(sell_price) AS avg_price, COUNT(*) AS product_count FROM product_master WHERE sell_price >= 1500;`
