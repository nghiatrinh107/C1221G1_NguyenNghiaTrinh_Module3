use furama;
# create view cap_nhat_gia as
#     select hop_dong_chi_tiet.ma_dich_vu_di_kem,sum(hop_dong_chi_tiet.so_luong) as so_lan_su_dung
# from hop_dong_chi_tiet inner join hop_dong on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
# where year(hop_dong.ngay_lam_hop_dong) =2020
# group by hop_dong_chi_tiet.ma_dich_vu_di_kem
# having so_lan_su_dung > 10;
# set sql_safe_updates =0;
# update dich_vu_di_kem
# set dich_vu_di_kem.gia = dich_vu_di_kem.gia*2
# where dich_vu_di_kem.ma_dich_vu_di_kem in (select ma_dich_vu_di_kem from cap_nhat_gia);
# set sql_safe_updates =1;














