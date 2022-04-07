use furama;
set sql_safe_updates =0;
update v_nhan_vien
set dia_chi = replace(dia_chi,'Hải Châu','Liên Chiểu')
where true;
set sql_safe_updates =1;