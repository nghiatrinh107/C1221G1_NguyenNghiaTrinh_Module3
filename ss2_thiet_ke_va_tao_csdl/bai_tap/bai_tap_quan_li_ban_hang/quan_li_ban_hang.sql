create database quan_li_ban_hang;
use quan_li_ban_hang;
create table customer(
customer_id int auto_increment primary key,
customer_name varchar(50),
customer_age int
);
create table `order`(
order_id int auto_increment primary key,
customer_id int,
order_date date,
order_total_price double,
foreign key (customer_id) references customer(customer_id)
);
create table product(
product_id int auto_increment primary key,
product_name varchar(50),
product_price double
);
create table order_detail(
order_id int,
product_id int,
od_qty varchar(100),
foreign key (order_id) references `order`(order_id),
foreign key (product_id) references product(product_id)
);
insert into quan_li_ban_hang.customer (customer_name,customer_age)
values
('Minh Quan',10),
('Ngoc Oanh',20),
('Hong Ha',50);
insert into quan_li_ban_hang.`order` (customer_id,order_date)
values
(1,'2006-03-21'),(2,'2006-03-23'),(1,'2006-03-16');
insert into quan_li_ban_hang.product (product_name,product_price)
values
('May Giat',3),('Tu Lanh',5),('Dieu Hoa',7),('Quat',1),('Bep Dien',2);
insert into quan_li_ban_hang.order_detail 
values
(1,1,'3'),(1,3,'7'),(1,4,'2'),(2,1,'1'),(3,1,'8'),(2,5,'4'),(2,3,'3');
SELECT order_id,order_date,order_total_price FROM quan_li_ban_hang.order;
select customer_name,product_name from