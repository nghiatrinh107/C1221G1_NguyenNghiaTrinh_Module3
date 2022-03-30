create database bai_tap_vat_tu;
use bai_tap_vat_tu;
create table phieu_xuat(
so_px int auto_increment primary key ,
ngay_sx date
);
create table vat_tu(
ma_vt int auto_increment primary key ,
ten_vt varchar(50)
);
create table chi_tiet_px(
so_px int,
ma_vt int,
don_gia double,
so_luong int,
PRIMARY KEY (so_px,ma_vt ),
FOREIGN KEY (so_px) REFERENCES phieu_xuat(so_px),
FOREIGN KEY (ma_vt) REFERENCES vat_tu(ma_vt)
);
create table phieu_nhap(
so_pn int auto_increment primary key ,
ngay_nhap date
);
create table chi_tiet_pn(
so_pn int,
ma_vt int,
don_gia double,
so_luong int,
PRIMARY KEY (so_pn,ma_vt ),
FOREIGN KEY (so_pn) REFERENCES phieu_nhap(so_pn),
FOREIGN KEY (ma_vt) REFERENCES vat_tu(ma_vt)
);
create table don_dh(
so_dh int auto_increment primary key ,
ngay_dh date
);
create table chi_tiet_dh(
so_dh int,
ma_vt int,
PRIMARY KEY (so_dh,ma_vt ),
FOREIGN KEY (so_dh) REFERENCES don_dh(so_dh),
FOREIGN KEY (ma_vt) REFERENCES vat_tu(ma_vt)
);
create table nha_cc(
ma_ncc int auto_increment primary key ,
ten varchar(50),
dia_chi varchar(50),
sdt varchar(50)
);
create table sdt_nha_cc(
code_sdt int auto_increment primary key ,
sdt_ban varchar(50),
sdt_dd varchar(50),
ma_ncc int,
FOREIGN KEY (ma_ncc) REFERENCES nha_cc(ma_ncc)
);
alter table don_dh add ma_ncc int;
alter table don_dh add FOREIGN KEY (ma_ncc) REFERENCES nha_cc(ma_ncc);