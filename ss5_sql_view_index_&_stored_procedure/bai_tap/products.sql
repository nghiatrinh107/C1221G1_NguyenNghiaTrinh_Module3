create database products;
use products;
create table product (
    id int auto_increment primary key ,
    product_code varchar(55),
    product_name varchar(55),
    product_price double,
    product_amount int,
    product_description varchar(100),
    product_status bit
);
insert into product (product_code, product_name, product_price, product_amount, product_description, product_status)
values
('sp001','bánh',500000,50,'bánh nhập khẩu',1),
('sp002','kẹo',100000,0,'kẹo nhập khẩu',0),
('sp003','kem',500000,70,'kem nhập khẩu',1),
('sp004','thuốc lá',500000,100,'thuốc lá',1),
('sp005','nước ép',200000,0,'nước ép nhập khẩu',0),
('sp006','nước ngọt',10000,50,'coca',1),
('sp007','sữa',30000,20,'TH',1);

create unique index product_code_idx on product (product_code);

create index product_idx on product (product_name,product_price);

explain select * from product where (product_name like 'nước%' and product_price = 10000);
explain select * from product where product_code = 'sp003';

create view product_view as select product_code,product_name,product_price,product_status from product;

create or replace view  product_view as
select product_code,product_name,product_price
from product;

drop view products.product_view;
 delimiter //
 create procedure display_product()
 begin
     select * from product;
 end //
 delimiter ;
 call display_product();

delimiter //
create procedure add_product(code varchar(55),name varchar(55),price double,
amount int,description varchar(100),status bit)
begin
    insert into product(product_code, product_name, product_price, product_amount, product_description, product_status)
    values (code,name,price,amount,description,status);
end //
delimiter ;

call add_product('sp008','nước mía',15000,80,'nước mía đóng chai',1);

delimiter //
create procedure delete_product (id_product int)
begin
    delete from product where id = id_product;
end //
delimiter ;

call delete_product(5);

delimiter //
create procedure update_amount_and_status(id_product int ,amount int)
begin
    update product set product_amount =amount where id = id_product ;
end //
delimiter ;

call update_amount_and_status(4,80);