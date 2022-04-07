use furama;
select dich_vu_di_kem.* from dich_vu_di_kem
inner join hop_dong_chi_tiet on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
inner join hop_dong  on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
inner join khach_hang  on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
inner join loai_khach  on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
where (loai_khach.ten_loai_khach = 'Diamond') and
    (khach_hang.dia_chi like '% Vinh%' or khach_hang.dia_chi like'% Quảng Ngãi%')
group by dich_vu_di_kem.ma_dich_vu_di_kem
order by dich_vu_di_kem.ma_dich_vu_di_kem;
