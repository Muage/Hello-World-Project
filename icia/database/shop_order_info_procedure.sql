CREATE DEFINER=`shop`@`localhost` PROCEDURE `order_info`(
	in id char(4)
)
BEGIN
	SET @v_id = id;
	SET @sql1 = 'select * from purchase where order_id = ?';
    PREPARE ps FROM @sql1;
    EXECUTE ps USING @v_id;
    
    SET @sql1 = 'select * from order_prod where order_id = ?';
    PREPARE ps FROM @sql1;
    EXECUTE ps USING @v_id;
END