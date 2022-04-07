use furama;
select hop_dong.ma_hop_dong,nhan_vien.ho_ten,khach_hang.ho_ten,khach_hang.so_dien_thoai,dich_vu.ten_dich_vu,
       sum(coalesce(hop_dong_chi_tiet.so_luong,0)) as so_luong_dich_vu_di_kem,hop_dong.tien_dat_coc
from nhan_vien inner join hop_dong on nhan_vien.ma_nhan_vien = hop_dong.ma_nhan_vien
inner join khach_hang on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
inner join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
where (hop_dong.ma_dich_vu in (select hop_dong.ma_dich_vu from hop_dong where hop_dong.ngay_lam_hop_dong between '2020-10-01'and '2020-12-31'))
and (hop_dong.ma_dich_vu not in (select hop_dong.ma_dich_vu from hop_dong where hop_dong.ngay_lam_hop_dong between '2021-01-01'and '2021-06-30'))
group by hop_dong.ma_hop_dong;