use furama;
#task 2
select ma_nhan_vien,ho_ten from nhan_vien where ho_ten regexp '^[HKT]' and length(ho_ten)<=16;
# task 3
select khach_hang.*  from khach_hang where ((datediff(now(),ngay_sinh)/365) between 18 and 50) 
and (khach_hang.dia_chi like '% Đà Nẵng%' or khach_hang.dia_chi like'% Quảng Trị%');
# task 4
select khach_hang.ma_khach_hang, khach_hang.ho_ten, count(khach_hang.ma_khach_hang) as so_lan_dat_phong from loai_khach 
inner join khach_hang on loai_khach.ma_loai_khach = khach_hang.ma_loai_khach
inner join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
where khach_hang.ma_loai_khach = 1
group by khach_hang.ma_khach_hang
order by so_lan_dat_phong;
# task 5
select ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tong_tien 