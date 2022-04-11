use furama;
# set sql_safe_updates = 0;
# set foreign_key_checks =0;
# delete from khach_hang
# where  khach_hang.ma_khach_hang in (select ma_khach_hang from (select distinct khach_hang.ma_khach_hang from khach_hang
# inner join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
#  where year(hop_dong.ngay_lam_hop_dong) < 2021 ) as khac_hang_co_hd);
# set foreign_key_checks =1;
# set sql_safe_updates = 1;
delete khach_hang, hop_dong, hop_dong_chi_tiet from khach_hang inner join hop_dong on khach_hang.ma_khach_hang=hop_dong.ma_khach_hang
                                                         inner join hop_dong_chi_tiet on hop_dong.ma_hop_dong-hop_dong_chi_tiet.ma_hop_dong
where not exists(select hop_dong.ma_hop_dong where year(hop_dong.ngay_lam_hop_dong)<'2021' and khach_hang.ma_khach_hang=hop_dong.ma_khach_hang);