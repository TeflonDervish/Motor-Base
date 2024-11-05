CREATE FUNCTION SearchAnnoucements(
	@p_type VARCHAR(45) = NULL,
    @p_mark VARCHAR(45) = NULL, 
    @p_model VARCHAR(45) = NULL,
    @p_year_make INT = NULL,
    @p_run_to INT = NULL, 
	@p_run_from INT = NULL, 
	@p_color VARCHAR(45) = NULL,
	@p_type_body VARCHAR(45) = NULL,
	@p_gearbox VARCHAR(45) = NULL,
    @p_engine_powers_to INT = NULL,
	@p_engine_powers_from INT = NULL,
    @p_engine_volume_to DECIMAL(2, 1) = NULL,
	@p_engine_volume_from DECIMAL(2, 1) = NULL,
	@p_all_driver VARCHAR(45) = NULL,
	@p_price_from DECIMAL = NULL,
	@p_price_to DECIMAL = NULL,
	@p_date_from DATE = NULL,
	@p_date_to DATE = NULL
)
RETURNS @ResultTable TABLE (
    ID INT,
    name VARCHAR(45),
    description VARCHAR(45),
	price decimal,
	date date,
    type varchar(45),
	mark varchar(45),
	model varchar(45),
	year_make int,
	run int,
	color varchar(45),
	type_body varchar(45),
	gearbox varchar(45),
	engine_powers int,
	engine_volume decimal(2,1),
	all_driver varchar(45)
)
AS
BEGIN
    INSERT INTO @ResultTable
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
    WHERE
		(@p_type IS NULL OR C.type = @p_type) AND
        (@p_mark IS NULL OR C.mark = @p_mark) AND
        (@p_model IS NULL OR C.model = @p_model) AND
        (@p_year_make IS NULL OR C.year_make = @p_year_make) AND
        (@p_run_to IS NULL OR C.run <= @p_run_to) AND
		(@p_run_from IS NULL OR C.run >= @p_run_from) AND
		(@p_color IS NULL OR C.color = @p_color) AND
		(@p_type_body IS NULL OR C.type_body = @p_type_body) AND
		(@p_gearbox IS NULL OR C.gearbox = @p_gearbox) AND
		(@p_engine_powers_to IS NULL OR C.engine_powers <= @p_engine_powers_to) AND
		(@p_engine_powers_from IS NULL OR C.engine_powers >= @p_engine_powers_from) AND
		(@p_engine_volume_to IS NULL OR C.engine_volume <= @p_engine_volume_to) AND
		(@p_engine_volume_from IS NULL OR C.engine_volume >= @p_engine_volume_from) AND
		(@p_all_driver IS NULL OR C.all_driver = @p_all_driver) AND
        (@p_price_from IS NULL OR A.price >= @p_price_from) AND
        (@p_price_to IS NULL OR A.price <= @p_price_to) AND
		(@p_date_from IS NULL OR A.date >= @p_date_from) AND
        (@p_date_to IS NULL OR A.date <= @p_date_to);

    RETURN;
END;

drop function SearchAnnoucements


SELECT * 
FROM SearchAnnoucements(
    'легковой',      -- марка автомобиля
    NULL,       -- модель автомобиля
    NULL,          -- год выпуска от
    NULL,          -- год выпуска до
    NULL,      -- цена от
    NULL,       -- цена до
	NULL,          -- год выпуска от
    NULL,          -- год выпуска до
    NULL,      -- цена от
    NULL,       -- цена до
	NULL,          
    NULL,          
    NULL,
	NULL,
	NULL
);

