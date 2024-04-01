## Installation Instructions

### 1. Install MySQL Server

Ensure that you have MySQL Server installed on your system. If not, follow the instructions provided by MySQL's official documentation: [MySQL Installation Guide](https://dev.mysql.com/doc/mysql-installation-excerpt/8.0/en/)

### 2. Create Database Schema and Table

1. Open your preferred MySQL client or command-line interface.

2. Create a new schema named `staff` by executing the following SQL command:

    ```sql
    CREATE SCHEMA IF NOT EXISTS staff;
    ```

3. Once the schema is created, create a table named `staff_info` within the `staff` schema. Use the following SQL script:

    ```sql
    CREATE TABLE IF NOT EXISTS `staff`.`staff_info` (
      `staff_id` INT NOT NULL AUTO_INCREMENT,
      `staff_user` VARCHAR(255) DEFAULT NULL,
      `staff_pass` CHAR(60) DEFAULT NULL,
      `first_name` VARCHAR(50) DEFAULT NULL,
      `last_name` VARCHAR(50) DEFAULT NULL,
      `email` VARCHAR(50) DEFAULT NULL,
      `image` LONGBLOB,
      `project` JSON DEFAULT NULL,
      PRIMARY KEY (`staff_id`),
      UNIQUE KEY `staff_id` (`staff_id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
    ```

### 3. Update Connection Settings

In the `My_sql.java` file, ensure that the IP address, username, and password specified for connecting to the MySQL server are correct. Modify these settings if necessary to match your MySQL server configuration.

### 4. Run the Application

Execute the `main.java` file to run the application. Ensure that all dependencies are installed and configured correctly.
