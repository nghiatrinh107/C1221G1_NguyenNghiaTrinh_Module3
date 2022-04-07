use furama;
select month(hop_dong.ngay_lam_hop_dong) as thang ,count(khach_hang.ma_khach_hang) as so_luong_khach_hang
from khach_hang inner join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
where year(hop_dong.ngay_lam_hop_dong) =2021
group by month(hop_dong.ngay_lam_hop_dong)
order by month(hop_dong.ngay_lam_hop_dong);