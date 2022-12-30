select * from tbl_camp;
select * from tbl_facility;
select * from tbl_type;

select * from tbl_camp_facility order by code;
drop view view_facility;

create view view_facility as
(select cf.*, fname
from tbl_camp_facility cf, tbl_facility f
where cf.fcode = f.fcode);

select * from view_facility order by code;

select * from tbl_camp_type;

create view view_type as(
select ct.*, tname
from tbl_camp_type ct, tbl_type t
where ct.tcode = t.tcode);

select * from view_type;

drop view view_type;

commit;

select * from tbl_type where tcode = 't10';

select max(tcode) mcode from tbl_type;

select * from tbl_camp order by code;
select max(code) from tbl_camp;

select * from tbl_camp where code = 'c100';
select * from view_facility where code = 'c100';
select * from view_type where code = 'c400';

select * from view_type where code = 'c100' and tcode = 't30';