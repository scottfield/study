-- auto-generated definition
CREATE TABLE students
(
  stud_id INT AUTO_INCREMENT
    PRIMARY KEY,
  name    VARCHAR(50) NOT NULL,
  email   VARCHAR(50) NOT NULL,
  dob     DATE        NULL
);