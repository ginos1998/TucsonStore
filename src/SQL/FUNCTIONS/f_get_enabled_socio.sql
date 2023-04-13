-- returns enabled 'socio' and their email
DROP PROCEDURE IF EXISTS f_get_enabled_socio;

CREATE PROCEDURE f_get_enabled_socio()
BEGIN

    select s.id_user as idUser, s.nombre, s.apellido, s.dni, u.email
    from socio s
             left join user u on u.id_user = s.id_user
    where u.enabled = 'S';

END;