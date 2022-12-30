CREATE DEFINER=`react`@`localhost` PROCEDURE `count_gender_job`()
BEGIN
   select distinct(gender) dis_gender from customers;
    
    select dis_job as job, dis_gender as gender, 
   (select count(*) from customers where job = dis_job and gender = dis_gender) as count
   from
   (select distinct(job) dis_job from customers) tbl1,
   (select distinct(gender) dis_gender from customers) tbl2
   order by dis_job, dis_gender;

END