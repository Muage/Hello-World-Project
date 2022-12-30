CREATE DEFINER=`shop`@`localhost` PROCEDURE `list`(
	in i_table varchar(1000),
    in i_key varchar(100),
    in i_word varchar(100),
    in i_order varchar(100),
    in i_desc varchar(5),
    in i_page int,
    in i_per int
)
BEGIN
	SET @v_word = concat('%', i_word, '%');
    SET @v_start = (i_page - 1) * i_per;
	SET @v_sql = concat('select * from ', i_table, ' where ', i_key, ' like ? order by ', i_order, ' ', i_desc, ' limit ?, ', i_per);
    PREPARE ps from @v_sql;
    EXECUTE ps using @v_word, @v_start;
    
    SET @v_sql = concat('select count(*) total from ', i_table, ' where ', i_key, ' like ?');
    PREPARE ps from @v_sql;
    EXECUTE ps using @v_word;
END