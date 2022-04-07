use furama;
select nhan_vien.ma_nhan_vien as id, nhan_vien.ho_ten, 'nhân viên' as loai,nhan_vien.email,nhan_vien.so_dien_thoai,nhan_vien.ngay_sinh,nhan_vien.dia_chi from nhan_vien
union all
select khach_hang.ma_khach_hang as id, khach_hang.ho_ten, 'khách hàng' as loai,khach_hang.email,khach_hang.so_dien_thoai,khach_hang.ngay_sinh,khach_hang.dia_chi from khach_hang;