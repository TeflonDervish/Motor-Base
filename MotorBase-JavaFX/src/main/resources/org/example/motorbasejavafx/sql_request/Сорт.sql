CREATE PROCEDURE SortAnnouncements
    @sortBy VARCHAR(20) -- ¬озможные значени€: 'date_asc', 'date_desc', 'price_asc', 'price_desc'
AS
BEGIN
    DECLARE @sql NVARCHAR(MAX);

    -- Ѕазовый SQL-запрос без сортировки
    SET @sql = N'
        SELECT 
            A.ID,
            A.name,
            A.description,
            A.price,
			A.date,
            C.type,
            C.mark,
            C.model,
            C.year_make,
            C.run,
            C.color,
            C.type_body,
            C.gearbox,
            C.engine_powers,
            C.engine_volume,
            C.all_driver
        FROM 
            Annoucement A
        JOIN 
            Car C ON A.ID_car = C.ID
    ';

    -- ƒобавл€ем условие дл€ сортировки в зависимости от параметра
    IF @sortBy = 'price_asc'
        SET @sql = @sql + ' ORDER BY A.price ASC';
    ELSE IF @sortBy = 'price_desc'
        SET @sql = @sql + ' ORDER BY A.price DESC';
    ELSE IF @sortBy = 'date_asc'
        SET @sql = @sql + ' ORDER BY A.date ASC';
    ELSE IF @sortBy = 'date_desc'
        SET @sql = @sql + ' ORDER BY A.date DESC';
    ELSE
        SET @sql = @sql + ' ORDER BY A.price ASC'; -- сортировка по умолчанию

    -- ¬ыполн€ем динамический SQL-запрос
    EXEC sp_executesql @sql;
END;

drop procedure SortAnnouncements

exec SortAnnouncements 'date_desc'


