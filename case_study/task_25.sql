use furama;
delimiter //
DROP TRIGGER IF EXISTS tr_xoa_hop_dong  //
CREATE TRIGGER tr_xoa_hop_dong AFTER DELETE on hop_dong for each row
begin
    SET @x = (select count(*) as count from hop_dong );
end //
delimiter ;
SET @x = 0;
delete from hop_dong where hop_dong.ma_hop_dong = 10;
SELECT @x AS 'Total amount deleted';