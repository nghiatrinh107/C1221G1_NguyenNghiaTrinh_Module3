create database quan_li_ban_hang;
use quan_li_ban_hang;
create table customer(
customer_id int auto_increment primary key,
customer_name varchar(50),
customer_day_of_birth date
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
