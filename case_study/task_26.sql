use furama;
delimiter //
DROP TRIGGER IF EXISTS tr_cap_nhat_hop_dong //
create trigger tr_cap_nhat_hop_dong after update on hop_dong for each row
    begin
    IF DATEDIFF(new.ngay_ket_thuc,old.ngay_lam_hop_dong)<2 THEN
   SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày';
      end if;
end; //
delimiter ;
UPDATE furama. hop_dong SET ngay_ket_thuc = '2020-12-29' WHERE (ma_hop_dong = '3');