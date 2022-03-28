create database `student-managements`;
use `student-managements`;
create table `class`(
id int auto_increment primary key,
nameClass varchar(45),
anount int
);
create table teacher(
id int auto_increment primary key,
nameStudent varchar(45),
age int,
country varchar(45));