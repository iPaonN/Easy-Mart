## Installation

1.) Install MYSQL server.
2.) Create Schema name staff and table staff_info :
```sql
  CREATE SCHEMA staff;
    CREATE TABLE `staff_info` (
    `staff_id` int NOT NULL AUTO_INCREMENT,
    `staff_user` varchar(255) DEFAULT NULL,
    `staff_pass` char(60) DEFAULT NULL,
    `first_name` varchar(50) DEFAULT NULL,
    `last_name` varchar(50) DEFAULT NULL,
    `email` varchar(50) DEFAULT NULL,
    `image` longblob,
    `project` json DEFAULT NULL,
    PRIMARY KEY (`staff_id`),
    UNIQUE KEY `staff_id` (`staff_id`)
  ) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
```
3.) Run main.java
