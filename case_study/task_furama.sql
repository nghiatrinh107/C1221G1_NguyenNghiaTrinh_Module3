use furama;
-- task 2
select ma_nhan_vien,ho_ten from nhan_vien where ho_ten regexp '^[HKT]' and length(ho_ten)<=16;

-- task 3
select khach_hang.*  from khach_hang where ((datediff(now(),ngay_sinh)/365) between 18 and 50) 
and (khach_hang.dia_chi like '% Đà Nẵng%' or khach_hang.dia_chi like'% Quảng Trị%');

-- task 4
select khach_hang.ma_khach_hang, khach_hang.ho_ten, count(khach_hang.ma_khach_hang) as so_lan_dat_phong from loai_khach 
inner join khach_hang on loai_khach.ma_loai_khach = khach_hang.ma_loai_khach
inner join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
where khach_hang.ma_loai_khach = 1
group by khach_hang.ma_khach_hang
order by so_lan_dat_phong;

-- task 5
select khach_hang.ma_khach_hang, khach_hang.ho_ten, loai_khach.ten_loai_khach, hop_dong.ma_hop_dong, dich_vu.ten_dich_vu, hop_dong.ngay_lam_hop_dong, hop_dong.ngay_ket_thuc, 
sum(dich_vu.chi_phi_thue + COALESCE((dich_vu_di_kem.gia * hop_dong_chi_tiet.so_luong),0)) as tong_tien from loai_khach
inner join khach_hang on loai_khach.ma_loai_khach = khach_hang.ma_loai_khach
left join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
left join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
left join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
group by hop_dong.ma_hop_dong,khach_hang.ma_khach_hang
order by khach_hang.ma_khach_hang;

-- task 6
select dich_vu.ma_dich_vu, ten_dich_vu, dien_tich_ho_boi, chi_phi_thue, ten_loai_dich_vu from loai_dich_vu
inner join dich_vu on loai_dich_vu.ma_loai_dich_vu = dich_vu.ma_loai_dich_vu
inner join hop_dong on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
where dich_vu.ma_dich_vu not in (select hop_dong.ma_dich_vu from hop_dong where hop_dong.ngay_lam_hop_dong between '2021-01-01' and '2021-04-01')
group by dich_vu.ma_dich_vu;

-- task 7
select dich_vu.ma_dich_vu, ten_dich_vu, dien_tich_ho_boi, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu from loai_dich_vu
inner join dich_vu on loai_dich_vu.ma_loai_dich_vu = dich_vu.ma_loai_dich_vu
inner join hop_dong on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
where (dich_vu.ma_dich_vu in (select hop_dong.ma_dich_vu from hop_dong where year(hop_dong.ngay_lam_hop_dong)=2020))
and (dich_vu.ma_dich_vu not in (select hop_dong.ma_dich_vu from hop_dong where year(hop_dong.ngay_lam_hop_dong)=2021))
group by dich_vu.ma_dich_vu;

-- task 8
-- cach 1
select ho_ten from khach_hang  group by khach_hang.ho_ten;
-- cach 2
select distinct ho_ten from khach_hang;
-- cach 3
select khach_hang.ho_ten from khach_hang union select khach_hang.ho_ten from khach_hang;


