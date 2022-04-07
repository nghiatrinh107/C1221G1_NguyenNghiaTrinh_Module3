use furama;
select dich_vu_di_kem.ma_dich_vu_di_kem,dich_vu_di_kem.ten_dich_vu_di_kem,sum(hop_dong_chi_tiet.so_luong) as so_luong_dich_vu_di_kem
from dich_vu_di_kem inner join hop_dong_chi_tiet on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
group by hop_dong_chi_tiet.ma_dich_vu_di_kem
having so_luong_dich_vu_di_kem = (select sum(hop_dong_chi_tiet.so_luong)from hop_dong_chi_tiet
group by hop_dong_chi_tiet.ma_dich_vu_di_kem order by hop_dong_chi_tiet.ma_dich_vu_di_kem desc limit 1);