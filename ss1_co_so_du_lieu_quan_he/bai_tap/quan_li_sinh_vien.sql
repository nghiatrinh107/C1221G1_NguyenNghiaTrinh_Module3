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
insert  into class
(nameClass,anount)
values
("C1221G1",41),
("C0222G1",48),
("C0221G2",45),
("C0322G1",43);