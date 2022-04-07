use furama;
create view v_nhan_vien as
select nhan_vien.*
from nhan_vien
where nhan_vien.ma_nhan_vien in (select hop_dong.ma_nhan_vien from hop_dong where hop_dong.ngay_lam_hop_dong = '2019-12-12'
    ) and nhan_vien.dia_chi like '% Hải Châu, %';
