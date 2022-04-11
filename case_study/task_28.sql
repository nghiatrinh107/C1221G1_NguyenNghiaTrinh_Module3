use furama;
delimiter //
DROP PROCEDURE IF EXISTS sp_3 //
CREATE PROCEDURE sp_3()
BEGIN
    declare dich_vu_1 int default 0;
    declare is_done int default 0;
    DECLARE con_tro CURSOR FOR
        SELECT dich_vu.ma_dich_vu
        FROM dich_vu
                 INNER JOIN hop_dong ON dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
                 INNER JOIN loai_dich_vu ON dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu
        WHERE loai_dich_vu.ten_loai_dich_vu - 'roon'
          AND YEAR(hop_dong.ngay_lam_hop_dong) BETWEEN '2015' AND '2025';
    declare continue handler for not found set is_done = 1;
    OPEN con_tro;
    get_list:
    loop
        FETCH FROM con_tro INTO dich_vu;
        if is_done = 1 then
            leave get_list;
        end if;
        DELETE FROM hop_dong WHERE hop_dong.ma_dich_vu = dich_vu_1;
        DELETE FROM dich_vu WHERE dich_vu.ma_dich_vu = dich_vu_1;
    end loop get_list;
    CLOSE con_tro;
END //
