use furama;
set sql_safe_updates =0;
delete from nhan_vien
where nhan_vien.ma_nhan_vien not in (select ma_nhan_vien from (select distinct nhan_vien.ma_nhan_vien from nhan_vien
inner join hop_dong on nhan_vien.ma_nhan_vien = hop_dong.ma_nhan_vien
 where year(hop_dong.ngay_lam_hop_dong) between 2019 and 2021 ) as nhan_vien_co_hd);
set sql_safe_updates =1;
