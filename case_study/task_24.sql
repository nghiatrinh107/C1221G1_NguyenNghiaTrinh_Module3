use furama;
DELIMITER //
DROP PROCEDURE IF EXISTS sp_them_moi_hop_dong //
CREATE PROCEDURE sp_them_moi_hop_dong(in ma_hop_dong int, in ma_nhan_vien int, in ma_khach_hang int, in ma_dich_vu int,
                                      in ngay_lam_hop_dong DATE, in ngay_ket_thuc DATE, in tien_dat_coc INT
                                      )
BEGIN
set @x = (select count(ma_hop_dong)
          from hop_dong
          where hop_dong.ma_hop_dong = ma_hop_dong
          group by hop_dong.ma_hop_dong);
IF((@x is null)
    AND(select ma_nhan_vien from nhan_vien where nhan_vien.ma_nhan_vien=ma_nhan_vien)
    AND (select ma_khach_hang from khach_hang where khach_hang.ma_khach_hang=ma_khach_hang)
    AND (select ma_dich_vu from dich_vu where dich_vu.ma_dich_vu = ma_dich_vu)
    AND (ngay_ket_thuc>ngay_lam_hop_dong))
then
INSERT INTO hop_dong
VALUES (ma_hop_dong, ma_nhan_vien, ma_khach_hang, ma_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc,tien_dat_coc);
ELSE
SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Dữ liệu sai ';
End if;
 END //
DELIMITER ;