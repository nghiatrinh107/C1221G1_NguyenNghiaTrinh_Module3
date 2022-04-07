use furama;
select nhan_vien.ma_nhan_vien, nhan_vien.ho_ten, ten_trinh_do, ten_bo_phan, nhan_vien.so_dien_thoai, nhan_vien.dia_chi,count(*) as so_lan
from nhan_vien inner join bo_phan bp on nhan_vien.ma_bo_phan = bp.ma_bo_phan
inner join trinh_do td on nhan_vien.ma_trinh_do = td.ma_trinh_do
inner join hop_dong hd on nhan_vien.ma_nhan_vien = hd.ma_nhan_vien
group by nhan_vien.ma_nhan_vien
having (so_lan <= 3) and  (nhan_vien.ma_nhan_vien  in (select hop_dong.ma_hop_dong from hop_dong where year(hop_dong.ngay_lam_hop_dong) between 2020 and 2021));