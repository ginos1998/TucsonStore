-- returns enabled 'socio' and their email
DROP PROCEDURE IF EXISTS f_get_enabled_products;

CREATE PROCEDURE f_get_enabled_products(
    IN an_id_user INT
)
BEGIN
    select p.id_producto                                 as id_producto,
           p.producto                                    as producto,
           (select m.marca
            from marca m
            where m.id_marca = p.id_marca
              and m.id_user = an_id_user)                as marca,
           (select r.rubro
            from rubro r
            where r.id_rubro = p.id_rubro
              and r.id_user = an_id_user)                as rubro,
           (select sr.subrubro
            from subrubro sr
            where sr.id_subrubro = p.id_subrubro
              and exists(select 1
                         from rubro r
                         where r.id_user = an_id_user
                           and r.id_rubro = p.id_rubro)) as subrubro,
           p.precio                                      as precio,
           p.ctd_diponible                               as ctd_disponible
    from producto p
    where p.id_user = an_id_user
      AND p.habilitado = 'S';

END;