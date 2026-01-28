# Assignment 1

CREATE DATABASE school_mgmt;
USE school_mgmt;

CREATE TABLE Student (
sId INT,
name varchar(120),
major varchar(10),
PRIMARY KEY(sId)
);

INSERT INTO Student (sId, name, major) VALUES
(101, 'Alice Johnson', 'CS'),
(102, 'Bob Smith', 'Math'),
(103, 'Charlie Davis', 'Physics'),
(104, 'Diana Prince', 'Biology'),
(105, 'Edward Norton', 'CS');

Select \* from Student;

CREATE TABLE Enrolled (
cId INT,
sId INT,
PRIMARY KEY (cId, sId),
FOREIGN KEY (sId) REFERENCES Student(sId)
);

INSERT INTO Enrolled (cId, sId) VALUES
(201, 101), -- Alice in CS 201
(201, 105), -- Edward in CS 201
(202, 102), -- Bob in Math 202
(203, 103), -- Charlie in Physics 203
(201, 104); -- Diana in CS 201

Select \* from Enrolled;

Select Name, cId from Student, Enrolled where Student.sId = Enrolled.sId;

Create Table Laptop(
model INT,
speed DECIMAL(3,2),
ram INT,
hd INT,
screen DECIMAL(3,1),
price DECIMAL(10,2),
PRIMARY KEY (model),
FOREIGN KEY (model) references Product(model)
);

CREATE TABLE Printer (
model INT PRIMARY KEY,
color BOOLEAN,
type VARCHAR(20) CHECK (type IN ('laser', 'ink-jet')),
price DECIMAL(10, 2),
FOREIGN KEY (model) REFERENCES Product(model)
);

ALTER Table Printer
DROP column color;

ALTER TABLE Laptop
ADD od VARCHAR(50) DEFAULT 'none';
