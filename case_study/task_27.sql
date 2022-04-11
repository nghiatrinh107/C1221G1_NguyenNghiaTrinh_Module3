use furama;
delimiter //
DROP Function IF EXISTS func_dem_dich_vu //
CREATE function func_dem_dich_vu() RETURNS INT
    DETERMINISTIC
BEGIN
    CREATE TEMPORARY TABLE temp
        (select count(distinct ma_dich_vu)
         from hop_dong
         where ma_dich_vu in (select distinct ma_dich_vu from hop_dong)
         group by ma_dich_vu
         having sum(tong_tien) > 2000000);
    set @tong_so_dich_vu = (select count(*) from temp);
    DROP temporary TABLE temp;
    RETURN @tong_so_dich_vu;
END;
select func_dem_dich_vu() as "số lượng dịch vụ có tổng tiền trên 2000000";

delimiter //
DROP Function IF EXISTS func_tinh_thoi_gian_hop_dong //
CREATE FUNCTION func_tinh_thoi_gian_hop_dong(ma_khach_hang int) RETURNS INT
    DETERMINISTIC
BEGIN
    set @time_dai_nhat = (SELECT MAX(DATEDIFF(hop_dong.ngay_ket_thuc, hop_dong - ngay_lam_hop_dong))
                          FROM hop_dong
                          where hop_dong.ma_khach_hang = ma_khach_hang);
    RETURN @time_dai_nhat;
END;
select func_tinh_thoi_gian_hop_dong(4) as "thời gian dài nhất";