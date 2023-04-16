-- returns enabled 'socio' and their email
DROP PROCEDURE IF EXISTS f_get_enabled_products;

CREATE PROCEDURE f_get_enabled_products(
IN an_id_user INT
)
BEGIN
    select *
    from producto p
    where p.id_user=an_id_user AND
          p.habilitado = 'S';

END;