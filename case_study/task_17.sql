use furama;
set sql_safe_updates =0;
update khach_hang, (select distinct khach_hang.ma_khach_hang
from loai_khach inner join khach_hang on loai_khach.ma_loai_khach = khach_hang.ma_loai_khach
    left join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
    left join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
    left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
    left join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
where year(hop_dong.ngay_lam_hop_dong) =2021
group by hop_dong.ma_hop_dong
having sum(dich_vu.chi_phi_thue + COALESCE((dich_vu_di_kem.gia * hop_dong_chi_tiet.so_luong),0)) >10000000) as tong_tien_2021
set khach_hang.ma_loai_khach = 1
where khach_hang.ma_loai_khach = 2 and khach_hang.ma_khach_hang = tong_tien_2021.ma_khach_hang;
set sql_safe_updates =1;