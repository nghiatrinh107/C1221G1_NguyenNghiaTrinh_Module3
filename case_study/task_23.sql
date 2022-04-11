use furama;
delimiter //
create procedure sp_xoa_khach_hang (in ma_khach_hang int)
begin
    delete khach_hang from khach_hang where khach_hang.ma_khach_hang =ma_khach_hang;
end //
delimiter ;
call sp_xoa_khach_hang(9);